package com.weiwei.todolist;

import com.weiwei.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Todo List");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

//    Override the stop method to store the data
    @Override
    public void stop() throws Exception {
        try {
            TodoData.getInstance().storeTodoItems();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
//  Override init() method to load the data from the txt file.
    @Override
    public void init() throws Exception {
        try {
            TodoData.getInstance().loadTodoItem();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
