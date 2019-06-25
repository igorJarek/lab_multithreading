package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class ExecutorImplementation implements Executor {

    private String whereExecute;

    public ExecutorImplementation(String whereExecute) {
        this.whereExecute = whereExecute;
    }

    @Override
    public void execute(Runnable command) {
        if(whereExecute.equals("sameThread"))
            command.run();
        else if (whereExecute.equals("diffThread"))
            new Thread(command).run();
    }
}
