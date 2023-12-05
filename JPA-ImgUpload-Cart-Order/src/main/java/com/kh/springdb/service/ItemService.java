package com.kh.springdb.service;

import java.util.List;

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
		String photoName = "";
		String photoPath = System.getProperty("user.dir")+"src/main/resorces/static/uploadimg/"; //업로드된 이미지 파일 경로 설정 
		//System.getProperty():현재 코드가 작업하고 있는 폴더 위치
		//				user.dir 현재 작업하고 있는 사용자 폴더를 나타냄
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
