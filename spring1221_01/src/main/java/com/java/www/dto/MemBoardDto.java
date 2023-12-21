package com.java.www.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemBoardDto {
	
	private MemberDto memberDto;
	private BoardDto boardDto;
	

}
