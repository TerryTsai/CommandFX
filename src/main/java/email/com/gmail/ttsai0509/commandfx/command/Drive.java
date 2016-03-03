package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.commandfx.utils.CommandUtils;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;

public class Drive extends Command {

    private final Terminal context;

    public Drive(Terminal context) {
        this.context = context;
    }

    @Override
    protected Parent _execute(File pwd, String command) {

        File start = context.getPwd();
        File end = new File(CommandUtils.getArgs(command));

        if (!end.exists() || !end.isDirectory()) {
            context.setPwd(start);
            return new Label("System can not find the path specified.");
        } else {
            try {
                context.setPwd(end);
                return new Label(end.getCanonicalPath());
            } catch (IOException e) {
                context.setPwd(start);
                return new Label("System can not find the path specified.");
            }
        }

    }
}