package my.test.receiver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyMessage {

    @Id
    @GeneratedValue
    private Long id;

    private String messageText;

    public MyMessage(Long id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }

    public MyMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "id=" + id +
                ", messageText='" + messageText + '\'' +
                '}';
    }

}
