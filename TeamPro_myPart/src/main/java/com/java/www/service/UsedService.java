package com.java.www.service;

import java.util.List;

import com.java.www.dto.UsedDto;

public interface UsedService {
	//trade1 받기
	List<UsedDto> selectAll();

	//transfer2 받기
	List<UsedDto> selectAll2();

}
