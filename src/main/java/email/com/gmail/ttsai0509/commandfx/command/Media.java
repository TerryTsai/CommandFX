package email.com.gmail.ttsai0509.commandfx.command;

import email.com.gmail.ttsai0509.commandfx.utils.CommandUtils;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;


public class Media extends Command {

    @Override
    protected Parent _execute(File pwd, String command) {

        File mediaFile = new File(pwd, CommandUtils.getArgs(command));

        javafx.scene.media.Media media = new javafx.scene.media.Media(mediaFile.toURI().toString());

        MediaPlayer player = new MediaPlayer(media);

        player.setAutoPlay(true);

        return new StackPane(new MediaView(player));

    }
}
