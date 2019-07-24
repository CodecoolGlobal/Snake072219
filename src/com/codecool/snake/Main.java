package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
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

        /*int actualHealth = Globals.getInstance().snake.getHealth();
        int actualHealth2 = Globals.getInstance().snake2.getHealth();
        Text t = new Text(750, 40, String.format("Health: %d", actualHealth));
        Text t2 = new Text(50,40,String.format("Health: %d", actualHealth2));
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        t.setFill(Color.DARKRED);
        t.setFontSmoothingType(FontSmoothingType.LCD);
        t.setEffect(ds);
        t.setCache(true);
        t.setFont(Font.font(null, FontWeight.BOLD, 32));

        t2.setFill(Color.RED);
        t2.setFontSmoothingType(FontSmoothingType.LCD);
        t2.setEffect(ds);
        t2.setCache(true);
        t2.setFont(Font.font(null, FontWeight.BOLD, 32));

        game.getChildren().add(t);
        game.getChildren().add(t2);*/

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
