package com.just.play;

import java.awt.Color;

public class Cat {
	private String name;
	private int age;
	private double weight;
	private Color coler;
	
	
	
	public Cat(String name, int age, double weight, Color coler) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.coler = coler;
	}
   


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((coler == null) ? 0 : coler.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (age != other.age)
			return false;
		if (coler == null) {
			if (other.coler != null)
				return false;
		} else if (!coler.equals(other.coler))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat1 = new Cat("java", 12, 21, Color.BLACK);
		Cat cat2 = new Cat("C++", 12, 21, Color.WHITE);
		Cat cat3 = new Cat("java", 12, 21, Color.BLACK);
		System.out.println("cat1 hash值 = " + cat1.hashCode());
		System.out.println("cat2 hash值 = " + cat2.hashCode());
		System.out.println("cat3 hash值 = " + cat3.hashCode());
		System.out.println("cat1 与cat2 是否相同" + cat1.equals(cat2));
		System.out.println("cat3 与cat1 是否相同" + cat3.equals(cat1));
		
		String a = "123";
		String b = "123";
		String c = new String("123");
		System.out.println(a.equals(b) + ":" +c.equals(a)) ;
		
		
	}

}
