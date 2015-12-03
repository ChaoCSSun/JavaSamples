/**
 * 代理模式
 *
 * Created by Tikitoo on 2015/12/4.
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("xx.avi");
        image.display();
        System.out.println("-------------");
        image.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("display" + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("load" + fileName);
    }
}

class ProxyImage implements Image {
    private RealImage mRealImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (mRealImage == null) {
            mRealImage = new RealImage(fileName);
        }
        mRealImage.display();
    }
}