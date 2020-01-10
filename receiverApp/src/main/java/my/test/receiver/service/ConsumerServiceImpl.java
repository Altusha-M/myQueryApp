package my.test.receiver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    private MyMessageService myMessageService;

    @Autowired
    public ConsumerServiceImpl(MyMessageService myMessageService) {
        this.myMessageService = myMessageService;
    }

    /**
     * receive message from kafka topic and save it to db
     *
     * @param message message to save in db
     */
    @KafkaListener(topics = "totopic", groupId = "group_id")
    public void consume(String message) {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        myMessageService.createMessage(message);
    }

}
