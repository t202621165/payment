package com.cypay.common.to;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.cypay.common.config.InitialLoader;
import com.cypay.common.util.CommonUtil;

public class GatewayIni implements Serializable {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final long serialVersionUID = 1L;

	/** 是否开启订单补发 */
	private boolean send = true;

	/** 网关开机自启 */
	private boolean auto = true;

	/** 默认通讯端口 */
	private int port = 6880;

	/** 通讯密钥 */
	private String key;

	/** 签名密钥 */
	private String code;

	/** 平台网站 */
	private String url;

	/** 是否开启日志 */
	private boolean log = true;

	public GatewayIni() {

	}

	public GatewayIni(String key, String code,String domain,HttpServletRequest request) {
		logger.info("网关通信域名:{}",InitialLoader.communicationUrl);
		this.key = key;
		this.code = code;
		this.url = StringUtils.isEmpty(InitialLoader.communicationUrl) ? domain : InitialLoader.communicationUrl;
	}

	public void download(HttpServletResponse response, String version, Integer type) {
		String filePath = Thread.currentThread().getContextClassLoader().getResource("").toString();
		filePath = filePath.replace("file:/", "").trim();
		filePath = filePath.replace("/", "\\").trim();
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=Gate.zip");
		ZipOutputStream out = null;
		try {
			FileInputStream fis = null;			
			File[] files = new File[5];
			out = new ZipOutputStream(response.getOutputStream());
			intoZip(out, version);
			if (type == 1 || type == 2) {
				files[0] = new File(filePath + "//gate.exe");
				files[1] = new File(filePath + "//libeay32.dll");
				files[2] = new File(filePath + "//ssleay32.dll");
				for (File cqcs : files) {
					out.putNextEntry(new ZipEntry(cqcs.getName()));
					fis = new FileInputStream(cqcs);
					read(out,fis);
				}
			}
			if (type == 0) {
				files[0] = new File(filePath + "//Sql.exe");
				files[1] = new File(filePath + "//dbxmys.dll");
				files[2] = new File(filePath + "//libmysql.dll");
				files[3] = new File(filePath + "//libeay32.dll");
				files[4] = new File(filePath + "//ssleay32.dll");
				for (File ty : files) {
					out.putNextEntry(new ZipEntry(ty.getName()));
					fis = new FileInputStream(ty);
					read(out,fis);
				}
			}
			
			if (type == 3){
				files[0] = new File(filePath + "//cq3.exe");
				files[1] = new File(filePath + "//libeay32.dll");
				files[2] = new File(filePath + "//ssleay32.dll");
				for (File cq3 : files) {
					out.putNextEntry(new ZipEntry(cq3.getName()));
					fis = new FileInputStream(cq3);
					read(out,fis);
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
	}
	
	public void read(ZipOutputStream out,FileInputStream fis){
		try{
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = fis.read(buffer)) > 0) {
				out.write(buffer, 0, len);
				out.flush();
			}
			out.closeEntry();
			fis.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void intoZip(ZipOutputStream out, String version) throws IOException {
		ZipEntry entry = new ZipEntry("gate.ini");
		out.putNextEntry(entry);
		out.write(
				CommonUtil
						.getBufferString("[SYS]\r\n", "log=", log, "\r\nsend=", send, "\r\nauto=", auto, "\r\nport=",
								port, "\r\nversion=", version, "\r\nurl=", url, "\r\nkey=", key, "\r\ncode=", code)
						.getBytes());
		out.closeEntry();
	}

	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

	public boolean isAuto() {
		return auto;
	}

	public void setAuto(boolean auto) {
		this.auto = auto;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	@Override
	public String toString() {
		return "GatewayIni [send=" + send + ", port=" + port + ", key=" + key + ", code=" + code + ", url=" + url
				+ ", log=" + log + "]";
	}

}
