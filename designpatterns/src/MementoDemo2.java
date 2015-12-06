import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式（备份模式）
 *
 * Created by Tikitoo on 2015/12/6.
 */
public class MementoDemo2 {
    public static void main(String[] args) {
        Origintor origintor = new Origintor();
        CareTaker careTaker = new CareTaker();

        origintor.setState("state 1");
        origintor.setState("state 2");
        careTaker.add(origintor.saveStateToMemento());

        origintor.setState("state 3");
        careTaker.add(origintor.saveStateToMemento());

        origintor.setState("state 4");
        System.out.println("current state: " + origintor.getState());

        origintor.getStateFromMemento(careTaker.get(0));
        System.out.println("first save state: " + origintor.getState());

        origintor.getStateFromMemento(careTaker.get(1));
        System.out.println("second save state: " + origintor.getState());

    }
}

class Memento2 {
    private String state;

    public Memento2(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Origintor {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento2 saveStateToMemento() {
        return new Memento2(state);
    }
    public void getStateFromMemento(Memento2 memento2) {
        state = memento2.getState();
    }

}

class CareTaker {
    private List<Memento2> mMemento2List = new ArrayList<Memento2>();

    public void add(Memento2 state) {
        mMemento2List.add(state);
    }

    public Memento2 get(int index) {
        return mMemento2List.get(index);
    }
}




