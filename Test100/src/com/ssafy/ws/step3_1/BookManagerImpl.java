package com.ssafy.ws.step3_1;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
    private List<Book> books = new ArrayList<>();
    private static IBookManager instance = new BookManagerImpl();

    private BookManagerImpl() {}

    public static IBookManager getInstance() {
        return instance;
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public void remove(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                break;
            }
        }
    }

    @Override
    public Book[] getList() {
        return books.toArray(new Book[0]);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book[] searchByTitle(String title) {
        List<Book> searchList = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                searchList.add(book);
            }
        }
        return searchList.toArray(new Book[0]);
    }

    @Override
    public Magazine[] getMagazines() {
        List<Magazine> magazineList = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof Magazine) {
                magazineList.add((Magazine) book);
            }
        }
        return magazineList.toArray(new Magazine[0]);
    }

    @Override
    public Book[] getBooks() {
        List<Book> bookList = new ArrayList<>();
        for (Book book : books) {
            if (!(book instanceof Magazine)) {
                bookList.add(book);
            }
        }
        return bookList.toArray(new Book[0]);
    }

    @Override
    public int getTotalPrice() {
        int totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice() * book.getQuantity();
        }
        return totalPrice;
    }

    @Override
    public double getPriceAvg() {
        if (books.isEmpty()) {
            return 0.0;
        }
        return (double) getTotalPrice() / books.size();
    }

    // 도서 구매 (재고 증가)
    public void buy(String isbn, int quantity) throws ISBNNotFoundException {
        Book book = searchByIsbn(isbn);
        if (book == null) {
            throw new ISBNNotFoundException(isbn);
        }
        book.setQuantity(book.getQuantity() + quantity);
    }

    // 도서 판매 (재고 감소)
    public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
        Book book = searchByIsbn(isbn);
        if (book == null) {
            throw new ISBNNotFoundException(isbn);
        }
        if (book.getQuantity() < quantity) {
            throw new QuantityException();
        }
        book.setQuantity(book.getQuantity() - quantity);
    }
}