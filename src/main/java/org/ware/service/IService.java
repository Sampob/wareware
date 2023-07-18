package org.ware.service;

import org.ware.module.IModel;

public abstract class IService implements Runnable {
    public abstract boolean getStatus();
    public abstract IModel getModel();
}
