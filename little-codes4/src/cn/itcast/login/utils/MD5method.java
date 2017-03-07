package cn.itcast.login.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5method {
	public static String md5(String str){
		byte[] secretBytes = null;
		try{
			secretBytes = MessageDigest.getInstance("md5").digest(str.getBytes());
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException("算法错误");
		}
		String  md5code = new BigInteger(1,secretBytes).toString(16);
		for(int i = 0; i < 32-md5code.length();i++){
			md5code = "0" + md5code;
		}
		return md5code;
	}
}







