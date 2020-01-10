package my.test.receiver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    private MyMessageService myMessageService;

    @Autowired
    public ConsumerServiceImpl(MyMessageService myMessageService) {
        this.myMessageService = myMessageService;
    }

    @KafkaListener(topics = "totopic", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        myMessageService.createMessage(message);
    }

}
