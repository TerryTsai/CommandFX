package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.File;

public class Exit extends Command {

    public Exit(Terminal context) {
        super(context);
    }

    @Override
    protected Parent _execute(String command) {

        // TODO : This should close the terminal instead of the program
        Platform.runLater(() -> {
            Platform.exit();
            System.exit(0);
        });

        return new Label("Exiting");

    }

}
