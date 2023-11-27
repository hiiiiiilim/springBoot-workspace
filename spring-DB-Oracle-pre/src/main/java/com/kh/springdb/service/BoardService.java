package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springdb.mapper.BoardMapper;
import com.kh.springdb.model.Board;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardmapper;
	
	//모든 정보 가져오기, 게시판에서 게시물 전체보기
	public List<Board> getAllBoards(){
		return boardmapper.getAllBoards();
	}
	
	//하나의 게시글 가져오기, 한가지에 대한 상세보기 서비스
	public Board getBoardById(int board_id) {
		return boardmapper.getBoardById(board_id);
	}
	
	//게시글 작성하기
	public void insertBoard(Board board) {
		boardmapper.insertBoard(board);
	}
	
	//게시글 수정하기
	public void updateBoard(Board board) {
		boardmapper.updateBoard(board);
	}
	
	//게시글 삭제하기
	public void deleteBoard(int board_id) {
		boardmapper.deleteBoard(board_id);
	}
	
	//게시글 모두 삭제하기
	@Transactional //삭제후 커밋까지
	public void deleteAllBoards() {
		boardmapper.deleteAllBoards();
	}
	
	//게시글 찾기
	public BoardService(BoardMapper boardMapper) {
		this.boardmapper=boardMapper;
	}
	
	public Board search(int board_id, String title) {
		return boardmapper.loginByBoardidTitle(board_id, title);
	}
}


/*
 @Transactional 트랜젝션을 지원하는 스프링에서 데이터베이스관리를 단순히 어노테이션을 사용해서 여러개의 데이터베이스 조작 작업을 묶어서 하나의 작업단위로 처리하는데 사용하며
 				작업은 성공 또는 실패로 완료될 수 있음.
 				개발자가 일일히 커밋 또는 롤백을 관리하는 코드를 작성하지 않아도됨.
 * 
 * */
