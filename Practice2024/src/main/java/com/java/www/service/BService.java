package com.java.www.service;

import java.util.List;
import java.util.Map;

import com.java.www.dto.YmemberDto;

public interface BService {

	YmemberDto loginCheck(String id, String pw);

	Map<String, Object> selectAll(int searchCount, int page);


}//BService
