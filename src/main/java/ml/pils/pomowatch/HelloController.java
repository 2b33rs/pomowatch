package ml.pils.pomowatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Timer;

import static java.lang.Thread.sleep;

public class HelloController {
    public Label timer;
    public Button control_btn;
    @FXML
    private boolean semaphore;
    Timeline timeline;


    @FXML
    protected void onTimerButtonClick() {
        //start a timer here
        semaphore = !semaphore;
        if (semaphore) {
            timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), event -> {
                long time = getTimeInSeconds(timer);
                time++;
                timer.setText(time / 3600 + ":" + time / 60 + ":" + time % 60);
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            control_btn.setText("Stop!");
        } else {
            timeline.stop();
            control_btn.setText("Start!");
        }
    }

    private long getTimeInSeconds(Label timer) {

        String[] time = timer.getText().split(":");
        return Integer.parseInt(time[0]) * 3600L + Integer.parseInt(time[1]) * 60L + Integer.parseInt(time[2]);
    }
}