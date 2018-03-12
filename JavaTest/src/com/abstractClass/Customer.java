package com.abstractClass;



/*
 * ��̫��Ӧ��   �򵥵����������̳�
 * 
 */
abstract class Customer {
   
	
	public static void main(String[] args) {
		Car bwm = Factory.getCar("BWM");
		System.out.println("��ȡ��������Ϊ��" + bwm.getInfo());
		Car ben = Factory.getCar("BENz");
		System.out.println("��ȡ��������Ϊ��" + ben.getInfo());
	}

}

class BWM extends Car{

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "BWM";
	}
	
}
class BENz extends Car{

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "BENz";
	}
	
}

class Factory{
	public static Car getCar(String name){
		if(name.equals("BWM")){
			return  new BWM();
		}else if(name.equals("BENz")){
			return  new BENz();
		}else{
			return null;	
		}
	}
}










