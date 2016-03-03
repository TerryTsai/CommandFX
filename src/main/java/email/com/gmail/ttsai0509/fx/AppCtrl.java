package email.com.gmail.ttsai0509.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

public interface AppCtrl<A extends Application> {

    /*
     * Implement the postLoad method to grab dependencies
     * from the application context when loaded through
     * the FXMLLoader wrappers below.
     *
     */

    public void postLoad(A app);

    /* FXMLLoader Wrappers */

    public static <A extends Application, C extends AppCtrl<A>> C loadGetCtrl(URL resource, A app) {
        try {
            FXMLLoader loader = new FXMLLoader(resource);
            loader.load();
            C ctrl = loader.getController();
            ctrl.postLoad(app);
            return ctrl;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <A extends Application, C extends AppCtrl<A>> FXMLLoader loadGetLoader(URL resource, A app) {
        try {
            FXMLLoader loader = new FXMLLoader(resource);
            loader.load();
            C ctrl = loader.getController();
            ctrl.postLoad(app);
            return loader;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T, A extends Application, C extends AppCtrl<A>> T loadGetRoot(URL resource, A app) {
        try {
            FXMLLoader loader = new FXMLLoader(resource);
            T root = loader.load();
            C ctrl = loader.getController();
            ctrl.postLoad(app);
            return root;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
