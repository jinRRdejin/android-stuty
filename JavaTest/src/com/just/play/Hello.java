package com.just.play;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Hello {
	
	

	public static void main(String[] args){
		

		/*
		 * ������������ת����double��8�ֽڣ���ת��Ϊint��4�ֽڣ�
		 */		
		double avg = 77.5;
		int rise =5;
		int avg2 = (int) (avg + rise);//ǿת���ݲ�����������ǽ�С���ֽ�ȥ��
		double arg3 = avg + rise;
		System.out.println(avg2 + "-" + arg3);
		/*
		 * ����������ı�����������ı�,һ���ô�д
		 */
		final String HELLO = "world";
		System.out.println(HELLO);
		/*
		 * ��ֵ�����
		 */
		int one = 10;
		int two = 20;
		two -= one;
		System.out.println(two);
		System.out.println(one > two);
		/*
		 * �� && || ! ^(����)
		 */
		System.out.println( (one > two) && one < two);
		/*
		 * ������������� ����
		 */
		
		String s = (2 > 1) ? "2����1" :"2С��1";
		System.out.println(s);
		//����ѭ�����ڻ���switch�����ʹ��break������ѭ��
		int num = 999;
		int count = 0;
		while(num != 0){
			count++;
			num /= 10;
		}
		System.out.println(count);
		
		int sum = 0;
		for(int i = 1; i <= 10; i++){
			if(i % 2 != 0){
				continue;
			}
		    sum = sum + i;
		    System.out.print("ż����" + i);
		}
		 System.out.println("ż��֮��" + sum);
		 
		 
		 int score = 53;
		 int cal = 0;
		 while(score <= 60){
			 score++;
			 cal++;
		 }
		 System.out.println(cal);
		//�ַ����� 
		 String[] str1 = new String[5]; //����һ������Ϊ5��String(�ַ���)�͵�һά����
		 String[] str2 = new String[]{"","","","",""};
		 String[] str3= {"","","","",""};
		 String[] str = new String[]{"sports"," read", " listen music"};

		 for(int i = 0; i < str.length; i++){		 
			 System.out.print(str[i]);			 
		 }
		 int arr[] = new int[3];
		 Arrays.fill(arr, 2);
		 Arrays.fill(arr, 0, 1, 7);
		 Arrays.sort(arr);
		 Arrays.copyOf(arr, 3);
		 long a = Runtime.getRuntime().totalMemory();
//		 Arrays.fill(array, start, end, value);
		 for (int i : arr) {
			System.out.print( "i =" + i + "\t");
		}
		 
		 
//		 Hello.compare();
//		 Hello.random();
//		 Hello.showTop3();
		 
//		 Hello.getNN();
//		 Hello.getint();
		 Hello.getMemory();

	}
	//һ�㷽����ҪСд��
	public static void compare(){
		
		int[] a = new int[]{61, 23, 4, 74, 13, 148, 20};
		int max = a[0];
		int min = a[0];
		for(int i = 0; i < a.length; i++){
			if(a[i] > max){
				max = a[i];
			}
			if(a[i] < min){
				min = a[i];
			}
			
		}
		System.out.println("max = " + max + " min = " + min);
		
		
	}
	/*
	 * 
	 * ���������� ������ͬһ�����У���������ͬ�������Ѿ�˳��ͬ
	 */
	public static int[] random(){
		
		int[] inte = new int[8];
		
		for(int i = 0; i < inte.length ; i++){
			inte[i] = (int) (Math.random()*100);
			System.out.print(inte[i] + " ");
		}
		return inte;	
	}
	
	public static void showTop3(){
		
		int[] scores = {89 , -23 , 64 , 91 , 119 , 52 , 73};
		Arrays.sort(scores);
		int num= 0;
		for(int i = scores.length - 1; i >= 0 ; i--){
			
			if( !(scores[i] >= 0 && scores[i] <=100)){
				continue;
			}
			num ++;	
			if(num > 3){
				break;
			}
			System.out.println(scores[i]);
			
		}
		
		
	}
	
	public static void getNN(){
		for(int i = 1; i <= 9; i++){
			for(int j = 1; j <= i; j++){
				System.out.print(j + "*" + i + "=" + i*j + "\t");// \t = " "
			}
			System.out.println();
			
		}	
	}
	public static int getint(){
		int a = 0;		
		if(a < 10){
			a++;
			return 0;
		}
		System.out.println(a);
		return a;	
	}
	
	public static void getMemory(){
		int num1 = 1024*1024*2;
		int arr1[] = new int[num1];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i;
		}
		//��ռ�ڴ浥λת��ΪMB
		long memory1 = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("memory1 = " + memory1);
		
		
		int num2 = 1024*1024;
		int arr2[][] = new int[num2][2];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i][0] = i;
			arr2[i][1] = i;		
		}
		long memory2 = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("memory2 = " + memory2);
	}
	
}
