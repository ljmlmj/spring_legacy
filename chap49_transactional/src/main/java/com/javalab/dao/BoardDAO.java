package com.javalab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javalab.vo.Board;

@Mapper
public interface BoardDAO {
	
	public List<Board> getBoardList(Board boardVo); 
	public Board getBoardById(Board boardVo); 
	public int getTotalBoardCount(); 
	public int insertBoard(Board boardVo); 
	public void updateBoard(Board boardVo); 
	public void updateHit(Board boardVo);
	public void deleteBoard(Board vo);
	public int insertBoard2(Board boardVo); // 데이터를 중복해서 저장해서 무결성 오류 유발용 메소드. 
											// 이 메소드를 실행하면서 무결성 오류가 발생하고 트랜잭션이 롤백한다
}
