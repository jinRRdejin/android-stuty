package com.just.play;

public class OuterClass {
	
	int x = 1;
	innerClass in = new innerClass();
	public void outf(){
		System.out.println("outf");
		in.inf();
	}
	public innerClass doit(){
//		y = 4;
		in.y = 4;
		System.out.println("doit");
		return new innerClass();
		
	}
	class innerClass{
		int y = 0;
		int x = 33;
		innerClass() {
		}
		public void inf(){
			System.out.println("inf");
		}
		public void io(int x){
			x++; //�β�
			this.x ++; //�ڲ������
			OuterClass.this.x ++; //�ⲿ�����
		}
	}
	public static void main(String[] args) {
		OuterClass out = new OuterClass();
//		new innerClass();
		OuterClass.innerClass oi = out.new innerClass();//ʵ�����ڲ������
		out.outf();
	    innerClass in = out.doit();
	    
	    //�����ڲ���
	    final String s1 = "С ��  Ů !";
	    IStringDeal is = new IStringDeal() {
			
			public String filterBlankhar() {
				String s2 = s1.replace(" ", "");
				return s2;
			}
		};
		System.out.println("s2 =" + is.filterBlankhar());
      Class cc = out.getClass();
      System.out.println("cc = " + cc);
      System.out.println(cc.getPackage());
      System.out.println(cc.getName());
	}

}
