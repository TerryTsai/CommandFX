package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.commandfx.utils.DragResizer;
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

        Parent content = _execute(command);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label title = new Label(command, new Rectangle(10, 10, Paint.valueOf("#fff")));

        Button hide = new Button("\u2012");
        hide.setOnAction(event -> Platform.runLater(() -> {
            if (container.getChildren().contains(content))
                container.getChildren().remove(content);

        }));

        Button show = new Button("\u25a1");
        show.setOnAction(event -> Platform.runLater(() -> {
            if (!container.getChildren().contains(content))
                container.getChildren().add(content);
        }));

        Button detach = new Button("\u25b2");
        detach.setOnAction(event -> Platform.runLater(() -> {
            container.getChildren().remove(content);
            StackPane root = new StackPane(content);
            Scene scene = new Scene(root);
            scene.setUserAgentStylesheet("global.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setOnCloseRequest(e -> Platform.runLater(() -> {
                root.getChildren().remove(content);
                container.getChildren().add(content);
            }));
            stage.show();
        }));

        HBox header = new HBox(title, spacer, hide, show, detach);

        container.getChildren().setAll(header, content);

        DragResizer.makeResizable(container);

        return container;

    }

    protected abstract Parent _execute(String command);

}
