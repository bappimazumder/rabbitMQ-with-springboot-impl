package com.bappi.learn.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = {"${rabbitmq-queue-name}"})
    public void listen(String message) {
        log.info("Received message: {}", message);

        System.out.println("Received message: " + message);
    }
}
