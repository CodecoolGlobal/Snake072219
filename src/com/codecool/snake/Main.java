package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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

        int health = 100;
        Text t = new Text (900, 20, "Health: "+health);


        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        t.setFill(Color.RED);
        game.getChildren().add(t);


        game.start();

    }

    @Override
    public void stop() throws Exception {
        System.out.println("Exiting..");
    }
}