package my.test.receiver.controller;

import my.test.receiver.POJO.MyMessage;
import my.test.receiver.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SendController {

    private final SenderService senderService;

    @Autowired
    SendController(SenderService senderService) {
        this.senderService = senderService;
    }

    /**
     * <p>
     * This method catch POST http request and send message into SenderService
     * </p>
     *
     * @param message deserialized json of message from html form
     */
    @PostMapping
    public void sendMessageToKafkaTopic(@RequestBody MyMessage message) {
        this.senderService.sendMessage(message);
        System.out.println(message.toString());
    }

}
