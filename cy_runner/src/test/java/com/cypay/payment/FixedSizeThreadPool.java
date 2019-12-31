package com.cypay.payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class FixedSizeThreadPool {

	/**
	 * 任务仓库
	 */
	private BlockingQueue<Runnable> blockingQueue;
	
	/**
	 * 工作线程容器
	 */
	private List<Thread> works;
	
	private boolean isWorking = true;
	
	/**
	 * 初始化线程池
	 * @param poolSize
	 * @param queueSize
	 */
	public FixedSizeThreadPool(int poolSize, int queueSize) {
		if (poolSize <= 0 || queueSize <= 0) {
			throw new IllegalArgumentException("非法参数");
		}
		
		this.blockingQueue = new LinkedBlockingDeque<Runnable>(queueSize);
		
		this.works = Collections.synchronizedList(new ArrayList<>());
		
		for (int i = 0; i < poolSize; i++) {
			Work work = new Work(this); // 实例化work对象
			work.start(); // 启动一个线程，从任务仓库中获取任务执行
			works.add(work);
		}
	}
	
	/**
	 * 工作线程，执行多个task
	 * @author International
	 * @2019年5月15日 下午4:56:15
	 */
	private static class Work extends Thread {
		
		private FixedSizeThreadPool pool;
		
		public Work(FixedSizeThreadPool pool) {
			this.pool = pool;
		}
		
		@Override
		public void run() {
			while (this.pool.isWorking || this.pool.blockingQueue.size() > 0) {
				Runnable task = null;
				
				try {
					if (this.pool.isWorking) {
						System.out.println("take...");
						task = this.pool.blockingQueue.take();
					} else {
						System.out.println("poll...");
						task = this.pool.blockingQueue.poll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (task != null) {
					task.run();
				}
			}
		}
	}
	
	/**
	 * 对外提供提交任务的接口（阻塞）
	 * @param task
	 * @return
	 */
	public boolean submit(Runnable task) {
		if (this.isWorking) {
			return this.blockingQueue.offer(task);
		}
		return false;
	}
	
	/**
	 * 对外提供提交任务的接口（非阻塞）
	 * @param task
	 * @return
	 */
	public void excute(Runnable task) {
		if (this.isWorking) {
			try {
				this.blockingQueue.put(task);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭线程
	 */
	public void shutdown() {
		this.isWorking = false;
		
		for (Thread task : works) {
			if (Thread.State.WAITING.equals(task.getState()) 
					|| Thread.State.BLOCKED.equals(task.getState())) {
				task.interrupt();
			}
		}
	}
	
	public static void main(String[] args) {
		FixedSizeThreadPool pool = new FixedSizeThreadPool(5, 10);
		for (int i = 0; i < 15; i++) {
			pool.submit(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("执行：【" + this + "】。");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
