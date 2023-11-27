package com.kh.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springdb.model.Board;

@Mapper
public interface BoardMapper {
	//전체 리스트
	List<Board> getAllBoards();
	//하나 가져오기
	Board getBoardById(int board_id);
	//	//게시글 작성하기, 저장하기
	void insertBoard(Board board);
	//게시글 수정하기
	void updateBoard(Board board);
	//삭제하기
	void deleteBoard(int board_id);
	//모두 삭제하기
	void deleteAllBoards();
	//찾기
	Board loginByBoardidTitle(int board_id, String title);
}