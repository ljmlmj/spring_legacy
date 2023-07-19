package com.javalab.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalab.board.common.AfterLogAdvice;
import com.javalab.board.common.LogAdvice;
import com.javalab.board.dao.BoardMapperInterface;
import com.javalab.board.vo.BoardVo;


/**
 * [비지니스 로직, 서비스 단(Layer)]
 *  - BoardService 인터페이스를 구현한 구현체 클래스로 인터페이스의 메소드가 
 *    호출되지만 실질적으로는 Imple 객체의 메소드가 대신 호출된다.
 *  - 업무의 주된 핵심 로직이 구현되는 단(Layer)
 *  - 컨트롤러와 Dao 단을 연결하는 역할
 *  - AOP가 적용되는 Layer(단)
 *  - @Service 어노테이션으로 인해서 자동으로 빈으로 스캔되고 로딩됨 
 *
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	//멤버변수 Dao 단의 빈이 자동 주입됨(DI)
	@Autowired
	//private BoardDao boardDao;	//BoardDao 객체 자동주입
	private BoardMapperInterface boardDao;
	
	
	//공통 조릭 : 로그 남기는 역할의 클래스
//	private LogAdvice logAdvice;
//	private AfterLogAdvice afterLogAdvice;
	
	
	
	public BoardServiceImpl() {
		super();
		System.out.println("BoardServiceImple 기본생성자");
//		logAdvice = new LogAdvice();
//		afterLogAdvice = new AfterLogAdvice();
		
	}//end 기본생성자
	
	// 게시물 조회
	@Override
	public ArrayList<BoardVo> selectBoardList(){
		// [부가 로직 - 횡단 관심사(어드바이드)]
//		logAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		
		//[핵심 로직 - 핵심 관심사]
		ArrayList<BoardVo> boardList = boardDao.selectBoardList();
		
		//[부가 로직 - 횡단 관심사(어드바이스)]
//		afterLogAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		return boardList;
	}
	
	// 게시물 삭제
	@Override
	public int deleteBoard(int no) {
		// [부가 로직 - 횡단 관심사(어드바이드)]
//		logAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		
		//[핵심 로직 - 핵심 관심사]
		int result = 0;
		result = boardDao.deleteBoard(no);
		
		//[부가 로직 - 횡단 관심사(어드바이스)]
//		afterLogAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		return result;
	}
	
	//게시물 한개 조회
	@Override
	public BoardVo getBoardById(int no) {
		// [부가 로직 - 횡단 관심사(어드바이드)]
//		logAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		
		//[핵심 로직 - 핵심 관심사]
		BoardVo boardVo = null;
		updateHitCount(no);	//게시물 조회수 업데이트
		boardVo = boardDao.getBoardById(no);
		
		//[부가 로직 - 횡단 관심사(어드바이스)]
//		afterLogAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		return boardVo;
	}


	//게시물 수정
	@Override
	public int modifyBoard(BoardVo boardVo) {
		// [부가 로직 - 횡단 관심사(어드바이드)]
//		logAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		
		//[핵심 로직 - 핵심 관심사]
		int result = 0;
		result = boardDao.modifyBoard(boardVo);
		
		//[부가 로직 - 횡단 관심사(어드바이스)]
//		afterLogAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		return result;
	}
	
	//게시물 등록
	@Override
	public int insertBoard(BoardVo vo) throws Exception{
		// [부가 로직 - 횡단 관심사(어드바이드)]
//		logAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		
		//[핵심 로직 - 핵심 관심사]
		int result = 0;
		result = boardDao.insertBoard(vo);
		
		//[부가 로직 - 횡단 관심사(어드바이스)]
//		afterLogAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
		return result;
	}
	
	//게시물 조회수 증가
	@Override
	public void updateHitCount(int no) {
		// [부가 로직 - 횡단 관심사(어드바이드)]
//		logAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가

		//[핵심 로직 - 핵심 관심사]
		boardDao.updateHitCount(no);
		
		//[부가 로직 - 횡단 관심사(어드바이스)]
//		afterLogAdvice.printLog();	//메소드 마다 로그 남기기 로그 추가
	}


}//end class BoardServiceImple
