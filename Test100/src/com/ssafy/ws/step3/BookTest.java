package com.ssafy.ws.step3;

public class BookTest {
	public static void main(String[] args) {
	//Test클래스에는 main메서드 있어야 함 
	//객체 생성 후 테스트 해보기 
		Book book1=new Book("1234","가나다","홍길동","박소정",5000,"재밌음");
		Magazine mg1=new Magazine("1234","가나다","홍길동","박소정",5000,"재밌음",2025,2);
	
		BookManager bm=new BookManager();
	
		bm.add(book1);
		bm.add(mg1);
	
		for(Book b:bm.getBooks()) {
			System.out.println(b);
		}
		
		for(Magazine m:bm.getMagazines()) {
			System.out.println(m);
		}
	
		int totalPrice=bm.getTotalPrice();
		System.out.println(totalPrice);
		
		double priceAvg=bm.getPriceAvg();
		System.out.println(priceAvg);
		
	
		Book[] searchList=bm.searchByTitle("가나다");
		for(Book s:searchList) {
			System.out.println(s);
		}
		
		System.out.println(bm.searchByIsbn("1234"));
	}
	
}
