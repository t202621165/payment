package com.cypay.payment;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	
	public static AtomicInteger i = new AtomicInteger(0);
	
	public static AtomicInteger c = new AtomicInteger(65);
	
	public static void main(String[] args) throws InterruptedException {
//		InTurnsPrint.print();
		
		InTurnsPrint2.print();
	}
	
}
class InTurnsPrint extends Thread {

	private String title;
	
	private boolean flag;
	
	private int threshold = 90;
	
	private static final AtomicInteger NUMBER = new AtomicInteger(65);
	
	public InTurnsPrint(String title, boolean flag) {
		this.title = title;
		this.flag = flag;
	}
	
	public static void print() {
		new InTurnsPrint("线程一", true).start();
		
		new InTurnsPrint("线程二", false).start();
	}
	
	@Override
	public void run() {
		synchronized (NUMBER) {
			while (NUMBER.intValue() <= this.threshold) {
				if (this.isPrint()) {
					System.out.printf("%s：%s\r\n", this.title, (char)NUMBER.intValue());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					NUMBER.incrementAndGet();
					NUMBER.notifyAll();
				} else {
					try {
						NUMBER.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private boolean isPrint() {
		if (this.flag) {
			return NUMBER.intValue() % 2 != 0;
		}
		
		return NUMBER.intValue() % 2 == 0;
	}
}
class InTurnsPrint2 extends Thread {

	private String title;
	
	private boolean flag;
	
	private int threshold = 52;
	
	private static final AtomicInteger NUMBER = new AtomicInteger(1);
	
	public InTurnsPrint2(String title, boolean flag) {
		this.title = title;
		this.flag = flag;
	}
	
	public static void print() {
		new InTurnsPrint2("数字线程", true).start();
		
		new InTurnsPrint2("字母线程",false).start();
	}
	
	@Override
	public void run() {
		synchronized (NUMBER) {
			while (NUMBER.intValue() <= this.threshold) {
				if (this.isPrint()) {
					if (flag) {
						System.out.printf("%s： %s\r\n", title, NUMBER.intValue());
						System.out.printf("\t%s\r\n", NUMBER.intValue() + 1);
					} else {
						System.out.printf("%s： %s\r\n", title, (char)(NUMBER.intValue()/2+64));
					}
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					NUMBER.incrementAndGet();
					NUMBER.notifyAll();
				} else {
					try {
						NUMBER.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private boolean isPrint() {
		if (this.flag) {
			return NUMBER.intValue() % 2 != 0;
		}
		
		return NUMBER.intValue() % 2 == 0;
	}
}