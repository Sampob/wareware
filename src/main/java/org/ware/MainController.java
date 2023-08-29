package org.ware;

import org.ware.output.IOutput;
import org.ware.service.AService;

import java.util.concurrent.TimeUnit;

public class MainController {

    private final IOutput output;
    private final AService service;

    public MainController(IOutput output, AService service) {
        this.output = output;
        this.service = service;
    }

    private void updateOutput() {
        this.output.update(this.service.getModel());
    }

    public void execute() throws InterruptedException {
        Thread thread = new Thread(this.service);
        thread.start();
        do {
            this.updateOutput();
            TimeUnit.MILLISECONDS.sleep(550);
        } while (this.service.getStatus());
        this.updateOutput();
    }

}
