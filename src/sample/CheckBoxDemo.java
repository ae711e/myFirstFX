/*
 Опыт по использованию Java FX (графический интерфейс)
 по книге Герберт Шилдт. Java 8 Руководство для начинающих 2015.pdf Глава 17
 
 Выполняем Упражнение на стр. 624 3 состояние флажка
 */

package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application {
  
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
    myStage.setTitle("Demo CheckBox");
    // создать корневой узел
    FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
    rootNode.setAlignment(Pos.TOP_LEFT);
    // создать сцену
    responce = new Label("нажимание на на");
        
    Scene myScene = new Scene(rootNode, 300,200);
    
    // установить сцену на плтаформе
    myStage.setScene(myScene);
    
    // Создать метку
    Label heading= new Label("What Computers Do You Own?");
    
    // создать метку, извещающую об изменении состояния флажка
    responce = new Label("r");
    
    // создать метку, извещвющую о выборе любого флажка
    selected = new Label("s");
    
    // создать флажки
    cbSmartphone=new CheckBox("Smartphone");
    cbTablet = new CheckBox("Tablet");
    cbNotebook = new CheckBox("Notebook");
    cbDesktop = new CheckBox("Desktop");
    
    // обработка событий действий для флажков
    cbSmartphone.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String r="cleared";
        if(cbSmartphone.isSelected())   r="SELECTED";
        if(cbSmartphone.isIndeterminate()) r="indeterminate";
        responce.setText("Smartphone was just "+r);
        showAll();
      }
    });
    
    cbTablet.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String r="cleared";
        if(cbTablet.isSelected()) r="SELECTED";
        responce.setText("Tablet was just "+r);
        showAll();
      }
    });
  
    cbNotebook.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String r="cleared";
        if(cbNotebook.isSelected()) r="SELECTED";
        responce.setText("Notebook was just "+r);
        showAll();
      }
    });
  
    cbDesktop.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String r="cleared";
        if(cbDesktop.isSelected()) r="SELECTED";
        responce.setText("Desktop was just "+r);
        showAll();
      }
    });
    
    // 3 состояние флажка - разрешим
    cbSmartphone.setAllowIndeterminate(true);
    
    rootNode.getChildren().add(heading);
    
    rootNode.getChildren().addAll(cbSmartphone, cbTablet, cbNotebook, cbDesktop);
  
    rootNode.getChildren().addAll(responce, selected);
  
    // отобразить сцену и платформу
    myStage.show();
    
    showAll();
  
  }
  
  // Обновить и отобразить варианты выбора
  protected void showAll()
  {
    computers = "";
    if(cbSmartphone.isSelected()) computers += " Smartphone";
    if(cbTablet.isSelected()) computers += " Tablet";
    if(cbNotebook.isSelected()) computers += " Notebooke";
    if(cbDesktop.isSelected()) computers += " Desktop";
    selected.setText("Computers selected:" + computers);
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
