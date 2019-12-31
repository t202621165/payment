package com.cypay.common.pattern.template.payee.wechat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

/**
 * This example demonstrates how to create secure connections with a custom SSL
 * context.
 */
public class ClientCustomSSL {
	
	/**
	 * 安全证书存放路径
	 */
	private static final String SSL_PATH;
	
	static {
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		SSL_PATH = path.replace("file:/", "").trim() + "apiclient_cert.p12";
	}
	
    public static String SSL(String url, WechatPayRequest wechat, String charset) throws Exception {
        StringBuffer bf = new StringBuffer();
        char[] mchid_char = wechat.getMchid().toCharArray();
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(SSL_PATH));
        try {
            keyStore.load(instream, mchid_char);
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslContext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, mchid_char).build();
        
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = 
        		new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" }, 
        				null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        
        CloseableHttpClient httpclient = 
        		HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {

            HttpPost httpPost = new HttpPost(url);
            StringEntity reqEntity = new StringEntity(wechat.toString(), "GBK");
            httpPost.setEntity(reqEntity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(),charset));
                    String content;
                    while ((content = bufferedReader.readLine()) != null) {
                    	bf.append(content);
                    }
                }
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return bf.toString();
    }
}
