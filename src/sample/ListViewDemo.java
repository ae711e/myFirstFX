/*
 Опыт по использованию Java FX (графический интерфейс)
 по книге Герберт Шилдт. Java 8 Руководство для начинающих 2015.pdf Глава 17
 
 Выполняем Упражнение на стр. 627 ListView
 */

package sample;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.Observable;

public class ListViewDemo extends Application {
  
  CheckBox cbSmartphone;
  CheckBox cbTablet;
  CheckBox cbNotebook;
  CheckBox cbDesktop;
  
  Label responce;
  Label selected;
  
  String computers;
  
  @Override
  public void start(Stage myStage) throws Exception
  {
    System.out.println("in start()");
    
    //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    myStage.setTitle("Demo ListView");
    // создать корневой узел
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    // создать сцену
    responce = new Label("нажимание на на");
        
    Scene myScene = new Scene(rootNode, 300,200);
    
    // установить сцену на плтаформе
    myStage.setScene(myScene);
    
    // создать метку, извещающую об изменении состояния флажка
    responce = new Label("Select computer type");
    
    // создать объект типа ObservableList
    ObservableList<String> computerTypes= FXCollections.observableArrayList(
        "Smartphone", "Tablet", "Notebook", "Desktop"
    );
    
    // создать список
    ListView<String> lvComputers = new ListView<String>(computerTypes);
    
    // задать предпочтительные размеры
    lvComputers.setPrefSize(100, 70);
    
    // получить модель выбора списка
    MultipleSelectionModel<String> lvSelModel = lvComputers.getSelectionModel();
    
    // использовать слушатель
    lvSelModel.selectedItemProperty().addListener(
        new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            responce.setText("Computer selected is "+ newValue);
          }
        }
    );
        
    rootNode.getChildren().addAll(lvComputers);
  
    rootNode.getChildren().addAll(responce);
  
    // отобразить сцену и платформу
    myStage.show();
    
  }
  
  
  
  public static void main(String[] args)
  {
    System.out.println("startup application");
    launch(args);
  }
  
  @Override
  public void init() throws Exception {
    System.out.println("in init()");
    super.init();
  }
  
  @Override
  public void stop() throws Exception {
    System.out.println("in stop()");
    super.stop();
  }
}
