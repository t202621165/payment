package com.cypay.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class FileUtil {	
	/**
	 * 文件上传
	 * @param file
	 * @param filePath
	 * @param fileName
	 * @throws Exception
	 */
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		FileOutputStream out = new FileOutputStream(filePath+"\\"+fileName);
		out.write(file);
		out.flush();
		out.close();
	}
	
	/**
	 * 文件下载
	 * @param filePath
	 * @param request
	 * @param response
	 */
	public static void fileDownload(String fileName,String filePath,HttpServletRequest request,HttpServletResponse response){
		if (!StringUtils.isEmpty(fileName)){
			File file = new File(filePath+"\\"+fileName);
			if (file.exists()){
				response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                   System.out.println(e.getMessage());
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                        	System.out.println(e.getMessage());
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                        	System.out.println(e.getMessage());
                        }
                    }
                }
			}
		}
	}
	
	/**
     * 生成导出附件中文名。应对导出文件中文乱码
     * <p>
     * response.addHeader("Content-Disposition", "attachment; filename=" + cnName);
     * 
     * @param cnName
     * @param defaultName
     * @return
     */
    public static String genAttachmentFileName(String cnName, String defaultName) {
        try {
//            fileName = URLEncoder.encode(fileName, "UTF-8");
            cnName = new String(cnName.getBytes("gb2312"), "ISO8859-1");
            /*
            if (fileName.length() > 150) {
                fileName = new String( fileName.getBytes("gb2312"), "ISO8859-1" );
            }
            */
        } catch (Exception e) {
            cnName = defaultName;
        }
        return cnName;
    }
}
