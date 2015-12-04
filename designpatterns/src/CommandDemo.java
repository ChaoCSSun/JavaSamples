/**
 * 命令模式
 *
 * http://zz563143188.iteye.com/blog/1847029
 * Created by Tikitoo on 2015/12/5.
 */
public class CommandDemo {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new CommandSub(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}

interface Command {
    void execute();
}

class CommandSub implements Command {
    private Receiver mReceiver;

    public CommandSub(Receiver receiver) {
        mReceiver = receiver;
    }

    @Override
    public void execute() {
        mReceiver.action();
    }
}

class Receiver {
    public void action() {
        System.out.println("Command Receiver");
    }
}

class Invoker {
    private Command mCommand;

    public Invoker(Command command) {
        mCommand = command;
    }

    public void action() {
        mCommand.execute();
    }
}
