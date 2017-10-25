package com.test.jrr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class FileTest {
	
	   public static void ListDirect(File dir) throws IOException{
		   
		   if(!dir.exists()){
			  throw new IllegalArgumentException("�ļ�" + dir + "������");
		   }
		   if(!dir.isDirectory()){
			   throw new IllegalArgumentException( dir + "����Ŀ¼"); 
		   }
		   
		  /* String[] filesname = dir.list();   list��������Ŀ¼
		   for (String string : filesname) {
			System.out.println(string);
		}*/
		   
		   File[] filesName = dir.listFiles(); // ͨ���ݹ������ʾ��Ŀ¼
		   
		   if(filesName != null && filesName.length >0){
			   for (File file : filesName) {
				
				   if(file.isDirectory()){
					   ListDirect(file) ;
				   }else{
					   System.out.println(file);
				   }
			}
		   }
	   }
	   
	   public void fielspri(){
		   File files = new File("F:\\demo");
			if(!files.exists()){
				files.mkdir();
			}
			//�ж��Ƿ�Ϊһ��Ŀ¼
			System.out.println("��·���Ƿ�Ϊ·����" + files.isDirectory());
			System.out.println("�Ƿ�Ϊһ���ļ���" + files.isFile());
			
			File file2 = new File("F:\\demo\\demo.txt");
           System.out.println(file2);
           System.out.println(file2.getName());
           System.out.println(file2.getAbsolutePath());
	   }
	   
	   //randomAccessFile
	   public void TestRaf() throws IOException{
		   
		   File file = new File("D:\\demo");
		   if(!file.exists()){
			   file.mkdir();
		   }
		   File file2 = new File(file, "raf.java");
		   if(!file2.exists()){
			   file2.createNewFile();   
		   }
//		   Runtime.getRuntime().exec("chmod 777" + file2);
		   RandomAccessFile raf = new RandomAccessFile(file2, "rw");
		   System.out.println(raf.getFilePointer());
		   raf.write('A');//ֻ��д��һ���ֽ�
		   System.out.println(raf.getFilePointer());
		   int i = 0x7fffffff; //һ��int����4���ֽ�
		   raf.write(i>>>24);
		   raf.write(i>>>16);
		   raf.write(i>>>8);
		   raf.write(i);
		   System.out.println(raf.getFilePointer());
		   String s = "��";
		   byte [] utf = s.getBytes();
		   raf.write(utf);
		   System.out.println(raf.getFilePointer());
		   
		   //���ļ�������ļ�ָ��ŵ�ͷ��
		  raf.seek(0);
		  //һ�ζ�ȡ���ļ�ָ��ŵ��ֽ�������ȥ
		  byte[] bytes = new byte[(int) raf.length()];
		  raf.read(bytes);
		  System.out.println(Arrays.toString(bytes));
		  for (byte b : bytes) {
			System.out.println(Integer.toHexString(b & 0xff).toString());
		}
		  raf.close();
	   }
	   
	   //FileInputStream
	   public void TestFileInputStream(String fileName) throws IOException{
		   long startTime = System.currentTimeMillis();
		   FileInputStream fis = new FileInputStream(fileName);
		   int b = 0;
		   int i = 0;
		   int j = 1;
		   while((b = fis.read()) != -1){
			   if(b < 0xf){
				   System.out.print("0");
			   }
			   System.out.print(Integer.toHexString(b) + " ");
			   if(i ++ %10 == 0){
				   System.out.println();
			   }
		   }
 	   fis.close();
		  long endTime = System.currentTimeMillis();
		  System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");
		  
	   }
	   public void TestfisByArray(String fileName) throws IOException{
		   long startTime = System.currentTimeMillis();
		   FileInputStream fis = new FileInputStream(fileName);
		   int b = 0;
		   int i = 0;
		   int j = 1;
		   
		   //������ȡ
		   byte[] bytes = new byte[4 *1024];
		   while((b = fis.read(bytes, 0, bytes.length)) != -1){
			   for ( i = 0; i < bytes.length; i++) {
				   
				System.out.print(Integer.toHexString(bytes[i] & 0xff).toString());
				
				if(j ++ %10 == 0){
					   System.out.println();
				   }				   
			}	   
		   }
		   fis.close();
		   long endTime = System.currentTimeMillis();
		   System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");
	   }
	   
	   //�ļ���������
	   
	   public void TestcopyfilebyArray(File src,File des) throws IOException{
		   long startTime = System.currentTimeMillis();
		   if(!src.exists()){
			 throw new IllegalArgumentException("�ļ�" + src + "������");  
		   }
		   if(!src.isFile()){
				 throw new IllegalArgumentException( src + "�����ļ�");  
			   }
		   
		   FileInputStream in = new FileInputStream(src);
		   FileOutputStream out = new FileOutputStream(des);	   
		   byte[] bytes = new byte[8* 1024];
		   int b;
		   while((b = in.read(bytes, 0, bytes.length)) != -1){
			   out.write(bytes,0,b);
			   out.flush();
		   }
		   in.close();
		   out.close();
		   long endTime = System.currentTimeMillis();
		   System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");
	   }
	   
	   //�ַ������ļ���д
	   
	  public void testzifucopy(File src,File des) throws IOException{
		  
		  FileReader fr = new FileReader(src);
		  FileWriter fw = new FileWriter(des);
		  int b;
		  while ((b = fr.read()) != -1) {
			  fw.write(b);
			System.out.println(b);
		}
		  fr.close();
		  fw.close();
	  }
	   

		public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			FileTest ft = new FileTest();
//			ft.fielspri();
//			ListDirect(new File("F:\\CTVTest"));
			ft.TestRaf();
//			ft.TestFileInputStream("D:\\demo\\raf.java");
//			ft.TestfisByArray("D:\\demo\\raf.java");
//			ft.TestcopyfilebyArray(new File("D:\\demo\\default_video.mp4"), new File("D:\\demo\\default_video2.mp4"));
//			ft.testzifucopy(new File("D:\\demo\\raf.java"), new File("D:\\demo\\raf2.java"));
			
			
			StringBuffer sb = new StringBuffer();
			  char KeyASCII = 48;
			  sb.insert(sb.length(), KeyASCII );
//			  sb.delete(0, sb.length());
			  sb.append("$");
			  System.out.println(sb.toString());
	}

}
