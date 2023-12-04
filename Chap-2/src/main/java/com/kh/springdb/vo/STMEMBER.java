package com.kh.springdb.vo;

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
@Table(name="STUDENT_MEMBER")
@Entity
public class STMEMBER {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "st_seq")
	@SequenceGenerator(name="st_seq", sequenceName = "st_seq", allocationSize = 1)
	private int STNumber;
	private String memberName;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
}
