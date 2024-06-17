package webinterface.webinteractor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import webinterface.webinteractor.Model.DbException;

import java.io.IOException;

public class SceneChanger {

    static void ChangeToDefaultScene(Stage currentStage, String username){
        try {
            FXMLLoader loader = new FXMLLoader(SceneChanger.class.getResource("defaultView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Get the stage from the button's scene and set the new scene
            Stage stage = currentStage;
            stage.setScene(scene);
            stage.show();
            defaultViewController controller = loader.getController();
            controller.displayName(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
