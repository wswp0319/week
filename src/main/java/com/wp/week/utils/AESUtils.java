package com.wp.week.utils;

import com.google.common.base.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class AESUtils {
	public static Logger logger = LoggerFactory.getLogger(AESUtils.class);


	/**
	 * 对称加密
	 * @param input
	 * @param key
	 * @return
	 */
	public static String encrypt(String input){
		byte[] crypted = null;
		try{
			SecretKeySpec skey = new SecretKeySpec("6CFF1695053213C2".getBytes(Charsets.UTF_8), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			crypted = cipher.doFinal(input.getBytes(Charsets.UTF_8));
		}catch(Exception e){
			logger.info("AES encrypt error",e);
		}
		return new String(Base64.encodeBase64(crypted));
	}

	/**
	 * 对称解密
	 * @param input
	 * @param key
	 * @return
	 */
	public static String decrypt(String input){
		byte[] output = null;
		try{
			SecretKeySpec skey = new SecretKeySpec("6CFF1695053213C2".getBytes(Charsets.UTF_8), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			output = cipher.doFinal(Base64.decodeBase64(input));
		}catch(Exception e){
			logger.info("AES decrypt error",e);
		}
		return new String(output);
	}
}

