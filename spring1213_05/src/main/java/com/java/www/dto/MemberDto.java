package com.java.www.dto;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Getter -getter만
//@Setter -setter만

@AllArgsConstructor //전체생성자
@NoArgsConstructor //기본생성자
@Data //getter,setter
public class MemberDto {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;
	private Timestamp mdate;

	
	
	
	
	
}