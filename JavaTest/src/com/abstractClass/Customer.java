package com.abstractClass;



/*
 * 多太的应用   简单的汽车销售商场
 * 
 */
abstract class Customer {
   
	
	public static void main(String[] args) {
		Car bwm = Factory.getCar("BWM");
		System.out.println("提取到的汽车为：" + bwm.getInfo());
		Car ben = Factory.getCar("BENz");
		System.out.println("提取到的汽车为：" + ben.getInfo());
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










