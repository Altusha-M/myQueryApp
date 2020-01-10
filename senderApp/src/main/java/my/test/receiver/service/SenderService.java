package my.test.receiver.service;

import my.test.receiver.POJO.MyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class SenderService {

    private static final Logger logger = LoggerFactory.getLogger(SenderService.class);
    private static final String TOPIC = "totopic";

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public SenderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * <p>
     * This method send message to kafka
     * </p>
     *
     * @param message this message will be send to kafka queue
     * @return text of sent message
     */
    public String sendMessage(MyMessage message) {
        logger.info(String.format("#### -> Producing message -> %s", message.toString()));
        ListenableFuture<SendResult<String, String>> send = this.kafkaTemplate.send(TOPIC, message.getMessageText());
        return message.getMessageText();
    }

}
