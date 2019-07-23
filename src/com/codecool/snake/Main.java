package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.text.BreakIterator;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        Scene mainScene = new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        Text t = new Text (10, 20, "This is a text sample");
        t.setId("fancytext");


        game.start();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Exiting..");
    }
}
