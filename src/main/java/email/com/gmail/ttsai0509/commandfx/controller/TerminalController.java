package email.com.gmail.ttsai0509.commandfx.controller;

import email.com.gmail.ttsai0509.commandfx.CommandFX;
import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.fx.AppCtrl;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TerminalController implements AppCtrl<CommandFX> {

    @FXML public BorderPane root;
    @FXML public TextField terminalIn;
    @FXML public VBox terminalOut;
    @FXML public ScrollPane terminalOutScroll;

    @FXML public Accordion accordion;

    private Terminal terminal;

    @Override
    public void postLoad(CommandFX app) {
        terminal = app.getTerminal();
        terminalIn.setOnKeyPressed(getExecuteHandler());
        terminalOut.setFillWidth(true);
        terminalOutScroll.setFitToWidth(true);
    }

    private EventHandler<KeyEvent> getExecuteHandler() {
        return event -> {
            if (event.getCode() == KeyCode.ENTER) {

                Parent cmdWindow = terminal.run(terminalIn.getText());

                if (cmdWindow != null) {
                    Platform.runLater(() -> {
                        terminalIn.setText("");
                        terminalOut.getChildren().add(0, cmdWindow);
                        terminalOutScroll.setVvalue(0);
                    });
                }

            }
        };
    }
}
