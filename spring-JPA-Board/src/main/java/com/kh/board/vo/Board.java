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

/*
  @Entity 클래스를 선언 
  @Id 기본키를 사용할 수 있도록
  @Lob : Blob, Clob 타입을 매핑
  @CreationTimestamp : insert 시 시간을 자동으로 저장
  @UpdateTimestamp : update시 시간을 자동으로 저장
  @Temporal :날짜타입을 매핑
  @CreateDate : 엔티티가 생성되어 저장될때 시간을 저장 
 * 
 * 
 * @Column :  테이블 안에 컬럼을 생성하거나 존재하는 테이블에 컬럼값을 찾아 매핑하는 역할을 함 
 * 			option
 * 				name : 데이터베이스에서 존재하는 컬럼이름과 자바클래스에서 존재하는 필드 이름이 일치하지 않능 경우 둘의 자바와 데이터베이스의 값이 일치할 수 있도록 매핑해주는 역할
 * 				unique: 유니크 제약 조건 설정, null도 유니크
 * 				insertable : 인서트 가능여부를 넣어줄 수 있음.
 * 				updateable : update  가능 여부
 * 				length : String 타입의 문자 길이 제약 조건을 설정 할 수 있음
 * 				columnDefinition : 데이터베이스 컬럼 정보를 직접 기술함
 * 					@Column(columnDefinition = "varchar(10) not null")
 * 				precision : 큰 값에서 사용할 수 있음, 소숫점을 포함한 전체 자리수
 * 				scale(DDL) : 소수점 자리수 Double, Float 타입에는 적용되지 않음
 * @GeneratedValue(strategy = GenerationType.)
 * 				GenerationType.AUTO(default) JPA 자동으로 알아서 생성전략을 결정
 * 				GenerationType.SEQUENCE : 데이터베이스 시퀀스를 이용해서 기본키를 생성. 간혹 @SequenceGenerator를 사용해서 시퀀스 등록할 필요가 있음
 * 				GenerationType.TABLE : 키 생성용 테이블 사용 
 * 									@TableGenerator 필요
 * 				GenerationType.IDENTITY : 기본키 생성을 데이터베이스에 넘겨줌
 * 											ex) mysql 데이터베이스의 경우 auto_increament 사용해서 기본키를 생성
 */
 