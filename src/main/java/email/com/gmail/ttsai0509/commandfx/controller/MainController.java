package email.com.gmail.ttsai0509.commandfx.controller;

import email.com.gmail.ttsai0509.commandfx.CommandFX;
import email.com.gmail.ttsai0509.fx.AppCtrl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class MainController implements AppCtrl<CommandFX> {

    @FXML public BorderPane root;
    @FXML public MenuItem exit;
    @FXML public MenuItem create;
    @FXML public TabPane terminals;

    @Override
    public void postLoad(CommandFX app) {

        exit.setOnAction(event -> Platform.runLater(() -> {
            Platform.exit();
            System.exit(0);
        }));

        create.setOnAction(event -> Platform.runLater(() -> {
            Parent terminal = AppCtrl.loadGetRoot(getClass().getResource("/terminal.fxml"), app);
            terminals.getTabs().add(new Tab("cfx", terminal));
        }));

        // Create initial terminal
        Platform.runLater(() -> {
            Parent terminal = AppCtrl.loadGetRoot(getClass().getResource("/terminal.fxml"), app);
            terminals.getTabs().add(new Tab("cfx", terminal));
        });

    }

}
