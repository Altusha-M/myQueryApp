package my.test.receiver.service;

import my.test.receiver.entity.MyMessage;
import my.test.receiver.repository.MyMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyMessageServiceImpl implements MyMessageService {

    private MyMessageRepository messageRepository;

    @Autowired
    public MyMessageServiceImpl(MyMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void createMessage(MyMessage message) {
        messageRepository.save(message);
    }

    /**
     * save message from String to message repository
     *
     * @param message message to save in repo
     */
    @Override
    public void createMessage(String message) {
        MyMessage temp = new MyMessage();
        temp.setMessageText(message);
        messageRepository.save(temp);
    }

    /**
     * @return Collection of messages
     */
    @Override
    public Collection<MyMessage> getMessages() {
        return (Collection<MyMessage>) messageRepository.findAll();
    }


}
