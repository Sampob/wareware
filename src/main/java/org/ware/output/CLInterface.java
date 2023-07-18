package org.ware.output;

import org.ware.module.IModel;
import org.ware.module.Status;

public class CLInterface implements IOutput {

    public CLInterface() {

    }

    private void print(String string) {
        System.out.println(string);
    }
    @Override
    public void update(IModel model) {
        Status status = (Status) model;
        this.print(status.getData());
    }
}
