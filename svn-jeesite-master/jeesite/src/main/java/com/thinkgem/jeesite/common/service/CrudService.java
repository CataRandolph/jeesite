/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.common.service;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.*;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.FTPClientUtil;
import com.thinkgem.jeesite.common.utils.FileUtil;
import com.thinkgem.jeesite.common.utils.StringUtil;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.persistence.Page;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

/**
 * Service基类
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) {
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}

	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
		if (entity.getIsNewRecord()){
			entity.preInsert();
			dao.insert(entity);
		}else{
			entity.preUpdate();
			dao.update(entity);
		}
	}

	@Transactional(readOnly = false)
	public int saveReturnId(T entity) {
		int id;
		if (entity.getIsNewRecord()){
			entity.preInsert();
			id = dao.insert(entity);
		}else{
			entity.preUpdate();
			id = dao.update(entity);
		}
		return id;
	}
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}

	/**
	 * 中奖状态设置
	 */
	public String prizeStatus(Integer flag){
		String isWinPrize="";
		switch (flag) {
			case -1:
				isWinPrize="未开奖";
				break;
			case -2:
				isWinPrize="已开奖";
				break;
			case 1:
				isWinPrize="已中奖";
				break;
			case 0:
				isWinPrize="未中奖";
				break;
		}
		return isWinPrize;
	}

/**================txt文件导出模块===================================**/

	/**
	 * 验证路径是否存在
	 * @param file
	 */
	public File createFile(File file) {
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs(); // 创建目录
		}
		return file;
	}

	/**
	 * txt写入
	 * @param bw
	 * @param info
	 * @param one
	 * @param names
	 */
	public void writeTxt(BufferedWriter bw, JSONObject info, boolean one, String[] names) throws IOException {
		int l = names.length;
		int i = 1;
		if (one) {
			bw.write(l + "");
			bw.newLine();
			for (int j = 1; j <= names.length; j++) {
				bw.write(names[j - 1]);
				if (i != l) {
					bw.write("\t");
				}
				i++;
			}
			bw.newLine();
		}
		String value = "";
		for (int j = 1; j <= names.length; j++) {
			value = info.get(names[j - 1]) + "";
			if (StringUtil.isBlankOrEmpty(value) || "null".equals(value)) {
				value = "\\N";
			}
			bw.write(StringUtil.replaceSpecialNotationNoBlank(value.trim()));
			if (j != l) {
				bw.write("\t");
			}
		}
		bw.newLine();
	}


	/**
	 * 上传至服务器
	 * @param file
	 * @param dateStr
	 * @return
	 */
	public void uploadFtp(File file, String dateStr) {
		try {
			String ftpServer = Global.getConfig( "account.ftpServer" ).trim();
			String ftpUserName = Global.getConfig( "account.ftpUserName" ).trim();
			String ftpPassWord = Global.getConfig( "account.ftpPassWord" ).trim();
			String ftpUpLoadPath = Global.getConfig( "account.ftpUpLoadPath" ).trim()+ "/" + dateStr;
			String ftpDownLoadPath = Global.getConfig( "account.ftpDownLoadPath" ).trim();
			String isPasv = Global.getConfig( "account.ftpIsPasv" ).trim();
			Integer ftpPort = Global.getConfig( "account.ftpPort" ).trim() == null ? 21 : Integer.valueOf((String) Global.getConfig( "account.ftpPort" ).trim());
			Boolean transMode = null == isPasv ? true : isPasv.equals("Pasv") ? true : false;

			Map<String, Object> serverCfg = new HashMap<String, Object>();
			serverCfg.put("SERVER_IP", ftpServer);
			serverCfg.put("SERVER_PORT", ftpPort);
			serverCfg.put("IS_ANONYMOUS", false);
			serverCfg.put("USER_NAME", ftpUserName);
			serverCfg.put("PASSWORD", ftpPassWord);
			serverCfg.put("IS_PASV", transMode);
			serverCfg.put("UPLOAD_PATH", ftpUpLoadPath);
			serverCfg.put("DOWNLOAD_PATH", ftpDownLoadPath);
			logger.info("-------------------开始FTP上传操作，参数为：ftpServer：" + ftpServer + "ftpUserName:" + ftpUserName + "ftpUpLoadPath=" + ftpUpLoadPath);
			FTPClient fc = FTPClientUtil.getFtpClient(serverCfg);
			if (!fc.changeWorkingDirectory(Global.getConfig("account.ftpUpLoadPath"))) {
				fc.makeDirectory(Global.getConfig("account.ftpUpLoadPath"));
			}
			if (!fc.changeWorkingDirectory(ftpUpLoadPath)) {
				fc.makeDirectory(ftpUpLoadPath);
			}
			fc.logout();
			fc.disconnect();
			FtpClient ftp =connectFTP(ftpServer,ftpPort,ftpUserName,ftpPassWord);
			String []flags= file.getName().split("_");
			String flag ="_"+flags[3].substring(0,1);
			int no= getLastModifyFileName(ftp,ftpUpLoadPath,file.getName());
			String name = file.getName().replace(flag,"_"+no);
			FTPClientUtil.upload(serverCfg, file, name);
		} catch (Exception e) {
			logger.error("上传ftp失败：", e);
		}
	}

	/**
	 * 根据文件排序，获取最大批次号
	 *
	 * @param ftp
	 * @param dir
	 * @param tfpFileName
	 * @return
	 */
	private  Integer getLastModifyFileName(FtpClient ftp, String dir, String tfpFileName) {
		List<Integer> screenList = new ArrayList<>();
		String[] demo = tfpFileName.split("\\.");
		int a = demo[0].lastIndexOf("_");
		tfpFileName =demo[0].substring(0,a);
		try {
			ftp.changeDirectory(dir);
			List<String> fileNameList = getFileList(ftp, dir);
			if (null != fileNameList && fileNameList.size() > 0) {
				for (String str : fileNameList) {
					if (str.contains(tfpFileName)) {
						String[] strSplit = str.split("\\.");
						int index = strSplit[0].lastIndexOf("_");
						String lastStr = strSplit[0].substring(index + 1, strSplit[0].length());
						screenList.add(Integer.parseInt(lastStr));
					}
				}
				Collections.sort(screenList, new Comparator<Integer>() {
					@Override
					public int compare(Integer integer1, Integer integer2) {
						Integer i1 = integer1;
						Integer i2 = integer2;
						return i2.compareTo(i1);
					}
				});
			} else {
				logger.info("当前FTP目录" + dir + "下不存在任何文件！");
				return 0;
			}
		} catch (FtpProtocolException e) {
			logger.info("文件不存在！");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(screenList.size()==0){
			return 1;
		}
		return screenList.get(0)+1;
	}

	/**
	 * 取得相对于当前连接目录的某个目录下所有文件列表
	 *
	 * @param path
	 * @return
	 * @throws FtpProtocolException
	 */
	private List<String> getFileList(FtpClient ftpClient, String path) throws FtpProtocolException {
		List<String> list = new ArrayList<>();
		DataInputStream dis;
		try {
			dis = new DataInputStream(ftpClient.nameList(path));
			String filename = "";
			while ((filename = dis.readLine()) != null) {
				list.add(filename);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 连接ftp服务器 JDK 1.7
	 *
	 * @param url
	 * @param port
	 * @param username
	 * @param password
	 */
	public  FtpClient connectFTP(String url, int port, String username, String password) { //创建ftp
		FtpClient ftp = null;
		try {
			//创建地址
			SocketAddress addr = new InetSocketAddress(url, port);
			//连接
			ftp = FtpClient.create();
			ftp.connect(addr);
			//登陆
			ftp.login(username, password.toCharArray());
			ftp.setBinaryType();
			System.out.println(ftp.getWelcomeMsg());
		} catch (FtpProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ftp;
	}
}