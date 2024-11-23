package com.example.springSem4Task3.services;

import com.example.springSem4Task3.models.Product;
import com.example.springSem4Task3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис работы с хранилищем продуктов.
 */
@Service
public class DataProcessingService {
    /**
     * Поле с репозиторием продуктов.
     */
    @Autowired
    private ProductRepository repository;

    /**
     * Получение репозитория продуктов.
     * @return объект репозитория.
     */
    public ProductRepository getRepository() {
        return repository;
    }

    /**
     * Сортировка продуктов по возрасту.
     * @param products список продуктов.
     * @return отсортированный список продуктов.
     */
    public List<Product> sortProductByPrice(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }


    /**
     * Получение среднего возраста продуктов.
     * @param products список продуктов.
     * @return средний возраст продуктов.
     */
    public double calculateAveragePrice(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
    }

    /**
     * Добавление продукта в БД.
     * @param product объект продукта.
     */
    public void addProduct(Product product) {
        repository.addProduct(product);
    }
}
