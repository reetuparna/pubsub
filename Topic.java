package test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topic {
	List<Subscriber> subs = new ArrayList();
	Deque<String> msgQueue = new LinkedList();
	int max = 5;
	
	synchronized void addMessage(String m) throws InterruptedException {
		while(msgQueue.size()==max){
			wait();
		}
		msgQueue.add(m);
		notify();
	}
	
	void addSub(Subscriber s) {
		subs.add(s);
	}

	synchronized void DeliverMsg() throws InterruptedException {		
		while(true) {
			notify();
			while(msgQueue.isEmpty()) {
				System.out.println("Waiting");
				wait();
			}
				
			
			while(!msgQueue.isEmpty())
			{
				System.out.println(msgQueue.size());
				String m = msgQueue.removeFirst();
				Thread.currentThread().sleep(10000);
				for(Subscriber sub:subs)
					sub.onMessage(m);
			}
		}
		
	}
}
