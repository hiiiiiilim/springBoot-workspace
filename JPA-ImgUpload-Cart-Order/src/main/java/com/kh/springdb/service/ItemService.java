package com.kh.springdb.service;

import java.util.List;
import java.util.UUID;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.vo.Item;
import com.kh.springdb.repository.ItemRepository;

public class ItemService {
	private ItemRepository itemRepository;
	
	//상품을 추가하고 삭제하고 수정하는 기능
	public void addItem(Item item, MultipartFile photoFile) {
		//상품명과 저장될 파일명 경로생성
		//이미지 파일 정보에 대해서 추출
		String originPhotoName = photoFile.getOriginalFilename(); //업로드 된 이미지 파일에 원본 파일명을 가져옴
		String photoName = ""; //내
		String photoPath = System.getProperty("user.dir")+"src/main/resorces/static/uploadimg/"; //업로드된 이미지 파일 경로 설정 
		//System.getProperty():현재 코드가 작업하고 있는 폴더 위치
		//				user.dir 현재 작업하고 있는 사용자 폴더를 나타냄
		//user.dir은 C:\Users\user1\Desktop\springBoot-workspace\JPA-ImgUpload-Cart-Order 위치와 동일하다
		
		String saveFileName = "khShop_" + originPhotoName; //+랜덤으로 숫자를 넣어줘서 업로드 파일 이름이겹치지 않도록 할 수 있음
		//saveFileName 으로 만약에 판매자가 사진1을 올리면 내 폴더 안에는 khShop_사진1로 저장이됨
		
		//빈값에 한번 더 재정의로 넣어줌
		photoName = saveFileName;
		
		//파일을 저장하기위해 우리가 작성해놓은 파일을 작성하기 위한 공간이 비어있는 File객체를 가지고 옴 
		//						파일을 저장할 경로   파일명
		File saveFile = new File(photoPath, photoName);
		
		//만약에 이름을 변경해서 저장하고 싶지 않다면 
		//originPhotoName으로 저장해도됨
		//판매자 컴퓨터에 있는 이미지 이름으로 그대로 업로드 됨
		//File saveFile = new File(photoPath, originPhotoName);
		
		//업로드 된 이미지 파일을 지정된 경로에 저장하기 위해 설정
		//transferTo 서버에 특정경로에 저장할 수 있도록 해주는 메서드
		photoFile.transferTo(saveFile);
		item.setPhotoName(photoName)
		item.setPhtoPath("/img/"+photoPath);
		
		//DB에 저장할 수 있도록 save
		itemRepository.save(item);
	}
	
	//상품 읽기 find를 사용해서 개별읽기
	public Item getItemById(Integer id){
		return itemRepository.findById(id).get();
	}
	//findById를 사용해서 id에 해당하는 값을 가져오고 get을 이용해서 Item객체를 반환
	
	
	//모든 상품 가지고 오기 list
	public List<Item> allItemList(){
		return itemRepository.findAll();
	}
	
	public void itemDelete(Integer Id) {
		itemRepository.deleteById(Id);
	}
 }
