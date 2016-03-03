package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.commandfx.utils.CommandUtils;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;

public class Drive extends Command {

    public Drive(Terminal context) {
        super(context);
    }

    @Override
    protected Parent _execute(String command) {

        File start = context.getWorkingDir();
        File end = new File(CommandUtils.getArgs(command));

        if (!end.exists() || !end.isDirectory()) {
            context.setWorkingDir(start);
            return new Label("System can not find the path specified.");
        } else {
            try {
                context.setWorkingDir(end);
                return new Label(end.getCanonicalPath());
            } catch (IOException e) {
                context.setWorkingDir(start);
                return new Label("System can not find the path specified.");
            }
        }

    }
}
