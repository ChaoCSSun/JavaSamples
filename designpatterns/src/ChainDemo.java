/**
 * 责任链模式
 *
 * 一个对象持有下一个对象的引用，就成了一个链
 * 例子：递归实现；不同类型的日志
 *
 * http://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm
 * http://zz563143188.iteye.com/blog/1847029
 * Created by Tikitoo on 2015/12/7.
 */
public class ChainDemo {
    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMsg(AbstractLogger.INFO, "info");
        loggerChain.logMsg(AbstractLogger.DEBUG, "debug");
        loggerChain.logMsg(AbstractLogger.ERROR, "error");
    }

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}

abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMsg(int level, String msg) {
        if (this.level <= level) {
            write(msg);
        }
        if (nextLogger != null) {
            nextLogger.logMsg(level, msg);
        }
    }

    protected abstract void write(String msg);
}

class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("Standard Console::Lopper: " + msg);
    }
}
class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("Error::Lopper: " + msg);
    }
}

class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("File::Lopper: " + msg);
    }
}

interface Handler {
    void operator();
}

abstract class AbstractHandler {
    private Handler mHandler;

    public Handler getHandler() {
        return mHandler;
    }

    public void setHandler(Handler handler) {
        mHandler = handler;
    }
}

class MyHandler extends AbstractHandler implements Handler {
    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + " deal");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}

class ChainDemo2 {
    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");
        h1.setHandler(h2);
        h2.setHandler(h3);

        h1.operator();
    }
}
