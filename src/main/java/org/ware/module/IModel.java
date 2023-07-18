package org.ware.module;

public interface IModel {
    public abstract boolean compare(IModel model);
    public abstract IModel createCopy();
}
