package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "Book-1", 100, "Author-1");
    Book book2 = new Book(2, "Book-2", 100, "Author-2");
    Smartphone smartphone1 = new Smartphone(5,"Smartphone-1",1000,"Producer-1");

    @BeforeEach
    void setup(){
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone1);
    }

    @Test
    void shouldDeleteExisting(){
        int idRemove = 1;
        repository.removeById(idRemove);
        System.out.println(repository.items[1]);
        Product[] expected = new Product[] {book2, smartphone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldDeleteNotExisting(){
        int idRemove = 3;
        assertThrows(NotFoundException.class, () -> repository.removeById(idRemove));
    }


}