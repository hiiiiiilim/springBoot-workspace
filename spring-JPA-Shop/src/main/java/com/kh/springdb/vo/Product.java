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
@Entity
@Table(name="products")
@SequenceGenerator(name = "products_sequence", 
sequenceName="PRODUCTS_SEQ",
allocationSize = 1)
public class Product {
	
	//@SequenceGenerator(name = "products_sequence", 
	//sequenceName="PRODUCTS_SEQ",
	//allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_sequence")

	private Long product_id;
	
	//@Column(nullable = false, length = 50)
	private String product_name;
	
	//@Column(nullable = false, length = 50)
	private String category;
	
	//@Column(name="price")
	private Double price;
	
	private Integer stock_quantity;
}


/*

@Table : 테이블 이름을 지정
@Id : 해당 필드가 엔터티의 primaryKey 임을 나타냄
@Column : 해당 필드가 데이터베이스 테이블의 컬럼에 매핑되는 것을 확인할 수 있음
	nullable : 해당 컬럼이 null 값을 허용하는지 여부를 나타냄
	length : 문자열 컬럼의 최대 길이를 지정
	String으로 시작되는 필드값의 경우 String으로 지정된 이름으로 명시되기 때문에
	따로 name을 지정해주지 않아도 되지만 String 이외 값은
	name을 설정해주어 Column 명을 지정해주는 것이 원칙
	

	시퀀스를 사용해서 기본키 값을 생성할 수 있도록 지원
	시퀀스는 데이터베이스에서 중복되는 값이 아닌 각 레코드가 고유한 숫자 번호를 가질 수 있도록 자동으로 값을 생성해줌
	
	@GeneratedValue -> JAP에서 엔터티의 기본 키 값을 자동으로 생성하는 방법을 지정하는데 사용하는 어노테이션
	@SequenceGenerator -> @GeneratedValue와 연결할 이름을 설정해주고 시퀀스의 이름과 크기를 지정할 수 있음
	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", 
						sequenceName="PRODUCT_SEQ",
						allocationSize = 1)
	데이터베이스 자체에서 자동으로 값이 증가할 수 있도록 자동 생성이 들어 있는 경우 아래 어노테이션 방식을 사용
	새로운 레코드가 삽입될 때 마다 데이터베이스가 자동으로 기본키의 값을 증가시킴
	@GeneratedValue(strategy = GenerationType.IDENTITY)

*/