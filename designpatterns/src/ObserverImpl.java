import java.util.ArrayList;

/**
 * 自己实现一个观察者模式
 * Created by Tikitoo on 2015/11/30.
 */
public class ObserverImpl {
    public static void main(String[] args) {
        HeadHunter hh = new HeadHunter();
        hh.registerObserver(new JobSeeker("Mike"));
        hh.registerObserver(new JobSeeker("John"));
        hh.registerObserver(new JobSeeker("Bill"));
        hh.addJobs("Google");
        hh.addJobs("Yahoo");
    }
}

class JobSeeker implements Observer2 {
    private String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject s) {
        System.out.println(this.name + "got notified!");
        System.out.println(s);
    }
}
interface Subject {
    void registerObserver(Observer2 o);
    void removeObserver(Observer2 o);
    void notifyAllObservers();
}

interface Observer2 {
    void update(Subject s);
}

class HeadHunter implements Subject {
    private ArrayList<Observer2> userList;
    private ArrayList<String> jobs;

    public HeadHunter() {
        userList = new ArrayList<Observer2>();
        jobs = new ArrayList<String>();
    }

    @Override
    public void registerObserver(Observer2 o) {
        userList.add(o);
    }

    @Override
    public void removeObserver(Observer2 o) {

    }

    @Override
    public void notifyAllObservers() {
        for(Observer2 o : userList) {
          o.update(this);
        }
    }

    public void addJobs(String job) {
        this.jobs.add(job);
        notifyAllObservers();
    }

    public ArrayList<String> getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
