package com.thinkgem.jeesite.common.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/** 
 * @文件名:DownloadUtil.java 
 * @功能描述：
 * @创建日期:2017年3月22日上午9:40:33 
 * @创建人：lijunke
 * @Copyright（c） 2017,all rights reserved by days 
 */
public class DownloadUtil {
	
	/**
	 * 
	 * @方法功能描述： 下载
	 * @param date
	 * @param filePath
	 * @param fileName
	 * @param suffix
	 * @throws IOException 
	 * void
	 * @author lijunke
	 * @创建时间： 2017年3月22日上午9:36:31
	 */
    public static byte[] download(String date,String filePath,String fileName,String suffix) throws IOException {
		List<Object> objlist = new ArrayList<Object>();
		if (null == date || date.equals("")) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			Date d = cal.getTime();
			date = new SimpleDateFormat("yyyy-MM-dd").format(d);
		}
		StringBuffer fn = new StringBuffer();
		fn.append(fileName).append(suffix);
		String localFileName = null;
		byte[] bytes = null;
		HttpHeaders headers = new HttpHeaders();
			localFileName = new String(fn.toString().getBytes("GBK"), "iso-8859-1");
			StringBuilder sb = new StringBuilder();
			// 根据时间从文件服务器上匹配文件
			sb.append(filePath).append(fileName).append(suffix);
			String realPath = sb.toString();
			File dirFile = new File(realPath);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", localFileName);
			bytes = FileUtils.readFileToByteArray(dirFile);
			objlist.add(bytes);
			objlist.add(headers);
			return bytes;
	}
}
