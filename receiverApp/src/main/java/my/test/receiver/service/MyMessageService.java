package my.test.receiver.service;

import my.test.receiver.entity.MyMessage;

import java.util.Collection;

public interface MyMessageService {

    void createMessage(MyMessage message);
    void createMessage(String message);

    Collection<MyMessage> getMessages();

}
