package com.myweb.www.repository;

import com.myweb.www.domain.UserVo;

public interface UserDAO {

	UserVo getUser(String id);

	int insertUser(UserVo uvo);

}
