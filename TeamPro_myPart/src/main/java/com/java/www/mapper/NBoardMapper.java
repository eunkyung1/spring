package com.java.www.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.www.dto.NBoardDto;

@Mapper
public interface NBoardMapper {

	ArrayList<NBoardDto> selectAll(int startRow, int endRow, String category, String searchWord);

	NBoardDto selectOne(int n_bno);

	int bWrite(NBoardDto nbdto);

	//count 총 갯수
	int selectCountAll();

	int donUpdate(NBoardDto nbdto);

}
