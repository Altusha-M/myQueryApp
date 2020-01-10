package my.test.receiver.service;

import my.test.receiver.entity.MyMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ConsumerServiceImplTest {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    MyMessageService messageService;

    @Test
    void consume() {
        String s = "my message for db";
        consumerService.consume(s);
        List<MyMessage> messages = (List<MyMessage>) messageService.getMessages();
        Assertions.assertEquals(s, messages.get(0).getMessageText());
        System.out.println(messages.get(0).getMessageText());
        int j = 50;
        for (int i = j; i > 0; i--) {
            consumerService.consume("test message " + i);
        }
        Assertions.assertEquals(j + 1, messageService.getMessages().size());
        messageService.getMessages().stream()
                .map(MyMessage::getMessageText)
                .forEach(System.out::println);
    }
}