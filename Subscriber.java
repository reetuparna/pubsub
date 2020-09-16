package test;

public class Subscriber {
	void onMessage(String m) {
		System.out.println(m + " received at "+ System.currentTimeMillis());
	}
}
