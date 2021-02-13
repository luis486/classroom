package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import model.*;

public class Main extends Application{

    public Classroom classRoom;
    public ClassroomGUI classRoomGUI;

    public Main(){
        classRoom = new Classroom();
        classRoomGUI = new ClassroomGUI(classRoom);
    }
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
    	FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
        fxmlloader.setController(classRoomGUI);
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        this.classRoomGUI.showLogIn();
    }

}


