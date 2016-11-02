package ru.kit.antrometr;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;


/**
 * Created by mikha on 26.10.2016.
 */
public class AntrometrController {

    private Antrometr antrometr;
    private String path;
    private AntrometrStage stage;
    private GraphicsContext gc;

    @FXML private Label heightField;
    @FXML private Label weightField;
//    @FXML private ChoiceBox<String> typeField;
    @FXML private Label IMTField;
    @FXML private TextField thoraxAloneField;
    @FXML private TextField horaxOnInspirationField;
    @FXML private TextField thoraxOnExhalationField;
    @FXML private TextField waistAboveNavelField;
    @FXML private TextField waistAtNavelField;
    @FXML private TextField buttocksField;
    @FXML private TextField volumeLeftFemurField;
    @FXML private TextField volumeRightFemurField;
    @FXML private TextField volumeLeftShoulderField;
    @FXML private TextField volumeRightshoulderField;
    @FXML private TextField flexibilitySpineField;
    @FXML private TextField abdominalMusclesField;
    @FXML private TextField backMusclesField;
    @FXML private TextField flexibilityJointsField;
    @FXML private Canvas picManCanvas;
    @FXML private ImageView picManImageView;

    public void setAntrometr(Antrometr antrometr)
    {
        this.antrometr = antrometr;

        heightField.setText(String.valueOf(antrometr.getHeight()));
        weightField.setText(String.valueOf(antrometr.getWeight()));
        IMTField.setText(String.format(Locale.US, "%.1f", antrometr.getIMT()));

        insertImage();

    }

    private void insertImage()
    {
        if (antrometr.isMan() && !antrometr.isWoman())
        {
            //picManImageView.setImage(new Image(getClass().getResource("/ru/kit/antrometr/image/pic_man.png").toString()));
            gc.drawImage(new Image(getClass().getResource("/ru/kit/antrometr/image/pic_man.png").toString()), 0.0, 0.0, 357, 629);
        }
        else if (antrometr.isWoman() && !antrometr.isMan())
        {
            //picManImageView.setImage(new Image(getClass().getResource("/ru/kit/antrometr/image/pic_woman.png").toString()));
            gc.drawImage(new Image(getClass().getResource("/ru/kit/antrometr/image/pic_woman.png").toString()), 0.0, 0.0, 357, 629);
        }
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public void setStage(AntrometrStage stage)
    {
        this.stage = stage;
    }

    @FXML
    public void initialize()
    {
        gc = picManCanvas.getGraphicsContext2D();
    }

    @FXML
    private void onCancel(ActionEvent event)
    {
        GraphicsContext gc = picManCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 365, 614);
        insertImage();
        thoraxAloneField.setText("");
        horaxOnInspirationField.setText("");
        thoraxOnExhalationField.setText("");
        waistAboveNavelField.setText("");
        waistAtNavelField.setText("");
        buttocksField.setText("");
        volumeLeftFemurField.setText("");
        volumeRightFemurField.setText("");
        volumeLeftShoulderField.setText("");
        volumeRightshoulderField.setText("");
        flexibilitySpineField.setText("");
        abdominalMusclesField.setText("");
        backMusclesField.setText("");
        flexibilityJointsField.setText("");
    }

    @FXML
    private void onDownload(ActionEvent event)
    {
        if (antrometr == null) {
            return;
        }
        //GraphicsContext gc = picManCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 365 , 614);
        insertImage();
        gc.fillText(String.valueOf(antrometr.getHeight()), 20, 300);
        try
        {
            if (thoraxAloneField.getText() != null && thoraxAloneField.getText().length() != 0)
            {
                antrometr.setThoraxAlone(thoraxAloneField.getText());
                if (antrometr.isMan() && !antrometr.isWoman())
                    gc.fillText(String.valueOf(antrometr.getThoraxAlone()), 180, 180);
                else
                    gc.fillText(String.valueOf(antrometr.getThoraxAlone()), 180, 160);
            }
            if (horaxOnInspirationField.getText() != null && horaxOnInspirationField.getText().length() != 0)
            {
                antrometr.setHoraxOnInspiration(horaxOnInspirationField.getText());
            }
            if (thoraxOnExhalationField.getText() != null && thoraxOnExhalationField.getText().length() != 0)
            {
                antrometr.setThoraxOnExhalation(thoraxOnExhalationField.getText());
            }
            if (waistAboveNavelField.getText() != null && waistAboveNavelField.getText().length() != 0)
            {
                antrometr.setWaistAboveNavel(waistAboveNavelField.getText());
                if (antrometr.isMan() && !antrometr.isWoman())
                    gc.fillText(String.valueOf(antrometr.getWaistAboveNavel()), 180, 250);
                else
                    gc.fillText(String.valueOf(antrometr.getWaistAboveNavel()), 180, 215);

            }
            if (waistAtNavelField.getText() != null && waistAtNavelField.getText().length() != 0)
            {
                antrometr.setWaistAtNavel(waistAtNavelField.getText());
            }
            if (buttocksField.getText() != null && buttocksField.getText().length() != 0)
            {
                antrometr.setButtocks(buttocksField.getText());
                if (antrometr.isMan() && !antrometr.isWoman())
                    gc.fillText(String.valueOf(antrometr.getButtocks()), 180, 321);
                else
                    gc.fillText(String.valueOf(antrometr.getButtocks()), 180, 290);

            }
            if (volumeLeftFemurField.getText() != null && volumeLeftFemurField.getText().length() != 0)
            {
                antrometr.setVolumeLeftFemur(volumeLeftFemurField.getText());
                if (antrometr.isMan() && !antrometr.isWoman())
                    gc.fillText(String.valueOf(antrometr.getVolumeLeftFemur()), 213, 375);
                else
                    gc.fillText(String.valueOf(antrometr.getVolumeLeftFemur()), 213, 370);
            }
            if (volumeRightFemurField.getText() != null && volumeRightFemurField.getText().length() != 0)
            {
                antrometr.setVolumeRightFemur(volumeRightFemurField.getText());
            }
            if (volumeLeftShoulderField.getText() != null && volumeLeftShoulderField.getText().length() != 0)
            {
                antrometr.setVolumeLeftShoulder(volumeLeftShoulderField.getText());
                if (antrometr.isMan() && !antrometr.isWoman())
                    gc.fillText(String.valueOf(antrometr.getVolumeLeftShoulder()), 253, 197);
                else
                    gc.fillText(String.valueOf(antrometr.getVolumeLeftShoulder()), 240, 187);
            }
            if (volumeRightshoulderField.getText() != null && volumeRightshoulderField.getText().length() != 0)
            {
                antrometr.setVolumeRightshoulder(volumeRightshoulderField.getText());
            }
            if (flexibilitySpineField.getText() != null && flexibilitySpineField.getText().length() != 0)
            {
                antrometr.setFlexibilitySpine(flexibilitySpineField.getText());
            }
            if (abdominalMusclesField.getText() != null && abdominalMusclesField.getText().length() != 0)
            {
                antrometr.setAbdominalMuscles(abdominalMusclesField.getText());
            }
            if (backMusclesField.getText() != null && backMusclesField.getText().length() != 0)
            {
                antrometr.setBackMuscles(backMusclesField.getText());
            }
            if (flexibilityJointsField.getText() != null && flexibilityJointsField.getText().length() != 0)
            {
                antrometr.setFlexibilityJoints(flexibilityJointsField.getText());
            }


        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Неверные данные");
            alert.setHeaderText("Вы ввели неверные данные");
            alert.setContentText("Проверьте поля." + System.lineSeparator() + "Возможно вы ввели букву вместо цифр." + System.lineSeparator() + "Исправьте и попробуйте еще раз.");
            alert.show();
        }
        catch (IllegalArgumentException e1)
        {
            e1.printStackTrace();
            Alert alertWarning = new Alert(Alert.AlertType.WARNING);
            alertWarning.setTitle("Неверные данные");
            alertWarning.setHeaderText("Неверное значение гибкости");
            alertWarning.setContentText("Введите значение от -10 до 10 и повторите попытку.");
            alertWarning.show();
        }
    }

    @FXML
    private void onSave(ActionEvent event)
    {
        if (antrometr == null)
        {
            return;
        }

        onDownload(event);

        try
        {
            WritableImage image = picManCanvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File(path + "antro_man.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        writeJSON();
        stage.close();
    }

    private void writeJSON()
    {
        try {
            String jsonFileName = path + "antro_output_file.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFileName));
            Throwable var2 = null;

            try {
                writer.write(this.createJSON().toString());
                System.out.println("JSON is written to " + jsonFileName);
            } catch (Throwable var12) {
                var2 = var12;
                throw var12;
            } finally {
                if (var2 != null) {
                    try {
                        writer.close();
                    } catch (Throwable var11) {
                        var2.addSuppressed(var11);
                    }
                } else {
                    writer.close();
                }
            }
        } catch (IOException var14) {
            var14.printStackTrace();
        }
    }

    private JSONObject createJSON()
    {

        JSONObject jsonObject = new JSONObject();

        for (InspectionName name : InspectionName.values()) {

            Double inspection = antrometr.getInspections().get(name);
            jsonObject.put(name.toString(), inspection);
        }

        return jsonObject;
    }

}
