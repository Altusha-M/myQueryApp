package my.test.receiver.controller;

import my.test.receiver.POJO.MyMessage;
import my.test.receiver.service.SenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SendController {

    private final SenderServiceImpl senderService;

    @Autowired
    SendController(SenderServiceImpl senderServiceImpl) {
        this.senderService = senderServiceImpl;
    }

    /**
     * <p>
     * This method catch POST http request and send message into SenderServiceImpl
     * </p>
     *
     * @param message deserialized json of message from html form
     */
    @PostMapping
    public void sendMessageToKafkaTopic(@RequestBody MyMessage message) {
        this.senderService.sendMessage(message);
    }

}
