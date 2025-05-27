package com.bappi.learn.controller;

import com.bappi.learn.dto.UserInfoDto;
import com.bappi.learn.producer.RabbitMQJsonProducer;
import com.bappi.learn.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bappi.learn.config.ApiPath.*;

@RestController
@RequestMapping(API_MSG_QUEUE)
public class RabbitMQController {


    private final RabbitMQProducer producer;
    private final RabbitMQJsonProducer jsonProducer;

    public RabbitMQController(RabbitMQProducer producer, RabbitMQJsonProducer jsonProducer) {
        this.producer = producer;
        this.jsonProducer = jsonProducer;
    }

    @GetMapping(API_SEND)
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully to RabbitMQ");
    }

    @GetMapping(API_SEND_JSON_MSG)
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserInfoDto message) {
        jsonProducer.sendJsonMessage(message);
        return ResponseEntity.ok("Json Message sent successfully to RabbitMQ");
    }
}
