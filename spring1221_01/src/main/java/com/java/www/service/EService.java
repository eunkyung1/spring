package com.java.www.service;

import java.util.ArrayList;

import com.java.www.dto.EmpDepDto;
import com.java.www.dto.EmpDto;
import com.java.www.dto.MemBoardDto;

public interface EService {

	ArrayList<EmpDto> selectAll();
	//사원,부서정보 
	ArrayList<EmpDepDto> selectAll2();
	ArrayList<MemBoardDto> selectAll3();

}
