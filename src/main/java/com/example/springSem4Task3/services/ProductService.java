package com.example.springSem4Task3.services;
import com.example.springSem4Task3.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис создания продуктов.
 */
@Service
public class ProductService {

    @Autowired
    private NotificationService notificationService;

    /**
     * Создание нового продукта.
     * @param name имя продукта.
     * @param price цена продукта.
     * @return созданного продукта.
     */
    public Product createProduct(String name, double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        // Отправляем уведомление о создании нового продукта
        notificationService.notifyProduct(product);

        return product;
    }
}
