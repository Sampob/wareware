package org.ware.module;

public class Status implements IModel {

    private String data;
    public Status() {
        this.data = "";
    }

    public Status(String statusData) {
        this.data = statusData;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean compare(IModel model) {
        boolean returnValue = true;
        Status modelStatus = (Status) model;

        if (!modelStatus.getData().equals(this.data)) {
            returnValue = false;
            this.data = modelStatus.getData();
        }
        return returnValue;
    }

    @Override
    public IModel createCopy() {
        return new Status(this.data);
    }
}
