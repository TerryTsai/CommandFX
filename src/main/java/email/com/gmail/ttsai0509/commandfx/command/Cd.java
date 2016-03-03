package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.commandfx.utils.CommandUtils;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;

public class Cd extends Command {

    public Cd(Terminal context) {
        super(context);
    }

    @Override
    protected Parent _execute(String command) {

        File start = context.getPwd();
        File end = new File(context.getPwd(), CommandUtils.getArgs(command));
        System.out.println("Cding into " + end.getAbsolutePath());

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
