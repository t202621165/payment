package com.cypay.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSON;
import com.cypay.common.vo.Result;

import cn.hutool.json.JSONUtil;

public enum SocketTemplate {
	
	SMS;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 向网关发送数据
	 * @param ip
	 * @param port
	 * @param data
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public Result send(String ip, Integer port, String data) {
		/** 发送字符串用base64转码 */
		//data = "#"+ new String(Base64Utils.encode(data.getBytes()))+"*";
		try {
			data = "#" + Base64Utils.encodeToString(data.getBytes("GBK"))+ "*";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Socket socket = null;
		OutputStream socketOut = null;
		BufferedReader br = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(ip, port), 40000); // 连接超时时间10s
			socket.setSoTimeout(40000);// 设置读操作超时时间10s
			socketOut = socket.getOutputStream();
			// 发送消息
			socketOut.write(data.getBytes());
			socketOut.flush();

			// 接收服务器的反馈
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"GBK"));
			return JSONUtil.toBean(br.readLine(), Result.class);
		} catch (IOException e) {
			log.info(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				
				if (socketOut != null)
					socketOut.close();

				if (socket != null)
					socket.close();
			} catch (IOException e) {
				log.info(e.getMessage());
			}
		}
		return Result.error("网关通讯异常！");
	}
	
	/**
	 * 向网关发送数据
	 * @param ip
	 * @param port
	 * @param obj
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public Result send(String ip, Integer port, Object obj) {
		return send(ip, port, JSON.toJSONString(obj));
	}
}
