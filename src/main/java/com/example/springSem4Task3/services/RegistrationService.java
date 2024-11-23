package com.example.springSem4Task3.services;

import com.example.springSem4Task3.models.Product;
import org.springframework.stereotype.Service;

/**
 * Сервис регистрации новых продуктов.
 */
@Service
public class RegistrationService {

    /**
     * Поле сервиса работы с хранилищем продуктов.
     */
    private final DataProcessingService dataProcessingService;

    /**
     * Поле сервиса создания продуктов.
     */
    private final ProductService productService;
    /**
     * Поле сервиса консольных уведомлений.
     */
    private final NotificationService notificationService;

    /**
     * Конструктор класса.
     * @param dataProcessingService сервис работы с хранилищем продуктов.
     * @param productService сервис создания продуктов.
     * @param notificationService сервис консольных уведомлений.
     */
    public RegistrationService(DataProcessingService dataProcessingService,
                               ProductService productService,
                               NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.productService = productService;
        this.notificationService = notificationService;
    }

    /**
     * Получение сервиса работы с хранилищем продуктов.
     * @return
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Сохранение продукта в БД.
     * @param name имя продукта.
     * @param price цена продукта.
     */
    public void processRegistration(String name, double price){
        Product createProduct = productService.createProduct(name, price);
        dataProcessingService.addProduct(createProduct);
        notificationService.sendNotification("Продукт сохранен в БД");
    }
}
