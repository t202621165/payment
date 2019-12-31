package com.cypay.payment;

import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HttpsClientRequestFactory {

	public static void main(String[] args) throws Exception {
//		String url = "https://110.42.5.233:16888/man/authorize";
		String url = "https://110.42.5.233:16888/test-line";
//		String url = "https://192.168.0.169/test-line";
//		String url = "https://192.168.0.169/man/authorize";
		
		String CODE = "76d8e65ea5e5f01c87a490984ea51126";
//		String CODE = "sCVy4HGbYWBHOYa7wKtOD6c6wEjHLjXcIp+4xLNThLR8R3VwtQY2DB8CKkXuLnoZuWHs+UJaaqYMrmrDBo359S3rPufItb0rpp0Zr5wS4WFuk3/g2yH+kHxRlPd8LBWR.drJkMU1TtKiGY+xOeBEGUA==";
		MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("type", "0");
		requestBody.add("code", CODE);
		
		String result = "";
		RestTemplate restTemplate = restTemplate();
		
//		System.out.println("【GET】：");
//		result = restTemplate.getForObject(url, String.class, requestBody);
//		System.out.println(result);
		
		System.out.println("【POST】：");
		result = restTemplate.postForObject(url, requestBody, String.class);
		System.out.println(result);
	}

	public static RestTemplate restTemplate() {
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		return restTemplate;
	}

	/**
	 * Apache HttpClient
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @see [类、类#方法、类#成员]
	 */
	private static HttpClient httpClient() {
		// 创建socketFactory，跳过SSL证书校验
		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(SSLContexts.createDefault(), NoopHostnameVerifier.INSTANCE);
		// 支持HTTP、HTTPS
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory())
				.register("https", socketFactory).build();
		
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
		connectionManager.setMaxTotal(200);
		connectionManager.setDefaultMaxPerRoute(100);
		connectionManager.setValidateAfterInactivity(2000);
		
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(65000)
				.setConnectTimeout(5000).setConnectionRequestTimeout(1000).build();
		return HttpClientBuilder.create().setDefaultRequestConfig(requestConfig)
				.setConnectionManager(connectionManager).build();
	}
	
}
