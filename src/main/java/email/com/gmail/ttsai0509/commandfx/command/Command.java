package email.com.gmail.ttsai0509.commandfx.command;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.File;

public abstract class Command {

    public Parent execute(File pwd, String command) {

        return new VBox(
                new Label(command, new Rectangle(10, 10, Paint.valueOf("#fff"))),
                _execute(pwd, command)
        );

    }

    protected abstract Parent _execute(File pwd, String command);

}
