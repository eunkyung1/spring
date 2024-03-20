package com.java.www.service;

import java.util.List;

import com.java.www.dto.YmemberDto;

public interface BService {

	YmemberDto loginCheck(String id, String pw);

	List<YmemberDto> selectAll();


}//BService
