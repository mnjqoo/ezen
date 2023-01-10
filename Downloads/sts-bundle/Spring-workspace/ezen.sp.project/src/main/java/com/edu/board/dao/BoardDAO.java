package com.edu.board.dao;

import java.util.List;

import com.edu.board.dto.BoardDTO;

public interface BoardDAO {

	public Integer getMaxBno(); //가장 큰 게시글 번호 가져오기
	
	public int boardRegister(BoardDTO boardDTO) throws Exception; //게시글 등록 처리
	
	public List<BoardDTO> boardList() throws Exception; //게시글 목록 불러오기
	
	public void updateReadCount(int bno) throws Exception; //조회수 증가시키는 메소드
	
	public BoardDTO boardDetail(int bno) throws Exception; //게시글 상세페이지 불러오기
	
	public int boardDelete(int bno) throws Exception; //게시글 삭제 처리
	
	public int boardUpdate(BoardDTO boardDTO) throws Exception; //게시글 수정 처리
}
