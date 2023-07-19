package com.javalab.service;

import java.util.List;

import com.javalab.vo.Board;


public interface BoardService {

	// 게시물 등록
	int insertBoard(Board vo);

	// 게시물 수정
	void updateBoard(Board vo);

	// 게시물 삭제
	void deleteBoard(Board vo);

	// 게시물 상세 조회
	Board getBoardById(Board vo);

	// 게시물 목록 조회
	List<Board> getBoardList(Board vo);

	// 게시물 조회수 증가
	void updateHit(Board vo);	
	
	// 전체 게시물 숫자
	int getTotalBoardCount();

}

