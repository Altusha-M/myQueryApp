package my.test.receiver.service;

import my.test.receiver.entity.MyMessage;
import my.test.receiver.repository.MyMessageRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyMessageServiceImpl implements MyMessageService {

    MyMessageRepository messageRepository;

    public MyMessageServiceImpl(MyMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void createMessage(MyMessage message) {
        messageRepository.save(message);
    }

    @Override
    public void createMessage(String message) {
        MyMessage temp = new MyMessage();
        temp.setMessageText(message);
        messageRepository.save(temp);
    }

    @Override
    public Collection<MyMessage> getMessages() {
        return (Collection<MyMessage>) messageRepository.findAll();
    }

}
