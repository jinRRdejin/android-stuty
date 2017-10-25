package com.test.jrr;

public class EncodeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s = "�ú�ѧϰjava";
		/*
		 * ���ֽ�ת����Int�͵ģ�����ʮ��������ʾ
		 * & 0xff��Ϊ�˰�ǰ���24��0ȥ��ֻ���º��λ,
		 * gbk���ͺ���ռ��2���ֽڣ�Ӣ����ĸռ��һ���ֽ�
		 * UTF-8����ռ��3���ֽڡ�Ӣ��ռ��һ���ֽ�
		 * utf-16be����ռ�������ֽڣ�Ӣ��ռ�������ֽ�
		 * */	
		byte[] bytes1 = s.getBytes();
		System.out.println("gbk��ʽ:" );
		for (byte b : bytes1) {
			System.out.println( Integer.toHexString(b & 0xff) + " ");
		}
		byte[] bytes2 = s.getBytes("UTF-8");
		System.out.println("UTF-8��ʽ:");
		for (byte b : bytes2) {
			System.out.println(Integer.toHexString(b & 0xff) + " ");
		}
		byte[] bytes3 = s.getBytes("utf-16be");
		System.out.println("utf-16be��ʽ:");
		for (byte b : bytes3) {
			System.out.println(Integer.toHexString(b & 0xff) + " ");
		}

	}

}
