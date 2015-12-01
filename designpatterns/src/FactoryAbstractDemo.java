/**
 * 抽象工厂模式
 *
 * http://www.importnew.com/6914.html
 * Created by Tikitoo on 2015/12/1.
 */
public class FactoryAbstractDemo {
    public static void main(String[] args) {
        new Computer(createSpecificFactory());
    }


    public static CPUFactory createSpecificFactory() {
        int sys = 0;
        if (sys == 0) {
            return new AMDFactory();
        } else {
            return new IntelFactory();
        }
    }
}

interface CPU {
    void process();
}

class AMDCPU implements CPU {
    @Override
    public void process() {
        System.out.println("AMD is process...");
    }
}

class IntelCPU implements CPU {
    @Override
    public void process() {
        System.out.println("Intel is process...");
    }
}

interface CPUFactory {
    CPU productCPU();
}

class AMDFactory implements CPUFactory {

    @Override
    public CPU productCPU() {
        return new AMDCPU();
    }
}

class IntelFactory implements CPUFactory {

    @Override
    public CPU productCPU() {
        return new IntelCPU();
    }
}

class Computer {
    CPU mCPU;

    public Computer(CPUFactory factory) {
        mCPU = factory.productCPU();
        mCPU.process();
    }
}

