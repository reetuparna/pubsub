package test;

public class Service {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Topic t = new Topic();
		Subscriber s1 = new Subscriber();
		Subscriber s2 = new Subscriber();
		t.addSub(s1);
		t.addSub(s2);
		System.out.print("Hello");
		Runnable p1 = new Publisher(t,1, 1000);
		Runnable p2 = new Publisher(t,2, 2000);
		Runnable b = new Broadcaster(t);
		System.out.print("Hello");
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(b);
		System.out.print("Hello");
		t1.start();
		t2.start();
		t3.start();
		System.out.print("Hello");
		try {
			t2.join();
			t1.join();
			t3.join();
			System.out.print("End");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
