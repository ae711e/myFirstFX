/*
 Опыт по использованию Java FX (графический интерфейс)
 по книге Герберт Шилдт. Java 8 Руководство для начинающих 2015.pdf Глава 17
 
 Выполняем Упражнение на стр. 617
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
    System.out.println("B теле метода start()");
    
    //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    myStage.setTitle("Каркас приложения FX");
    // создать корневой узел
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    // создать сцену
    responce = new Label("нажимание на на");
        
    Scene myScene = new Scene(rootNode, 300,200);
    
    // установить сцену на плтаформе
    myStage.setScene(myScene);
    
    ////primaryStage.setScene(new Scene(root, 300, 275));
    ////primaryStage.show();
    // Создать метку
    Label myLabel= new Label("Нажми на кнопку");
    
    // создадим 2 кнопти
    Button btnUp = new Button("Up кнопка");
    Button btnDo = new Button("Down кнопка");
    
    // создать обработчик событий кнопки
    btnUp.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent ae) {
        responce.setText("Вы нажали Up");
      }
    });
    
    // обработка событий кнопки Down (используем lamba-выражение)
    btnDo.setOnAction( (ae) -> {  responce.setText("Вы нажали Down"); } );
      
    rootNode.getChildren().add(myLabel);
    
    rootNode.getChildren().addAll(btnUp, btnDo, responce);
    
    // отобразить сцену и платформу
    myStage.show();
  
  }
  
  
  public static void main(String[] args)
  {
    System.out.println("Зaпycк приложения JavaFX");
    launch(args);
  }
  
  @Override
  public void init() throws Exception {
    System.out.println("B теле метода init()");
    super.init();
  }
  
  @Override
  public void stop() throws Exception {
    System.out.println("B теле метода stop");
    super.stop();
  }
}
