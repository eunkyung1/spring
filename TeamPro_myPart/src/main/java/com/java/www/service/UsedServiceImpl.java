package com.java.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.UsedDto;
import com.java.www.mapper.UsedMapper;

@Service
public class UsedServiceImpl implements UsedService {
	
	@Autowired UsedMapper usedMapper;

	//u_btype='trade1'
	@Override
	public List<UsedDto> selectAll() {
		List<UsedDto> list = usedMapper.selectAll();
		return list;
	}

	//u_btype='transfer2'
	@Override
	public List<UsedDto> selectAll2() {
		List<UsedDto> list2 = usedMapper.selectAll2();
		return list2;
	}

}
