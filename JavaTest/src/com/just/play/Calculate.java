package com.just.play;


 /*
  * Java�൥�̳У�ֻ����һ�����࣬�־�����Ҫ��̳У������˽ӿ�,һ�������ʵ�ֶ���ӿ�
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
