package org.ware;

import org.ware.module.IModel;
import org.ware.output.IOutput;
import org.ware.service.IService;

import java.util.concurrent.TimeUnit;

public class MainController {

    private final IOutput output;
    private final IService service;
    private final IModel model;

    public MainController(IOutput output, IService service) {
        this.output = output;
        this.service = service;
        this.model = this.service.getModel().createCopy();;
    }

    private void updateOutput() {
        if (!this.model.compare(this.service.getModel())) {
            this.output.update(this.service.getModel());
        }
    }


    public void execute() throws InterruptedException {
        Thread thread = new Thread(this.service);
        thread.start();
        do {
            this.updateOutput();
            TimeUnit.MILLISECONDS.sleep(100);
        } while(this.service.getStatus());
        this.updateOutput();
    }

}
