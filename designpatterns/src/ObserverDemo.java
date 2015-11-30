import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 *
 * http://blog.csdn.net/kenthong/article/details/5725522
 * http://www.importnew.com/7924.html
 * Created by Tikitoo on 2015/11/30.
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Reader reader = new Reader();

        Publisher publisher = new Publisher();
        publisher.addObserver(reader);
        publisher.publish("Just is fun");

        TVStation tvStation = new TVStation();
        tvStation.addObserver(reader);
        tvStation.play("色戒");
    }
}


class Publisher extends Observable {
    private String magazineName;

    public String getMagazineName() {
        return magazineName;
    }

    public void publish(String magazineName) {
        this.magazineName = magazineName;
        setChanged();
        notifyObservers(this);
    }
}


class TVStation extends Observable {
    private String programName;

    public void play(String programName) {
        this.programName = programName;
        setChanged();
        notifyObservers(this);
    }

    public String getProgramName() {
        return programName;
    }

}

class Reader implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Publisher) {
            Publisher publisher = (Publisher) o;
            System.out.println("我要订阅" + publisher.getMagazineName());
        }

        if (o instanceof TVStation){
            TVStation tvStation = (TVStation) o;
            System.out.println("我要看" + tvStation.getProgramName());
        }

    }
}

