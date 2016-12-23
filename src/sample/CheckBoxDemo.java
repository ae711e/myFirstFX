/*
 ���� �� ������������� Java FX (����������� ���������)
 �� ����� ������� �����. Java 8 ����������� ��� ���������� 2015.pdf ����� 17
 
 ��������� ���������� �� ���. 621
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
    System.out.println("B ���� ������ start()");
    
    //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    myStage.setTitle("������������� CheckBox");
    // ������� �������� ����
    FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
    rootNode.setAlignment(Pos.TOP_LEFT);
    // ������� �����
    responce = new Label("��������� �� ��");
        
    Scene myScene = new Scene(rootNode, 300,200);
    
    // ���������� ����� �� ���������
    myStage.setScene(myScene);
    
    // ������� �����
    Label heading= new Label("What Computers Do You Own?");
    
    // ������� �����, ���������� �� ��������� ��������� ������
    responce = new Label("r");
    
    // ������� �����, ���������� � ������ ������ ������
    selected = new Label("s");
    
    // ������� ������
    cbSmartphone=new CheckBox("Smartphone");
    cbTablet = new CheckBox("Tablet");
    cbNotebook = new CheckBox("Notebook");
    cbDesktop = new CheckBox("Desktop");
    
    // ��������� ������� �������� ��� �������
    cbSmartphone.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String r="cleared";
        if(cbSmartphone.isSelected())
          r="SELECTED";
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
    
    rootNode.getChildren().add(heading);
    
    rootNode.getChildren().addAll(cbSmartphone, cbTablet, cbNotebook, cbDesktop);
  
    rootNode.getChildren().addAll(responce, selected);
  
    // ���������� ����� � ���������
    myStage.show();
    
    showAll();
  
  }
  
  // �������� � ���������� �������� ������
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
    System.out.println("�a�yc� ���������� JavaFX");
    launch(args);
  }
  
  @Override
  public void init() throws Exception {
    System.out.println("B ���� ������ init()");
    super.init();
  }
  
  @Override
  public void stop() throws Exception {
    System.out.println("B ���� ������ stop");
    super.stop();
  }
}
