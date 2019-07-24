package com.codecool.snake;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        Scene mainScene = new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        mainScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        int actualHealth = Globals.getInstance().snake.getHealth();
        Text t = new Text(750, 40, String.format("Health: %d", actualHealth));
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        t.setFill(Color.MEDIUMPURPLE);
        t.setFontSmoothingType(FontSmoothingType.LCD);
        t.setEffect(ds);
        t.setCache(true);
        t.setFont(Font.font(null, FontWeight.BOLD, 32));

        game.getChildren().add(t);
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        game.start();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Exiting..");
    }
}
