package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Book-1", 100, "Author-1");
    Book book2 = new Book(2, "Book-2", 100, "Author-2");
    Book book3 = new Book(3, "Book-3", 100, "Author-3");
    Book book4 = new Book(4, "Smartphone-1", 100, "Author-4");
    Smartphone smartphone1 = new Smartphone(5,"Smartphone-1",1000,"Producer-1");
    Smartphone smartphone2 = new Smartphone(6,"Smartphone-2",1000,"Producer-2");

    @BeforeEach
    void setup() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
    }

    @Test
    void shouldSearchBookByNameIfExist() {
        String bookName = "Book-2";
        Product[] expected = new Product[] {book2};
        Product[] actual = manager.searchBy(bookName);
        assertArrayEquals(expected, actual);
        System.out.println(expected[0]);
    }
    @Test
    void shouldSearchBookByNameIfNotExist() {
        String bookName = "Book-1000";
        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy(bookName);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBookByAuthorIfExist() {
        String bookAuthor = "Author-1";
        Product[] expected = new Product[] {book1};
        Product[] actual = manager.searchBy(bookAuthor);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchBookByAuthorIfNotExist() {
        String bookAuthor = "Author-1000";
        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy(bookAuthor);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchSmartphoneByNameIfExist() {
        String smartphoneModel = "Smartphone-1";
        Product[] expected = new Product[] {smartphone1};
        Product[] actual = manager.searchBy(smartphoneModel);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchSmartphoneByNameNotIfExist() {
        String smartphoneModel = "Smartphone-2000";
        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy(smartphoneModel);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchSmartphoneByProducerIfExist() {
        String smartphoneProducer = "Producer-1";
        Product[] expected = new Product[] {smartphone1};
        Product[] actual = manager.searchBy(smartphoneProducer);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchSmartphoneByProducerNotIfExist() {
        String smartphoneProducer = "Producer-1000";
        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy(smartphoneProducer);
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldSearchIdenticalName() {
        manager.addProduct(book4);
        String productName = "Smartphone-1";
        Product[] expected = new Product[] {smartphone1, book4};
        Product[] actual = manager.searchBy(productName);
        assertArrayEquals(expected, actual);
    }


}