package net.xdclass.demo.webflux;


import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

 
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	

	//@Autowired
	//private UserService userService;
	
	private final UserService userService;
	
	@Autowired
	private  User user;
	
	 public UserController(final UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("test")
	public Mono<User> test(){
		System.out.println(user);
		return Mono.justOrEmpty(new User("1", "22"));
	}
	
	@GetMapping("test2")
	public Flux<User> test1(){
	 
		return Flux.just(new User("1", "222"),new User("2", "222"),new User("", "222"));
	}


	
	/**
	 * 功能描述：根据id找用户
	 * @param id
	 * @return
	 */
	@GetMapping("find")
	public Mono<User> findByid(final String id){
		return userService.getById(id);
	}
	
	
	/**
	 * 功能描述：删除用户
	 * @param id
	 * @return
	 */
	@GetMapping("del")
	public Mono<User> del(final String id){
		return userService.del(id);
	}
	
	/**
	 * 功能描述：列表
	 * @return
	 */
	@GetMapping(value="list",produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<User> list(){
		return userService.list().delayElements(Duration.ofSeconds(2));
	}
	
	
	@GetMapping(value="list2",produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<User> list2(){
		return userService.list();
	}
}
