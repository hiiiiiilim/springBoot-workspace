package com.kh.board.controller;


import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.board.service.BoardService;
import com.kh.board.vo.Board;

@Controller
@RequestMapping("/boards")
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService=boardService;
	}
	
	@GetMapping
	public String getAllBoards(Model model) {
		//List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards",boardService.getAllBoards());
		return "board_list";
	}
	
	@GetMapping("/detail/{boardId}")
	public String getBoardById(@PathVariable Long boardId, Model model) {
		Optional<Board> board = boardService.getBoardById(boardId);
		board.ifPresent(value -> model.addAttribute("board", value));
		return "board_detail";
	}
	
	@GetMapping("/new")
	public String displayBoard(Model model) {
		model.addAttribute("board", new Board());
		return "board_form";
	}
	
	@PostMapping("/save")
	public String saveBoard(@ModelAttribute Board board) {
		boardService.saveBoard(board);
		return "redirect:/boards";
	}
	
	//수정하기
	@GetMapping("/update/{boardId}")
	public String updateBoard(@PathVariable Long boardId, Model model) {
		Optional<Board> board = boardService.getBoardById(boardId);
		board.ifPresent(value -> model.addAttribute("board",value));
		return "board_form";
	}
	
		
	//삭제
	@GetMapping("/delete/{boardId}")
	public String deleteBoard(@PathVariable Long boardId) {
		boardService.deleteBoardById(boardId);
		return "redirect:/boards";
	}
	
	//모든 게시물 삭제
	@GetMapping("/delete/all")
	public String deleteAllBoards() {
		boardService.deleteAllBoards();
		return "redirect:/boards";	
	}
	
	//특정키워드를 활용해서 게시물 검색하는 매핑 메서드
	@GetMapping("/search")
    public String searchBoards(@RequestParam String keyword, Model model) {
        // 특정 키워드를 포함하는 게시물 검색
        List<Board> boards = boardService.findBoardsByTitle(keyword);

        // 모델에 검색 결과 추가
        model.addAttribute("boards", boards);

        // 검색 결과를 보여줄 뷰 페이지 리턴
        return "searchResults";
    }
}
/*
 * 
 @RequestParam : Spring 프레임워크에서 클라이언트로부터 전송된 http 요청의 파라메터 값을 받아오기 위해 사용되는 어노테이션
 				주로 웹 요청에서 쿼리 파라메터나 폼데이를 추출하는데 사용
 				클라이언트가 전송한 요청의 파라미터 값을 메서드의 매개변수로 받아올때 사용
 		예제코드:
 			@GetMapping("/ex")
 			public String paramMethod(@RequestParam String name, @RequestParam int age){
 				//name과 age 는 클라이언트가 전송한 요청의 쿼리파라미터값
				
				return "View";
 			}
 			
 * */
 