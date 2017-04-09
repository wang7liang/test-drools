package wang7liang.test;

/**
 * Created by wang7liang on 2017/4/9.
 */
public class Message {
    public static final int HELLO = 0;
    public static final int GOODBYE = 1;

    private String message;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
