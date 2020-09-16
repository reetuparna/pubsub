package test;

public class Broadcaster implements Runnable{
	Topic topic;
	
	Broadcaster(Topic t){
		topic = t;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				topic.DeliverMsg();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

