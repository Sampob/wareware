package org.ware;

import org.ware.ui.GraphicalInterface;
import org.ware.ui.IUserInterface;
import org.ware.output.RegexService;
import org.ware.output.IOutput;
import org.ware.service.ClipboardService;
import org.ware.service.AService;

public class Main {
    public static void main(String[] args) {

        IUserInterface ui = new GraphicalInterface();
        IOutput output = new RegexService(ui);
        AService service = new ClipboardService();

        MainController mainController = new MainController(output, service);

        try {
            mainController.execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}