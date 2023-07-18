package org.ware.service;

import org.ware.module.IModel;
import org.ware.module.Status;

import java.util.concurrent.TimeUnit;

public class BasicService extends IService {

    private final Status model;
    private boolean active;

    public BasicService() {
        this.model = new Status();
        this.active = false;
    }

    private void initiate() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            this.model.setData("Status: " + i);
            TimeUnit.SECONDS.sleep(1);
        }
        this.model.setData("Status: done");
    }

    @Override
    public boolean getStatus() {
        return this.active;
    }

    @Override
    public IModel getModel() {
        return this.model;
    }

    @Override
    public void run() {
        this.active = true;
        try {
            this.initiate();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.active = false;
    }
}
