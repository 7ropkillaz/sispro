package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Work with file");
        primaryStage.setScene(new Scene(root, 585, 432));
        ObservableList<Node> list =root.getChildrenUnmodifiable();
        Pane node =(Pane)list.get(0);
      //  Platform.exit();

        ObservableList<Node> list2=node.getChildren();
        MenuBar menu =(MenuBar)list2.get(1);
        ObservableList<Menu> menuse = menu.getMenus();
        Menu m= menuse.get(0);
        Menu n=menuse.get(2);
        final FileChooser fileChooser = new FileChooser();
        ObservableList<MenuItem> item = m.getItems();
        ObservableList<MenuItem> item1=n.getItems();
        item.get(0).setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        configureFileChooser(fileChooser);
                        File file = fileChooser.showOpenDialog(primaryStage);
                        if (file != null) {
                            openFile(file);
                        }

                    }
                });
        item.get(3).setOnAction(
                new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(final ActionEvent e){
                    configureFileChooser(fileChooser);
                    File file = fileChooser.showSaveDialog(primaryStage);
                    if (file != null) {
                        saveFile(file);
                    }
                }}
                );
        item.get(4).setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Platform.exit();
                        System.exit(0);
                    }
                }
        );
        item1.get(0).setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Label lbl = new Label("О разработчике: Кусаинов Д.М., Маркелов А.В. \n vk.com ");

                        FlowPane secondaryLayout = new FlowPane();

                        secondaryLayout.getChildren().add(lbl);

                        Scene secondScene = new Scene(secondaryLayout, 290, 100);


                        Stage newWindow = new Stage();
                        newWindow.setTitle("About");
                        newWindow.setScene(secondScene);


                        newWindow.initModality(Modality.WINDOW_MODAL);
                        newWindow.initOwner(primaryStage);
                        newWindow.setX(primaryStage.getX() + 200);
                        newWindow.setY(primaryStage.getY() + 100);

                        newWindow.show();
                        newWindow.setResizable(false);
                    }
                }
        );




        node.getAccessibleHelp();
        primaryStage.show();



    }
    @Override
    public void stop(){
        // todo Сделать развилку для проверки изменения и последующего сохранения файла

    }
    private static void configureFileChooser(final FileChooser fileChooser){
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    Main.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }
    private void saveFile(File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.close();
        } catch (FileNotFoundException e){}
    }
    private void createFile(){

    }


    public static void main(String[] args) {
        launch(args);
    }
}

// ВАЙЛ АСМ ФАЙЛ