package com.bappi.learn.consumer;

import com.bappi.learn.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq-queue-json-name}"})
    public void listenJsonMsg(UserInfoDto requestDto) {
        log.info("Received message: {}", requestDto.toString());

        System.out.println("Received message: " + requestDto);
    }
}
