import java.util.Date;

/**
 *
 * 中介模式
 *
 * Created by Tikitoo on 2015/12/6.
 */
public class MediatorDemo2 {
    public static void main(String[] args) {
        User3 robert = new User3("robert");
        User3 john = new User3("john");
        robert.sendMsg("Hi John");
        john.sendMsg("Hi Robert");
    }
}

class ChatRoom {
    public static void showMsg(User3 user3, String msg) {
        System.out.println(new Date().toString() + user3.getName() + ": " + msg);
    }
}

class User3 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User3(String name) {
        this.name = name;
    }

    public void sendMsg(String msg) {
        ChatRoom.showMsg(this, msg);
    }
}
