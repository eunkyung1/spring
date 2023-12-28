package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.IncomeDto;

@Mapper
public interface IncomeMapper {
	
	//매출액 가져오기
	ArrayList<IncomeDto> incomeSelect(String cyear);

}
