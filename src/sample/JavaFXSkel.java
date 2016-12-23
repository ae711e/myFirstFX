/*
 ���� �� ������������� Java FX (����������� ���������)
 �� ����� ������� �����. Java 8 ����������� ��� ���������� 2015.pdf ����� 17
 
 ��������� ���������� �� ���. 617
 */

package sample;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class JavaFXSkel extends Application {
  
  Label responce;
  
  @Override
  public void start(Stage myStage) throws Exception
  {
    System.out.println("B ���� ������ start()");
    
    //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    myStage.setTitle("������ ���������� FX");
    // ������� �������� ����
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    // ������� �����
    responce = new Label("��������� �� ��");
        
    Scene myScene = new Scene(rootNode, 300,200);
    
    // ���������� ����� �� ���������
    myStage.setScene(myScene);
    
    ////primaryStage.setScene(new Scene(root, 300, 275));
    ////primaryStage.show();
    // ������� �����
    Label myLabel= new Label("����� �� ������");
    
    // �������� 2 ������
    Button btnUp = new Button("Up ������");
    Button btnDo = new Button("Down ������");
    
    // ������� ���������� ������� ������
    btnUp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent ae) {
        responce.setText("�� ������ Up");
      }
    });
    
    // ��������� ������� ������ Down (���������� lamba-���������)
    btnDo.setOnAction( (ae) -> {  responce.setText("�� ������ Down"); } );
      
    rootNode.getChildren().add(myLabel);
    
    rootNode.getChildren().addAll(btnUp, btnDo, responce);
    
    // ���������� ����� � ���������
    myStage.show();
  
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
