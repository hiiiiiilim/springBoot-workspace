package com.kh.board.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="boards")
//name = "연결해주기 위한 이름", sequenceName = "데이터베이스에 들어간 이름"
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_ADD_SEQUENCE")
	@SequenceGenerator(name = "board_add_sequence", sequenceName = "board_add_sequence", allocationSize = 1)
	@Column(name="board_id") //컬럼명이랑 변수명이랑 다를때 설정
	private Long boardId;
	private String title;
	private String content;
	private String author;
}
