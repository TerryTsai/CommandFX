package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.commandfx.utils.CommandUtils;
import email.com.gmail.ttsai0509.commandfx.utils.ResizableImageView;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

import java.io.File;

public class Gallery extends Command {

    public Gallery(Terminal context) {
        super(context);
    }

    @Override
    protected Parent _execute(String command) {

        File imgPath = new File(context.getPwd(), CommandUtils.getArgs(command));

        if (!imgPath.exists() || !imgPath.isDirectory())
            return new Label("Unable to find images");

        TilePane pane = new TilePane();

        for (File file : imgPath.listFiles()) {
            try {

                ImageView image = new ImageView(file.toURI().toString());

                image.setPreserveRatio(true);

                pane.getChildren().add(image);

            } catch (Exception ignore) {}
        }

        return pane;
    }
}
