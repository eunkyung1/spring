package com.java.www.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.www.dto.NBoardDto;

public interface NBoardService {

	Map<String, Object> selectAll(int page, String category, String searchWord);

	Map<String, Object> selectOne(int n_bno);

	void bWrite(NBoardDto nbdto);

	void donUpdate(NBoardDto nbdto);

}
