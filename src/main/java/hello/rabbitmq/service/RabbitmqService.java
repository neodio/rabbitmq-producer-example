package hello.rabbitmq.service;

import hello.rabbitmq.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RabbitmqService {

    private final RabbitTemplate rabbitTemplate;

    public static final  String EXCHANGE_1 = "exchange1";

    public static final String BIND_KEY_AAA = "AAA";

    public static final String BIND_KEY_BBB = "BBB";

    public void addQueue(Message message){
        rabbitTemplate.convertAndSend(EXCHANGE_1, BIND_KEY_AAA, message);
    }

    public void addQueueList(Message message){
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend(EXCHANGE_1, BIND_KEY_BBB, message);
        }
    }

}
