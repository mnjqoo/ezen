package com.edu.board.service;

import java.util.HashMap;
import java.util.List;

import com.edu.board.dto.BoardDTO;
import com.edu.common.util.Criteria;
import com.edu.common.util.SearchCriteria;

public interface BoardService {

	public int boardRegister(BoardDTO boardDTO) throws Exception; //게시글 등록 처리
	
	public List<BoardDTO> boardList() throws Exception; //게시글 목록 불러오기
	
	public BoardDTO boardDetail(int bno) throws Exception; //게시글 상세페이지 불러오기
	
	public int boardDelete(int bno) throws Exception; //게시글 삭제 처리
	
	public int boardUpdate(BoardDTO boardDTO) throws Exception; //게시글 수정 처리
	
	public int boardListTotalCount1() throws Exception; //총 게시글 수 구하기 1 
	
	public List<BoardDTO> boardListPaging1(HashMap<String, Integer> pageList) throws Exception; // 요청된 페이지에 해당하는 게시글을 가져오기1
	
	public int boardListTotalCount2(Criteria cri) throws Exception; //총 게시글 수 구하기 2
	
	public List<BoardDTO> boardListPaging2(Criteria cri) throws Exception; //요청된 페이지에 해당하는 게시글 가져오기2
	
	public int boardListTotalCount3(SearchCriteria sCri) throws Exception; //총 게시글 수 구하기3
	
	public List<BoardDTO> boardListPaging3(SearchCriteria sCri) throws Exception; //조건에 해당하는 게시글 가져오기3
}
