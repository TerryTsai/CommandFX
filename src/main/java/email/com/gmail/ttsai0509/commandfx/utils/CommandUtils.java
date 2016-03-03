package email.com.gmail.ttsai0509.commandfx.utils;

public class CommandUtils {

    public static String getProgram(String command) {

        String trimmed = command.trim();

        int idx = trimmed.indexOf(' ');

        String result;
        if (idx <= 0) {
            result = trimmed;
        } else {
            result = trimmed.substring(0, idx);
        }

        return result;

    }

    public static String getArgs(String command) {
        String trimmed = command.trim();

        int idx = trimmed.indexOf(' ');

        String result;
        if (idx <= 0) {
            result = "";
        } else {
            result = trimmed.substring(idx + 1);
        }

        return result;
    }

}
