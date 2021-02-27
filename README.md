A sample Java program. Intended to test `oraclejdk` Nix package 

-It shows AWT, Swing, and JavaFX windows. Clicking a button on the JavaFX window plays a video. The video file is not included. `BigBuckBunny_320x180.mp4` should be downloaded from https://peach.blender.org/download/.

How to build:

```
javac --module-path path/to/javafx-sdk/lib/ --add-modules javafx.graphics,javafx.controls,javafx.media,javafx.web JavaSample.java
```

How to run:

```
java --module-path path/to/javafx-sdk/lib/ --add-modules javafx.graphics,javafx.controls,javafx.media,javafx.web JavaSample
```
