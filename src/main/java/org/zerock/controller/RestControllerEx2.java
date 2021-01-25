package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Rest1;
import org.zerock.domain.Rest2;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/rest2")
@Log4j
public class RestControllerEx2 {

	@RequestMapping("/ex1")
	public String method1() {
		return "hello";
	}

	@RequestMapping("/ex2")
	public Rest1 method2() {
		
		// 전송, 수신 방법이 http(HyperText Transper Protocol)
		log.info("method2");
		
		Rest1 r = new Rest1();
		r.setName("donald");
		r.setAge(33);
		
		return r;
	}
	
	@RequestMapping("/ex3")
	public String method3() {
		
		// 전송, 수신 방법이 http(HyperText Transper Protocol)
		log.info("method3");
		
		Rest1 r = new Rest1();
		r.setName("donald");
		r.setAge(33);
		
//		String res = "이름:" + r.getName() + ", " + "나이:" + r.getAge();
		String res = "{\"name\":\"" + r.getName() + "\", \"age\":" + r.getAge() + "}";
		return res;
	}
	
	@RequestMapping("/ex4")
	public Rest1 method4() {
		
		// 전송, 수신 방법이 http(HyperText Transper Protocol)
		log.info("method4");
		
		Rest1 r = new Rest1();
		r.setName("donald");
		r.setAge(33);
		
		return r;
	}
	
	@RequestMapping("/ex5")
	public Rest2 method5() {
		Rest2 r2 = new Rest2();
		r2.setAddress("seoul");
		
		Rest1 r1 = new Rest1();
		r1.setName("jeju");
		r1.setAge(100);
		r1.setVote(true);
		
		r2.setRest1(r1);
		
		return r2;
	}
	
	@RequestMapping("/ex999")
	public List<Integer> method999() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			 list.add((int) (Math.random() * 100));
		}
		return list;
	}
}









