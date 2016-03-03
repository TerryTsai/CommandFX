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

    public Terminal(String initPath) {
        pwd = (initPath == null || initPath.isEmpty()) ? new File("C:") : new File(initPath);

        defaultCmd = new Default();

        commandMap = new HashMap<>();
        commandMap.put("cd", new Cd(this));
        commandMap.put("drive", new Drive(this));
        commandMap.put("img", new Image());
        commandMap.put("exit", new Exit());
        commandMap.put("media", new Media());
    }

    public Parent command(String command) {
        Command cmd = commandMap.getOrDefault(CommandUtils.getProgram(command), defaultCmd);
        return cmd.execute(pwd, command.trim());
    }

    public File getPwd() {
        return pwd;
    }

    public void setPwd(File pwd) {
        this.pwd = pwd;
    }

}
