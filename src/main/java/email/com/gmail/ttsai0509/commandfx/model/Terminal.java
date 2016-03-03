package email.com.gmail.ttsai0509.commandfx.model;

import email.com.gmail.ttsai0509.commandfx.command.*;
import email.com.gmail.ttsai0509.commandfx.utils.CommandUtils;
import javafx.scene.Parent;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Terminal {

    private File pwd;
    private Default defaultCmd;
    private Map<String, Command> commandMap;

    /**
     * Creates a new terminal with its own private set of fields.
     *
     * @param initPath Directory to start in (if null, will default to C:/
     *
     */
    public Terminal(String initPath) {
        pwd = (initPath == null || initPath.isEmpty()) ? new File("C:/") : new File(initPath);

        defaultCmd = new Default(this);

        // Register each non-default, built-in command
        commandMap = new HashMap<>();
        commandMap.put("cd", new Cd(this));
        commandMap.put("drive", new Drive(this));
        commandMap.put("img", new Image(this));
        commandMap.put("exit", new Exit(this));
        commandMap.put("media", new Media(this));
        commandMap.put("web", new Web(this));
    }

    public Parent run(String command) {
        Command cmd = commandMap.getOrDefault(CommandUtils.getProgram(command), defaultCmd);
        return cmd.execute(command.trim());
    }

    public File getPwd() {
        return pwd;
    }

    public void setPwd(File pwd) {
        this.pwd = pwd;
    }

}
