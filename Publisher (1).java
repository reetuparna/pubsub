package test;

import java.util.Date;
import java.util.UUID;

public class Publisher implements Runnable{
	Topic topic;
	int id;
	int s;
	
	Publisher(Topic t, int id, int sDur){
		topic = t;
		this.id =id;
		s = sDur;
	}
	
	@Override
	public void run() {
		System.out.println("Publisher "+id);
		while(true) {
			try {
				System.out.println("P"+id+" adding at "+ System.currentTimeMillis());
				topic.addMessage("I am pub"+id+ " writing "+ UUID.randomUUID());
				Thread.currentThread().sleep(s);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
