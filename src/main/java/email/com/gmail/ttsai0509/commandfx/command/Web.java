package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.commandfx.utils.CommandUtils;
import javafx.scene.Parent;
import javafx.scene.web.WebView;

public class Web extends Command {

    public Web(Terminal context) {
        super(context);
    }

    @Override
    protected Parent _execute(String command) {

        WebView webView = new WebView();

        webView.getEngine().load(CommandUtils.getArgs(command));

        return webView;

    }

}
