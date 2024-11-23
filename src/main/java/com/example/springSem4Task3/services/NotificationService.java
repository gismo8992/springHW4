package com.example.springSem4Task3.services;

import com.example.springSem4Task3.models.Product;
import org.springframework.stereotype.Service;

/**
 * Сервис консольных уведомлений (логирование).
 */
@Service
public class NotificationService {

    /**
     * Уведомление о создании нового пользователя.
     * @param product объект пользователя.
     */
    public void notifyProduct(Product product) {
        System.out.println("A new product has been created: " + product.getName());
    }

    /**
     * Вывод заданного уведомления в консоль.
     * @param s сообщение для вывода.
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
