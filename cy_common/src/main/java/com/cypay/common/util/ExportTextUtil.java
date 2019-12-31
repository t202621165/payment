package com.cypay.common.util;

import java.io.BufferedOutputStream;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class ExportTextUtil {
	/**
     * 导出文本文件
     * @param response
     * @param jsonString
     * @param fileName
     */
    public static void writeToTxt(HttpServletResponse response,Set<String> qqs,String fileName) {//设置响应的字符集
        //设置响应内容的类型
        response.setContentType("application/octet-stream;charset=utf-8");
        //设置文件的名称和格式
        response.addHeader("Content-Disposition",  
                "attachment;filename="+fileName+".txt");// filename指定默认的名字
        BufferedOutputStream buff = null;  
        StringBuffer write = new StringBuffer(); 
        ServletOutputStream outStr = null;  
        try {
        	outStr = response.getOutputStream();
            buff = new BufferedOutputStream(outStr);
            for (String qq : qqs){
            	 write.append(qq + "\r\n");          
            }
            buff.write(write.toString().getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {try {
                buff.close();
                outStr.close();
            } catch (Exception e) {
            	 System.out.println(e.getMessage());
            }
        }
    }

}
