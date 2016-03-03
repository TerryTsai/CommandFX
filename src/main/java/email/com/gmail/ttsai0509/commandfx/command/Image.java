package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.model.Terminal;
import email.com.gmail.ttsai0509.commandfx.utils.CommandUtils;
import email.com.gmail.ttsai0509.commandfx.utils.ResizableImageView;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.File;

public class Image extends Command {

    public Image(Terminal context) {
        super(context);
    }

    @Override
    protected Parent _execute(String command) {

        File imgFile = new File(context.getPwd(), CommandUtils.getArgs(command));

        ImageView image = new ResizableImageView(imgFile.toURI().toString());

        image.setPreserveRatio(true);

        return new StackPane(image);

    }

}
