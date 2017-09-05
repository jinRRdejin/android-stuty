

1、使用this调用本类中的成员变量（属性）

   使用this这个关键字代表的就是类中的成员变量，又叫做类的属性。this.成员变量名，
   this也可以调用本类中的成员方法，在Java中一般引用成员方法的都是 对象名.成员方法。
   这主要是从便于代码的阅读考虑。一看到这个this关键字就知道现在引用的变量是成员变量或者成员方法，而不是 
   局部变量。

2、使用this调用构造方法

   当一个类中有多个构造方法时，可以利用this关键字相互调用。
  public class Student {
	
		private String name ; 
		private int age ; 
		
		
		public Student () { 
			
		this("李明",20);//调用有两个参数的构造方法

		System.out.println("新对象实例化") ; 
		
		} 
		
		public Student (String name) {
            this.name  = name ;
		}

		public Student (String name,int age) { 
		
			this(name); 
		    this.age = age ; 
		
		} 
		public String getInfo(){
           
			return "姓名：" + name + "，年龄：" + age ; 
		   }
   }
   	                Student stu1 = new Student ("李小明",19) ;
			System.out.println(stu1.getInfo()) ; 
			
3、使用this 引用当前对象

   public class Car {
	
	
	 public Car getCarObject(){ 
		 
		 return this; //返回当前对象
	 }

	 public static void main(String[] args) {
		 Car sc = new Car ();//创建一个Car对象 
		 
		 System.out.println( sc.getCarObject() instanceof Car);
		 //如果 object 是 class 的一个实例，则 instanceof 运算符返回 true
	 }

    }
4、其他，替代当前对象

    public class Students {
	
	private String name ; 
	private int age ; 
	
	public Students (String name, int age) {
		
		this.setName(name) ;
		this.setAge(age) ; 
		
	}

	public boolean compare(Students stu) { //调用此方法时里面存在两个对象：当前对象、传入的对象

	Students s1 = this ;//当前的对象，就表示stu1

	Students s2 = stu ;//传递进来的对象，就表示stu2

	if(s1==s2){// 判断是不是同一个对象，用地址比较

	return true ; 
	 
	 } //之后分别判断每一个属性是否相等 
	if(s1.equals(s2)&&s1.age==s2.age){
		
		return true ; //两个对象相等 
		
	}else{ 
		
		return false ; //两个对象不相等 
	 }

 }
	public void setName(String name){ //设置姓名  ; 
		this.name = name;
	}

	public void setAge (int age){//设置年龄 
		
		this.age = age ; 
		}


	public String getName(){ 
		return this.name; 
		
	} 
	public int getAge(){
		return this.age ; 
		
	}
	
}

 
		 Students stu1 = new Students ("李明",20) ; //声明两个对象，内容完全相等

		 Students stu2 = new Students ("李明",20) ; //声明两个对象，内容完全相等
		 
		 System.out.println(stu1);
		 System.out.println(stu2);

		 // 直接在主方法中依次取得各个属性进行比较

		 if(stu1.compare(stu2)){

		 System.out.println("两个对象相等！") ;

		 }else{ 
			 
			 System.out.println("两个对象不相等！") ;

		 } 
	 }



this.成员变量、this.成员方法(参数列表)：实际上都表示当 前对象中的属性或当前对象调用的方法；
this的核心表示当前对象，当前正在操作本方法的对象称为当前对象；使用this可以调用其他构造方法，但是此语句必须放在构造方法的首行
this的使用在 节省代码、区分局部变量与成员变量、对象的比较等方面起着重要的作用
























