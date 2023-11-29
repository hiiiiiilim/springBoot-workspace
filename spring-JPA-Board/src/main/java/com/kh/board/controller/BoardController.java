package com.kh.board.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping("/update/{boardId}")
	public String updateForm(@PathVariable Long boardId, @ModelAttribute Board board) {
		boardService.getBoardById(boardId);
		boardService.saveBoard(board);
		return "redirect:/boards";
	}
	
	//삭제
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable Long id) {
		boardService.deleteBoardById(id);
		return "redirect:/boards";
	}
	
}
