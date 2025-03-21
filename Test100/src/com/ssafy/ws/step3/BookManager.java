package com.ssafy.ws.step3;

public class BookManager {
	//메서드 구현함
	private static final int MAX_SIZE=100;
	private Book[] books=new Book[MAX_SIZE];
	private int size=0;
	
	public void add(Book book) {
		if(size<MAX_SIZE) {
			books[size]=book;
			size++;
		}
	}
	
	public void remove(String isbn) {
		for(int i=0;i<MAX_SIZE;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				for(int j=i;j<size-1;j++) {
					books[j]=books[j+1];//한 칸씩 앞당기
				}
			}
			books[size--]=null;//젤 마지막 인덱스를 null
		}
	}
	
	public Book[] getList() {
		System.out.println("****************도서 전체 목록**********************");
		Book[] result=new Book[size];
		for(int i=0;i<size;i++) {
			result[i]=books[i];
		}
		return result;
	}
	
	public Book searchByIsbn(String isbn) {
		System.out.println("*****************도서 isbn 포함검색:"+isbn+"**********************");
		Book searchBook=new Book();
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				searchBook=books[i];
			}
		}
		return searchBook;
	}
	
	public Book[] searchByTitle(String title) {
		System.out.println("*****************도서 제목 포함검색:"+title+"**********************");
		int cnt=0;
		for(int i=0;i<size;i++) {
			if(books[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		
		Book[] searchList=new Book[cnt];
		int index=0;
		for(int i=0;i<cnt;i++) {
			if(books[i].getTitle().contains(title)) {
				searchList[index++]=books[i];
			}
		}
		return searchList;
	}
	
	public Magazine[] getMagazines() {
		System.out.println("*****************잡지 목록*********************");
		int cnt=0;
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) {
				cnt++;
			}
		}
		
		Magazine[] magazines=new Magazine[cnt];
		int index=0;
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) {
				magazines[index++]=(Magazine)books[i];//다운캐스
			}
		}
		return magazines;
	}
	
	public Book[] getBooks() {
		System.out.println("*****************일반 도서 목록**********************");
		int cnt=0;
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) {
				cnt++;
			}
		}
		
		Book[] bookList=new Book[cnt];
		int index=0;
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine)) {
				bookList[index++]=books[i];//다운캐스팅 
			}
		}
		return bookList;
	}
	
	public int getTotalPrice() {
		System.out.println("*****************도서 가격 총합**********************");
		int totalPrice=0;
		for(int i=0;i<size;i++) {
			totalPrice+=books[i].getPrice();
		}
		return totalPrice;
	}
	
	public double getPriceAvg(){
		System.out.println("*****************도서 가격 평균**********************");
		int cnt=0;
		double price=0;
		for(int i=0;i<size;i++) {
			cnt++;
			price+=books[i].getPrice();
		}
		return price/cnt;
	}
	
}
