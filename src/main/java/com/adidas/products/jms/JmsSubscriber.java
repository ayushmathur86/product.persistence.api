package com.adidas.products.jms;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.adidas.products.model.Product;
import com.adidas.products.repository.ProductRepository;

@Component
public class JmsSubscriber {

    @Autowired
    private ProductRepository repository;

    private static final Logger LOGGER = Logger.getLogger("Adidas");

    /**
     * Method to receive message from the queue and persist into database.
     * 
     * @param product
     *            source object to persist.
     */
    @JmsListener(destination = "${product.persist.source.queue}", containerFactory = "queueFactory")
    public void receiveMessage(final Product product) {
        LOGGER.log(Level.INFO, "Received message for persistence");
        repository.save(product);
    }
}
