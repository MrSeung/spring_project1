package com.myweb.www.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myweb.www.domain.UserVo;
import com.myweb.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO udao;
	@Inject
	BCryptPasswordEncoder passwordencoder;

	@Override
	public int signUp(UserVo uvo) {
		// TODO Auto-generated method stub
		log.info(">>> signUp service in");
		//아이디가 중복되면 회원가입 실패
		//아이디 주고 DB에서 일치하는 유저를 달라고 요청
		//일치하는 유저가 없다면 가입(1) / 있으면(0)
		UserVo tempUser = udao.getUser(uvo.getId());
		//tempUser가 null이 아니라면 이미 가입된 회원 => 아이디 중복 => 회원가입 실패
		if(tempUser != null) {
			return 0;
		}
		
		//아이디 중복되지 않았다면 회원가입을 진행한다.
		//password가 null 이거나 값이 없으면 가입불가
		if(uvo.getId()==null || uvo.getId().length()==0) {
			
			return 0;
		}
		if(uvo.getPw()==null || uvo.getPw().length()==0) {
			
			return 0;
		}
		
		//회원가입
		String pw=uvo.getPw();
		//암호화 / matches(원래 비번, 암호화된 비번)
		String encodePw = passwordencoder.encode(pw); //기존 패스워드 암호화
		//uvo의 패스워드를 암호화된 패스워드로 수정
		uvo.setPw(encodePw);
		//회원가입 => insert
		int isOk = udao.insertUser(uvo);
		return isOk;
		
	}
	
}
