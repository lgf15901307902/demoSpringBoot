package net.xdclass.demo.task.task;

import java.util.concurrent.Executors;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@SpringBootConfiguration  
public class ScheduleConfig implements SchedulingConfigurer {  
  @Override  
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {  
  
      taskRegistrar.setScheduler(Executors.newScheduledThreadPool(5)); //设置多个线程去执行  
  }  
}  