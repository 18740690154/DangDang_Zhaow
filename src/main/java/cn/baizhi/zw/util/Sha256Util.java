package cn.baizhi.zw.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Util {

	/**
	 * 利用java原生的类实现SHA256加密
	 * 
	 * @param str
	 *            加密后的报文
	 * @return
	 */
	public static String getSHA256(String str) {
		MessageDigest messageDigest;
		String encodestr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodestr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodestr;
	}

	/**
	 * 将byte转为16进制
	 * 
	 * @param bytes
	 * @return
	 */
	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				// 1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}

	// 测试
	public static void main(String[] args) {
		// ===111111===bcb15f82 1479b4d5 772bd0ca 866c00ad 5f926e35 80720659
		// cc80d39c 9d09802a
		String sha256 = Sha256Util.getSHA256("111111");
		System.out.println("====" + sha256);
	}
}