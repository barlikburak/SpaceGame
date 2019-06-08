package gamespace;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.FXMLViewManagerController;

public class GameSpace extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLViewManager.fxml"));
        Parent root = loader.load();

        FXMLViewManagerController fXMLViewManagerController = loader.getController();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        fXMLViewManagerController.setMenuStage(stage);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
