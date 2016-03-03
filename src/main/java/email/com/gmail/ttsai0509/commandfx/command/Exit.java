package email.com.gmail.ttsai0509.commandfx.command;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.File;

public class Exit extends Command {

    @Override
    protected Parent _execute(File pwd, String command) {
        Platform.runLater(() -> {
            Platform.exit();
            System.exit(0);
        });
        return new Label("Exiting");
    }

}
