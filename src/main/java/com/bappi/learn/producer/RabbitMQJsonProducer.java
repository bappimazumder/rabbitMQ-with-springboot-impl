package com.bappi.learn.producer;

import com.bappi.learn.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq-exchange-name}")
    public String EXCHANGE_NAME;

    @Value("${rabbitmq-routing-json-key}")
    public String ROUTING_JSON_KEY;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(UserInfoDto requestDto) {
        log.info("Sending json message: {}", requestDto.toString());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_JSON_KEY, requestDto);
    }


}
