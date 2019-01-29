package xdclass_springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import net.xdclass.demo.XdclassApplication;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={XdclassApplication.class})//启动整个springboot工程
public class WebClientTest {

	

	@Test
	public void testBase(){
		
		Mono<String> bodyMono = WebClient.create().get()
		.uri("http://localhost:8080/api/v1/user/find?id=1")
		.accept(MediaType.APPLICATION_JSON)
		.retrieve().bodyToMono(String.class);
		
		System.out.println(bodyMono.block());
		
	}
	

	@Test
	public void testBase2(){
		
		Mono<String> bodyMono = WebClient.create().get()
		.uri("http://localhost:8080/api/v1/user/find?id={id}",2)
		.accept(MediaType.APPLICATION_JSON)
		.retrieve().bodyToMono(String.class);
		
		System.out.println(bodyMono.block());
		
	}
	
	
}
