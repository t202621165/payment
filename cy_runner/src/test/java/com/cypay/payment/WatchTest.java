package com.cypay.payment;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

import com.cypay.common.util.DUtil;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.watchers.DelayWatcher;

public class WatchTest {

	public static void main(String[] args) throws Exception {
		File file = FileUtil.file(System.getProperty("user.dir") + "\\watch.log");
		
		if (!file.exists()) {
			file.createNewFile();
		}
		System.out.printf("%s-开始监听文件：%s\r\n", Thread.currentThread().getName() , file.getName());
		WatchMonitor monitor = WatchMonitor.create(file, WatchMonitor.ENTRY_MODIFY);
		monitor.setWatcher(new DelayWatcher(new SimpleWatcher() {
			
			@Override
			public void onModify(WatchEvent<?> event, Path currentPath) {
				System.out.printf("%s-【%s】文件更新。path: %s\r\n", Thread.currentThread().getName(), DUtil.date(), currentPath);
			}
		}, 500));
		monitor.start();
		
		Thread.sleep(1000);
		
		FileWriter writer = new FileWriter(file);
		PrintWriter printWriter = writer.getPrintWriter(true);
		printWriter.append(String.format("【%s】-%s-文件更新。\r\n", DUtil.date(), Thread.currentThread().getName()));
		printWriter.flush();
		printWriter.close();
	}
}
