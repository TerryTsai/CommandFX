package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public abstract class Command {

    protected final Terminal context;

    public Command(Terminal context) {
        this.context = context;
    }

    public Parent execute(String command) {

        VBox container = new VBox();

        Parent result = _execute(command);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label title = new Label(command, new Rectangle(10, 10, Paint.valueOf("#fff")));

        Button toggle = new Button("Toggle");
        toggle.setOnAction(event -> Platform.runLater(() -> {
            if (container.getChildren().contains(result)) {
                container.getChildren().remove(result);
            } else {
                container.getChildren().add(result);
            }
        }));

        Button detach = new Button("Detach");
        detach.setOnAction(event -> Platform.runLater(() -> {
            container.getChildren().remove(result);
            StackPane root = new StackPane(result);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setOnCloseRequest(e -> Platform.runLater(() -> {
                root.getChildren().remove(result);
                container.getChildren().add(result);
            }));
            stage.show();
        }));

        HBox header = new HBox(title, spacer, toggle, detach);

        container.getChildren().setAll(header, result);

        return container;

    }

    protected abstract Parent _execute(String command);

}
