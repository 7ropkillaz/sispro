package sample;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {
    public void update(ActionEvent actionEvent) {
    }

    public void open(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Open Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        //File file = fileChooser.showOpenDialog(CodeNote.mainStage);//Указываем текущую сцену CodeNote.mainStage
        //if (file != null) {
            //Open
         //   System.out.println("Процесс открытия файла");
      //  }
    }

    public void create(ActionEvent actionEvent) {
    }

    public void save(ActionEvent actionEvent) {
    }

    public void saveAs(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {

    }

    public void addLine(ActionEvent actionEvent) {
    }

    public void editTable(ActionEvent actionEvent) {
    }

    public void about(ActionEvent actionEvent) {
    }

    public void help(ActionEvent actionEvent) {
    }
}
