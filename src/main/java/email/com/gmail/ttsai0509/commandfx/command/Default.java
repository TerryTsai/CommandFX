package email.com.gmail.ttsai0509.commandfx.command;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.LogOutputStream;

import java.io.File;

public class Default extends Command {

    @Override
    protected Parent _execute(File pwd, String command) {

        ListView<String> output = new ListView<>();
        output.setItems(FXCollections.observableArrayList());

        new Thread(() -> {
            try {
                new ProcessExecutor()
                        .directory(pwd)
                        .command(command.split(" "))
                        .readOutput(true)
                        .redirectOutput(new LogOutputStream() {
                            @Override
                            protected void processLine(String line) {
                                Platform.runLater(() -> output.getItems().add(line));
                            }
                        })
                        .execute();

            } catch (Exception e) {
                Platform.runLater(() -> output.getItems().add(e.getMessage()));
            }
        }).start();

        return output;
    }

}
