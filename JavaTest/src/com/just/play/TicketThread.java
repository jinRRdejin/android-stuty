package com.just.play;

public class TicketThread {

	
	public static void main(String[] args) throws InterruptedException {
	/*	T t = new T();
		Thread th1 = new Thread(t, "窗口1");
		Thread th2 = new Thread(t, "窗口2");
		Thread th3 = new Thread(t, "窗口3");
		th1.start();
		th2.start();
		th3.start();
		
		ThreadState ts = new ThreadState();
		Thread thread = new Thread(ts);
		System.out.println("新建线程：" +thread.getState());
		thread.start();
		System.out.println("启动线程：" +thread.getState());
		thread.sleep(100);
		System.out.println("记时等待：" +thread.getState());
		thread.sleep(1000);
		System.out.println("等待线程：" +thread.getState());
		ts.notifyNow();
		System.out.println("唤醒线程：" + thread.getState());
		thread.sleep(1000);
		System.out.println("终止线程：" + thread.getState() );*/
	/*
	 * 	包含主线程 a aa  aa加入，优先执行完aa线程
	 */
		A a = new A("小明");
		A aa = new A("小红");
		aa.start();
		aa.join();
		a.start();
		a.setPriority(1);  //优先级最小是1最大是10
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
						"卖了一张票还剩" + count +"张票");	
		   }
		}
	}
	
}

class ThreadState implements Runnable{
	public synchronized void waitForAScond() throws InterruptedException{
		wait(500);//wait后(等待0.5S)，需要别的线程执行notify/notifyAll才能够重新获得CPU执行时间。
	}
	public synchronized void waitForYear() throws InterruptedException{
		wait(); //永久等待，直到其他线程执行notify/notifyAll
	}
	public synchronized void notifyNow(){
		notify();//唤醒由wait方法进入休眠的线程
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
 * 线程的插入与终止
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



