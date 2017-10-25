package com.test.jrr;

public class EncodeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s = "好好学习java";
		/*
		 * 将字节转换成Int型的，并以十六进制显示
		 * & 0xff是为了把前面的24个0去掉只留下后八位,
		 * gbk类型汉字占用2个字节，英语字母占用一个字节
		 * UTF-8汉字占用3个字节。英语占用一个字节
		 * utf-16be汉字占用连个字节，英语占用两个字节
		 * */	
		byte[] bytes1 = s.getBytes();
		System.out.println("gbk格式:" );
		for (byte b : bytes1) {
			System.out.println( Integer.toHexString(b & 0xff) + " ");
		}
		byte[] bytes2 = s.getBytes("UTF-8");
		System.out.println("UTF-8格式:");
		for (byte b : bytes2) {
			System.out.println(Integer.toHexString(b & 0xff) + " ");
		}
		byte[] bytes3 = s.getBytes("utf-16be");
		System.out.println("utf-16be格式:");
		for (byte b : bytes3) {
			System.out.println(Integer.toHexString(b & 0xff) + " ");
		}

	}

}
