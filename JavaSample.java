import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.media.*;
import javafx.scene.web.*;
import javafx.stage.*;

import java.nio.file.*;

public class JavaSample extends Application {
    public static void main(String[] args) {
        startAWT();

        SwingUtilities.invokeLater(JavaSample::startSwing);

        launch(args);
    }

    private static void startAWT() {
        Frame frame = new Frame("Hello, AWT!");

        frame.setSize(300, 300);
        frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent event) {
                    System.exit(0);
                }
            });

        final java.awt.Button button = new java.awt.Button("Hello, AWT!");

        button.addActionListener(event -> {
                button.setLabel("Button clicked!");
            });

        frame.add(button);

        frame.setVisible(true);
    }

    private static void startSwing() {
        JFrame frame = new JFrame("Hello, Swing!");

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        final JButton button = new JButton("Hello, Swing!");

        button.addActionListener(event -> {
                button.setText("Button clicked!");
            });
        
        frame.getContentPane().add(button);
 
        frame.setVisible(true);
    }

    @Override
    public void start(Stage primaryStage) {
        showWebView();

        primaryStage.setTitle("Hello, JavaFX!");

        final javafx.scene.control.Button button
            = new javafx.scene.control.Button();

        button.setText("Hello, JavaFX!");
        button.setOnAction(event -> {
                button.setText("Button clicked!");

                showMedia();
            });

        primaryStage.setScene(new Scene(button, 300, 300));

        primaryStage.show();
    }

    private void showMedia() {
        Stage stage = new Stage();

        // https://peach.blender.org/download/
        Path path = FileSystems.getDefault()
            .getPath("BigBuckBunny_320x180.mp4");
        Media media = new Media(path.toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        MediaView mediaView = new MediaView(mediaPlayer);
        Group root = new Group();

        root.getChildren().add(mediaView);

        Scene scene = new Scene(root, 320, 180);

        stage.setScene(scene);

        stage.show();
    }

    private void showWebView() {
        Stage stage = new Stage();

        stage.setTitle("WebView");

        WebView webView = new WebView();

        webView.getEngine().load("https://openjfx.io/");

        stage.setScene(new Scene(webView, 640, 480));

        stage.show();
    }
}
