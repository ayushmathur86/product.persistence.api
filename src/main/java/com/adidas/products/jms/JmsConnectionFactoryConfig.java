package com.adidas.products.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConnectionFactoryConfig {

    @Value("${spring.activemq.broker-url}")
    private String mqUrl;

    @Value("${spring.activemq.user}")
    private String mqUser;

    @Value("${spring.activemq.password}")
    private String mqPassword;

    /**
     * Method to initialize ConnectionFactory for the queue.
     * 
     * @return instance of ConnectionFactory.
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(mqUrl);
        connectionFactory.setUserName(mqUser);
        connectionFactory.setPassword(mqPassword);
        return connectionFactory;
    }

    /**
     * Method to serialize message content to JSON.
     * 
     * @return instance of MessageConverter.
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    /**
     * Method to initialize JMSListener factory for receiving messages over
     * queue.
     * 
     * @param connectionFactory
     *            instance of ConnectionFactory.
     * @param configurer
     *            instance of DefaultJmsListenerContainerFactoryConfigurer.
     * @return instance of JMSListenerContainerFactory.
     */
    @Bean
    public JmsListenerContainerFactory<?> queueFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(jacksonJmsMessageConverter());
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
