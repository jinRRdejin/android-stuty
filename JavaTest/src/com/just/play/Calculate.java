package com.just.play;


 /*
  * Java类单继承，只能有一个父类，又经常需要多继承，就有了接口,一个类可以实现多个接口
  * 
  */
public interface Calculate {
	final float PI = 3.14149f;
    float getArea(float r);
    float getCircuference(float r);
}
 
class Cir implements Calculate{

	public float getArea(float r) {
		float S = r*r*PI;
		return S;
	}

	public float getCircuference(float r) {
		float C = r*2*PI;
		return C;
	}
	
}
