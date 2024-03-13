package com.java.www.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class YmemberDto {

	private String id;
	private int pw;
	private int ymno;
	private String name;
	private String gender;
	private String phone;
	private String pnumber;
	private String email;
	private Timestamp birthdate;
	private String address;
	private String y_img;
	private int ypoint;
	private int login_num;
	private Timestamp tdate;
	private Timestamp recont_time;
	
	
	
}
