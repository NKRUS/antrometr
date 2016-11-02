package ru.kit.antrometr;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mikha on 26.10.2016.
 */
public class AntrometrStage extends Stage {

    private static final String SERVICE_NAME = "Antrometr";

    public AntrometrStage(boolean isMan, boolean isWoman, double height, double weight, String path) throws Exception {

        Antrometr antrometr = new Antrometr(isMan, isWoman, height, weight);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ru/kit/antrometr/fxml/antrometr.fxml"));
        Parent root = loader.load();

        AntrometrController controller = loader.getController();
        controller.setAntrometr(antrometr);
        controller.setPath(path);
        controller.setStage(this);

        this.setScene(new Scene(root));
    }
}
