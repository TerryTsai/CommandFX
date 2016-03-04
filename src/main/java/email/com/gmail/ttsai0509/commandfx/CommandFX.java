package email.com.gmail.ttsai0509.commandfx;

import email.com.gmail.ttsai0509.commandfx.controller.MainController;
import email.com.gmail.ttsai0509.commandfx.controller.TerminalController;
import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.fx.AppCtrl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommandFX extends Application {

    public static void main(String[] args) {
        Application.launch(CommandFX.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        MainController mainCtrl = AppCtrl.loadGetCtrl(getClass().getResource("/main.fxml"), this);

        Scene scene = new Scene(mainCtrl.root, 800, 600);
        primaryStage.setTitle("CommandFX");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> Platform.runLater(() -> {
            Platform.exit();
            System.exit(0);
        }));

        primaryStage.show();
    }

}
