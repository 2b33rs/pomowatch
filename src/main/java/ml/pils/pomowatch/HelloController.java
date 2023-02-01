package ml.pils.pomowatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.concurrent.atomic.AtomicLong;


public class HelloController {
    public Label stopwatch;
    public Button control_btn;
    @FXML
    private boolean semaphor;
    Timeline timeline;


    @FXML
    protected void onStopwatchButtonClick() {
        if (semaphor) {
            timeline.pause();
            control_btn.setText("Start");
            semaphor = false;
        } else {
            timeline.play();
            control_btn.setText("Stop");
            semaphor = true;
        }
    }


    @FXML
    protected void initialize() {
        AtomicLong seconds = new AtomicLong(0);
        timeline = new Timeline(new KeyFrame(
                javafx.util.Duration.seconds(1),
                ae -> {
                    seconds.getAndIncrement();
                    stopwatch.setText(formatTime(seconds.get()));
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    private String formatTime(long l) {
        long hours = l / 3600;
        long minutes = (l % 3600) / 60;
        long seconds = l % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}