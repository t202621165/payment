package com.cypay.common.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码生成工具
 * @author International
 * @2019年3月16日 下午4:02:16
 */
public class QRCodeUtil {
	
	private static final String CHARSET = "UTF-8";
	
	private static final String FORMAT_NAME = "PNG";
    /**二维码默认尺寸*/
    private static final int QRCODE_SIZE = 250;

	private QRCodeUtil() {
		throw new IllegalStateException("Utility Class: " + this.getClass());
	}
	
	/**
	 * 生成二维码-默认尺寸 250 x 250
	 * @param content
	 * @param response
	 */
	public static void createQRCode(String content, HttpServletResponse response) {
		createQRCode(content, response, QRCODE_SIZE, QRCODE_SIZE);;
	}

	/**
	 * 生成二维码-自定义二维码尺寸
	 * @param content
	 * @param response
	 * @param width
	 * @param height
	 */
	public static void createQRCode(String content, HttpServletResponse response, int width, int height) {
		ServletOutputStream stream = null;
		try {
			stream = response.getOutputStream();
			Map<EncodeHintType, Object> hints = new HashMap<>();
			// 编码
			hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
			// 设置二维码排错率
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
			// 边框距
			int margin = (content.length() > 13 && content.length() < 26) ? 1 : 0;
			hints.put(EncodeHintType.MARGIN, margin);
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bm = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			BufferedImage bufImg = new BufferedImage(bm.getWidth(), bm.getHeight(), BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < width; x++) {  
	            for (int y = 0; y < height; y++) {  
	            	bufImg.setRGB(x, y, bm.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);  
	            }  
	        }
			ImageIO.write(bufImg, FORMAT_NAME, stream);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.flush();
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
