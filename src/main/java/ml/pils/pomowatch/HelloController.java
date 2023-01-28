package ml.pils.pomowatch;

import javafx.animation.KeyFrame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Timer;

import static java.lang.Thread.sleep;

public class HelloController {
    public Label timer;
    @FXML
    private Label welcomeText;
    private boolean semaphore;


    @FXML
    protected void onTimerButtonClick() throws InterruptedException {
        //start a timer here
        semaphore = !semaphore;

        KeyFrame keyFrame = new KeyFrame(javafx.util.Duration.seconds(1), event -> {
            long time = getTimeInSeconds(timer);
            time++;
            timer.setText(time / 3600 + ":" + time / 60 + ":" + time % 60);
        });

    }

    private long getTimeInSeconds(Label timer) {

        String[] time = timer.getText().split(":");
        return Integer.parseInt(time[0]) * 3600L + Integer.parseInt(time[1]) * 60L + Integer.parseInt(time[2]);
    }
}