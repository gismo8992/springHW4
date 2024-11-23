package com.example.springSem4Task3.repository;

import com.example.springSem4Task3.ProductMapper;
import com.example.springSem4Task3.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductRepository {
    /**
     * Объект подключения к БД.
     */
    private final JdbcTemplate jdbc;

    private final ProductMapper productMapper;

    public ProductRepository(JdbcTemplate jdbc, ProductMapper userMapper) {
        this.jdbc = jdbc;
        this.productMapper = userMapper;
    }

    /**
     * Получение списка продуктов.
     * @return список продуктов.
     */
    public List<Product> getProduct() {
        String sql = "select * from \"product\"";
        return jdbc.query(sql, productMapper);
    }

    /**
     * Добавление продукта в БД.
     * @param product объект продукта.
     */
    public void addProduct(Product product){
        String sql = "insert into \"product\" (name, age, price) values (?, ?)";
        jdbc.update(sql, product.getName(), product.getPrice());
    }
}
