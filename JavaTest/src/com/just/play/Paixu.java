package com.just.play;

public class Paixu {

	/**
	 * Writer/Reader�����ַ���    InputStream/OutputStream�����ֽ���   OutputStreamWriter 
	 * OutputStreamWriter/InputStreamReader ��ת������ָ���ǽ��ֽ���ת��Ϊ�ַ�
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
	
	//�������� ��Ҫ�����ֵ������뵽����ʵ�λ��
	
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
		System.out.println("�����");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	//ð������  ͨ���������ڵ�Ԫ�ؽ��бȽϴ�С����������ƶ� ���δ����һ����ǰȷ��
	
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
		System.out.println("ð�������");
		for (int i = 0; i < arr.length; i++) {
			
			
			System.out.print(arr[i] + "\t");
		}
		
	}
	
	//ѡ������  ����ÿ��ѭ����ѡ����ֵ
	
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
		System.out.println("ѡ������");
		for (int i = 0; i < arr.length; i++) {
		
			System.out.print(arr[i] + "\t");
		}
		
	}
	
	
	//�ַ��������֪ʶ��
	
	public void getString(){
		String s = "we are worker";
		String f = "12345";
		System.out.println("�ַ�w��λ��" + s.indexOf("w") + s.lastIndexOf("w"));
		System.out.println("��ȡָ��λ�õ�����" + s.charAt(4));
		System.out.println("ȥ���ַ����еĿո�" + s.trim());//ȥ������ǰ����β���Ŀո�
		System.out.println("ȡ�����пո�" + s.replaceAll(" ", ""));//ǰΪ���滻���ַ� ��δ�滻�ַ�
		System.out.println("�滻�ַ���ʹ��" + s.replace("worker", "student"));
		System.out.println("��Сд�滻" +s.toLowerCase() + ":" + s.toUpperCase());
		System.out.println("���ת��Ϊ��д"  );
		String a = new String("abc,def,ghi,gkl");
		String  aa[] =a.split(",");
		for (int i = 0; i < aa.length; i++) {
			System.out.print(aa[i]);
		}
		char[] c = f.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if( !Character.isDigit(c[i])){
				System.out.print("�������ִ�");
				break;
			}
			System.out.print("�����ִ�");
		}
		//��֤�ַ��Ƿ�Ϊ����
		String ii = "�Ұ���";
		StringBuilder sb = new StringBuilder(ii);
		sb.reverse();
		for (int i = 0; i <ii.length(); i++) {
			if(ii.charAt(i) != sb.charAt(i)){
				System.out.println("ii ���ǻ���");
				break;
			}
			System.out.println("ii �ǻ���");
			
		}
		
	
	}
	
	//���ַ�������
	public void EandU(){
		String value = "�Ұ�java";
		char secret = 'ֻ';
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
