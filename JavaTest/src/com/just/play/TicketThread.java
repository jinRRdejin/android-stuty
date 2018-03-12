package com.just.play;

public class TicketThread {

	
	public static void main(String[] args) throws InterruptedException {
	/*	T t = new T();
		Thread th1 = new Thread(t, "����1");
		Thread th2 = new Thread(t, "����2");
		Thread th3 = new Thread(t, "����3");
		th1.start();
		th2.start();
		th3.start();
		
		ThreadState ts = new ThreadState();
		Thread thread = new Thread(ts);
		System.out.println("�½��̣߳�" +thread.getState());
		thread.start();
		System.out.println("�����̣߳�" +thread.getState());
		thread.sleep(100);
		System.out.println("��ʱ�ȴ���" +thread.getState());
		thread.sleep(1000);
		System.out.println("�ȴ��̣߳�" +thread.getState());
		ts.notifyNow();
		System.out.println("�����̣߳�" + thread.getState());
		thread.sleep(1000);
		System.out.println("��ֹ�̣߳�" + thread.getState() );*/
	/*
	 * 	�������߳� a aa  aa���룬����ִ����aa�߳�
	 */
		A a = new A("С��");
		A aa = new A("С��");
		aa.start();
		aa.join();
		a.start();
		a.setPriority(1);  //���ȼ���С��1�����10
		aa.setPriority(2);
		System.out.println(a.getPriority() + ":" + aa.getPriority());
		
	}

}

class T implements Runnable{
	
	int count = 5;

	public void run() {
		synchronized (this) {
			while(count > 0){
				count --;
				System.out.println(Thread.currentThread().getName() + 
						"����һ��Ʊ��ʣ" + count +"��Ʊ");	
		   }
		}
	}
	
}

class ThreadState implements Runnable{
	public synchronized void waitForAScond() throws InterruptedException{
		wait(500);//wait��(�ȴ�0.5S)����Ҫ����߳�ִ��notify/notifyAll���ܹ����»��CPUִ��ʱ�䡣
	}
	public synchronized void waitForYear() throws InterruptedException{
		wait(); //���õȴ���ֱ�������߳�ִ��notify/notifyAll
	}
	public synchronized void notifyNow(){
		notify();//������wait�����������ߵ��߳�
	}

	public void run() {
		try {
			waitForAScond();
			waitForYear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

/*
 * �̵߳Ĳ�������ֹ
 */
class A extends Thread{
	int count = 0;
	
	
	public A(String name) {
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (true) {
			System.out.println(Thread.currentThread().getName()+ ":" + (++count));
		if(count ==20){
				break;
			}
		}
		
	}
}



