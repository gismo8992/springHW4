package com.example.springSem4Task3;

import com.example.springSem4Task3.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        return product;
    }
}
