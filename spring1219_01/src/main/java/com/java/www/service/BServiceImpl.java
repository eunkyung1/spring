package com.java.www.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.www.dto.BoardDto;
import com.java.www.mapper.BoardMapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	BoardMapper boardMapper;
	
	//게시글 전체 가져오기
	@Override
	public Map<String,Object> selectAll(int page) {
		//게시글전체 가져오기
		
		//하단넘버링-page,rowPerPage-1페이지당 게시글개수, countAll, startPage, endPage, maxPage
		int countPerPage = 10; //1페이지당 게시글수
		int bottomPerNum  = 10; //하단넘버링 개수
		int countAll = boardMapper.selectCountAll(); //게시글 총 개수
		//따로 외워두기
		int maxPage = (int)Math.ceil((double)countAll/countPerPage);
		//maxPage = 45개 -> 45/10 = 4.5 (올림)-> 5
		int startPage = ((page-1)/bottomPerNum)*bottomPerNum+1; // 5-1=4/10 -> 0*10+1
		int endPage = (startPage+bottomPerNum)+-1;
		
		int startRow = (page-1)*countPerPage+1; //1, 11, 21, 31, 41
		int endRow = startRow + countPerPage-1; //10,20,30,40
		
		//startPage:1 - endPage:10일 때 maxPager가 5이면
		//endPage에 maxPage를 넣어서 1-10나오는 것이 아니라 1-5까지만 나타나도록 함.
		if(endPage>maxPage) endPage = maxPage;
		ArrayList<BoardDto> list = boardMapper.selectAll(startRow,endRow);
		
		//데이터전송 - list,page,maxPage,startPage,endPage
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("countAll", countAll);
		map.put("page", page);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}//list selectAll

	//게시글 1개 가져오기 , 이전글, 다음글 가져오기 : 총3개
	@Override
	public Map<String, Object> selectOne(int bno) {
		BoardDto bdto = boardMapper.selectOne(bno);
		BoardDto predto = boardMapper.selectOnePrev(bno);
		BoardDto nextdto = boardMapper.selectOneNext(bno);
		
		//조회수 1증가
		boardMapper.bhitUp(bno);
		
		
		Map<String, Object> map = new HashMap<>(); //map은 인터페이스.
		//List<BoardDto> list = new ArrayList<>(); //이것도 가능
		
		map.put("bdto", bdto);
		map.put("predto", predto);
		map.put("nextdto", nextdto);
		
		return map;
	}//map selectOne

	//글쓰기 저장
	@Override
	public void bInsert(BoardDto bdto) {
		int result = boardMapper.bInsert(bdto);
		System.out.println("bServiceImpl result : "+result);
	}//bInsert

	//게시글 삭제
	@Override
	public void bDelete(int bno) {
		int result = boardMapper.bDelete(bno);
		System.out.println("bServiceImpl bDelete result : "+result);
		
	}

	//게시글 수정 저장
	@Override
	public void doBUpdate(BoardDto bdto) {
		int result = boardMapper.doBUpdate(bdto);
		System.out.println("bServiceImpl doBUpdate result : "+result);
		
	}

	//답변달기 저장
	@Override
	public void doBReply(BoardDto bdto) {
		//답변달기 저장 bgourp, bstep, bindent
		//1. 부모보다 큰 bstep은 1씩 증가시킴
		//2. 현재 글은  부모bstep +1 저장.
		//3. bindent 부모의 1 더하기
		//4. bgroup은 부모와 같음.
		boardMapper.bstepUp(bdto);
		
		int result = boardMapper.doBReply(bdto);
		System.out.println("bServiceImpl doBReply result : "+result);
		
		
	}

}
