package com.just.play;

public class Paixu {

	/**
	 * Writer/Reader则是字符流    InputStream/OutputStream则是字节流   OutputStreamWriter 
	 * OutputStreamWriter/InputStreamReader 是转换流，指的是将字节流转化为字符
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paixu haha = new Paixu();
		haha.insertSort();
		haha.bubbleSort();
		haha.selectsort();
		haha.getString();
		haha.EandU();
		Cir cir = new Cir();
		float S = cir.getArea(1.22f);
		System.out.println("S = " + S);
	
		
	}
	
	//插入排序法 将要排序的值逐个插入到其合适的位置
	
	public void insertSort(){
		
		int arr[] = new int[]{20,40,90,30,80,70,50};
		int temp;
		int j;
	    for (int i = 1; i < arr.length; i++) {
	    	temp = arr[i];
	    	for(j = i - 1;j >=0 && arr[j] > temp; j-- ){	    		
	    		arr[j + 1] = arr[j];
	    	}
	    	arr[j+1] = temp;	
		}
		System.out.println("排序后：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	//冒泡排序法  通过两个相邻的元素进行比较大小，大的往后移动 依次从最后一个往前确定
	
	public void bubbleSort(){
		
		int arr[] = new int[]{63,4,24,1,3,13};
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {				
				if(arr[j+1] < arr[j]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}							
			}
			
		}
		System.out.println("冒泡排序后：");
		for (int i = 0; i < arr.length; i++) {
			
			
			System.out.print(arr[i] + "\t");
		}
		
	}
	
	//选择排序法  就是每次循环都选出最值
	
	public void selectsort(){
		
		int arr[] = new int[]{63,4,24,1,3,13};
		int temp;
		int k;
		for (int i = 0; i < arr.length -1 ; i++) {
			
			k = i;
			for (int j = i+1; j < arr.length; j++) {
				
				if(arr[j] < arr[k]){
					
					 k = j;
				}								
			}
			if(i != arr.length){
				
				temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
			
		}
		System.out.println("选择排序：");
		for (int i = 0; i < arr.length; i++) {
		
			System.out.print(arr[i] + "\t");
		}
		
	}
	
	
	//字符串的相关知识点
	
	public void getString(){
		String s = "we are worker";
		String f = "12345";
		System.out.println("字符w的位置" + s.indexOf("w") + s.lastIndexOf("w"));
		System.out.println("获取指定位置的索引" + s.charAt(4));
		System.out.println("去除字符串中的空格" + s.trim());//去除的是前导与尾部的空格
		System.out.println("取出所有空格" + s.replaceAll(" ", ""));//前为被替换的字符 后未替换字符
		System.out.println("替换字符的使用" + s.replace("worker", "student"));
		System.out.println("大小写替换" +s.toLowerCase() + ":" + s.toUpperCase());
		System.out.println("金额转换为大写"  );
		String a = new String("abc,def,ghi,gkl");
		String  aa[] =a.split(",");
		for (int i = 0; i < aa.length; i++) {
			System.out.print(aa[i]);
		}
		char[] c = f.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if( !Character.isDigit(c[i])){
				System.out.print("不是数字串");
				break;
			}
			System.out.print("是数字串");
		}
		//验证字符是否为回文
		String ii = "我爱我";
		StringBuilder sb = new StringBuilder(ii);
		sb.reverse();
		for (int i = 0; i <ii.length(); i++) {
			if(ii.charAt(i) != sb.charAt(i)){
				System.out.println("ii 不是回文");
				break;
			}
			System.out.println("ii 是回文");
			
		}
		
	
	}
	
	//给字符串加密
	public void EandU(){
		String value = "我爱java";
		char secret = '只';
		byte[] bt = value.getBytes();
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i]^(int)secret);
			
		}
		System.out.println(new String(bt));
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i]^(int)secret);			
		}
		System.out.println(new String(bt));
	}
	/*//ProsessBuilder 	
	public void Testpb(){
		String[] cmd = { "/system/bin/cat", "/sys/class/unifykeys/read" };
		ProcessBuilder builder = new ProcessBuilder(cmd);
		String workdirectory = "/system/bin/";
		builder.directory(new File(workdirectory));
		System.out.println(builder.toString());
	}*/
	//
	
	
	

}
