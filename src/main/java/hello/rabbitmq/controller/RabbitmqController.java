package hello.rabbitmq.controller;


import hello.rabbitmq.dto.Message;
import hello.rabbitmq.service.RabbitmqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RabbitmqController {

    private final RabbitmqService rabbitmqService;

    @PostMapping(value = "/send")
    public String send(@RequestBody Message message){
        rabbitmqService.addQueue(message);
        return "ok";
    }

    @PostMapping(value = "/sendList")
    public String sendList(@RequestBody Message message){
        rabbitmqService.addQueueList(message);
        return "ok";
    }
}
