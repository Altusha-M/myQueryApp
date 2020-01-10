package my.test.receiver.POJO;

public class MyMessage {

    public MyMessage(String messageText) {
        this.messageText = messageText;
    }

    public MyMessage() {
    }

    String messageText;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "{" +
                "messageText='" + messageText + '\'' +
                '}';
    }

}