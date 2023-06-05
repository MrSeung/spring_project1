package com.myweb.www.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.UserVo;
import com.myweb.www.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // = private static final Logger logger= LoggerFactory.getLogger(UserController.class);
@RequestMapping("/member/*")
public class UserController {
	
	@Inject
	private UserService usv;
	
	@GetMapping("/signup")
	public String index(Model m) {
		log.info("home 접근 완료");
		//m.addAttribute("msg_home",1);
		return "/user/signup";
	}
	
	@PostMapping("/signup")
	 public String signupPost(Model m, UserVo uvo) {
		 log.info("회원가입 접근 완료");
		 log.info(">>> m : "+m);
		 log.info(uvo.toString());
		 int isOk = usv.signUp(uvo);
		 if(isOk>0) {
			 m.addAttribute("msg_signup",1);
		 }
		 else {
			 m.addAttribute("msg_signup",0);
		 }
		 return "home";
	 }
}
