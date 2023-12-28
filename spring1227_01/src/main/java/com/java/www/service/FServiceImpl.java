package com.java.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.IncomeDto;
import com.java.www.mapper.IncomeMapper;

@Service
public class FServiceImpl implements FService {
	
	@Autowired
	IncomeMapper incomeMapper;

	//매출액 가져오기
	@Override
	public ArrayList<IncomeDto> incomeSelect(String cyear) {
		//db연결
		ArrayList<IncomeDto> list = incomeMapper.incomeSelect(cyear);
		
		return list;
	}

}
