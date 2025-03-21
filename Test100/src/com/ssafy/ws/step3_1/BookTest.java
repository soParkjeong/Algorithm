package com.ssafy.ws.step3_1;

public class BookTest {
    public static void main(String[] args) {
        IBookManager bm = BookManagerImpl.getInstance();

        // 도서 추가
        Book book1 = new Book("1234", "Java Programming", "Author A", "Publisher X", 30000, "Java Basics", 10);
        Magazine mg1 = new Magazine("5678", "Tech Monthly", "Author B", "Publisher Y", 15000, "Tech Trends", 2023, 3);

        bm.add(book1);
        bm.add(mg1);

        try {
            // 도서 구매 테스트
            bm.buy("1234", 5);
            System.out.println("도서 구매 완료: " + bm.searchByIsbn("1234"));

            // 도서 판매 테스트
            bm.sell("1234", 8);
            System.out.println("도서 판매 완료: " + bm.searchByIsbn("1234"));

            // 판매 시 재고 부족 테스트
            bm.sell("1234", 10);
        } catch (ISBNNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (QuantityException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 모든 도서 출력
        System.out.println("도서 목록:");
        for (Book book : bm.getList()) {
            System.out.println(book);
        }

        // 총합과 평균 출력
        System.out.println("총 가격: " + bm.getTotalPrice());
        System.out.println("평균 가격: " + bm.getPriceAvg());
    }
}