package my.test.receiver.service;

import my.test.receiver.POJO.MyMessage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class SenderServiceImplTest {

    @Autowired
    private SenderServiceImpl senderService;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    private String testString = "test message";

    @Test
    void sendMessageTest() {
        MyMessage myMessage = new MyMessage();
        myMessage.setMessageText(testString);

        assertEquals(testString, myMessage.getMessageText());

        assertEquals(testString, senderService.sendMessage(myMessage));

        Mockito.verify(kafkaTemplate, Mockito.times(1))
                .send(
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.eq(myMessage.getMessageText())
                );
    }
}