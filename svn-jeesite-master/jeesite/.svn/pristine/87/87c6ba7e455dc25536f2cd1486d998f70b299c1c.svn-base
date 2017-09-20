package com.thinkgem.jeesite.common.utils;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by Administrator on 2017/6/15.
 */
public class FileUtil {
    private static Logger logger = Logger.getLogger(FileUtil.class);
    /***
     * 获取写入流
     * @param filePath 输出目录 保证目录已存在
     * @param encode 文件编码
     * @return
     * @throws Exception
     */
    public static BufferedWriter getBufferedWriter(String filePath,String encode) throws Exception {
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, encode);
        BufferedWriter bw = new BufferedWriter(osw);
        return bw;
    }

    /***
     *自动关闭 被包装对象 fos  osw
     * @param bw 流对象
     * @throws IOException
     */
    public static void closeBufferedWriter(BufferedWriter bw)  {
        if(null!=bw){
            try {
                bw.close();
            } catch (IOException e) {
                logger.error("关闭流失败：closeBufferedWriter"+e);
            }
        }
    }
}
