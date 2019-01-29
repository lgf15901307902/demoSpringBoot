package net.xdclass.demo.task.controller;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.xdclass.demo.task.domain.JsonData;
import net.xdclass.demo.task.task.AsyncTask;

 


@RestController
@RequestMapping("/api/v1")
public class taskController {

	
	@Autowired
	private AsyncTask task;
	
	@GetMapping("async_task")
	public JsonData exeTask() throws InterruptedException{
		
		long begin = System.currentTimeMillis();
		
//		task.task1();
//		task.task2();
//		task.task3();

		Future<HashMap> task4 = task.task4();
		Future<String> task5 = task.task5();
		Future<String> task6 = task.task6();
		for(;;){
			if (task4.isDone() && task5.isDone() && task6.isDone()) {
				break;
			}
		}
		
		try {
			HashMap task4String = task4.get();
			System.out.println(task4String);
			String task5String = task5.get();
			System.out.println(task5String);
			String task6String = task6.get();
			System.out.println(task6String);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		long total = end-begin;
		System.out.println("执行总耗时="+total);
		return JsonData.buildSuccess(total);
	}
	
	
}
