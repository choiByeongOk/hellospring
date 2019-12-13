package com.naver.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebRestController {
	/* main page */
	@GetMapping("/")
	public String main() {
		return "main";
	}

	/* hello page */
	@RequestMapping("/hello")
	public String hello(Model model) {
		System.out.println("hello() 실행");
		model.addAttribute("message", "Hello World");
		return "hello";
	}
}
