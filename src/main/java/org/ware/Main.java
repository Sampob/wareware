package org.ware;

import org.ware.output.CLInterface;
import org.ware.output.IOutput;
import org.ware.service.BasicService;
import org.ware.service.IService;

public class Main {
    public static void main(String[] args) {
        IOutput output = new CLInterface();
        IService service = new BasicService();

        MainController mainController = new MainController(output, service);

        try {
            mainController.execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}