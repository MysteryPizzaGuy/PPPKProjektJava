import Database.Database;
import Database.DatabaseFactory;
import Model.Vozac;
import Model.Vozilo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.plugin2.message.Message;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    private List<Vozac> Vozaci = new ArrayList<>();
    private List<Vozilo> Vozila = new ArrayList<>();
    @FXML
    private GridPane gridPane;
    @FXML
    private Button btnChooseVozaci;
    @FXML
    private TextFlow txtAConsole;
    @FXML
    private Button btnLoadSQL;
    @FXML
    private Button btnClearVozilaChoice;
    @FXML
    private Button btnClearVozaciChoice;
    @FXML
    private Button btnChooseVozila;
    @FXML
    private Button btnImportVozaci;
    @FXML
    private Button btnImportVozila;




    @FXML
    protected void initialize() {

    }

//    @FXML
//    protected void onClickbtnLoadSQL(ActionEvent action) {
////        IVozacRepo repo = new VozacRepo();
////        List<Vozac> vozaci = repo.FindAll();
////        for (Vozac vozac : vozaci) {
////            txtACheck.appendText(vozac.toString());
////
////        }
//    }
//    @FXML
//    protected void onClickbtnImportVozaci(ActionEvent action){
//        if (selectedFileVozaci != null) {
//            Vozaci.clear();
//            try (BufferedReader br = new BufferedReader(new FileReader(selectedFileVozaci))) {
//
//                String line;
//                while ((line = br.readLine()) != null) {
//
//                    // use comma as separator
//                    String[] lines = line.split(",");
//                    Vozac temp = new Vozac();
//                    temp.setIme(lines[0]);
//                    temp.setPrezime(lines[1]);
//                    temp.setBrojMobitela(lines[2]);
//                    temp.setSerijskiBrojVozacke(lines[3]);
//                    Vozaci.add(temp);
//                }
//
//            AppendToConsole();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    @FXML
    protected void onClickbtnChooseVozaci(ActionEvent action) throws IOException {
//        IME,Prezime,BrojMobitela,SerijskiBrojVozacke
        Stage mainStage = (Stage) btnChooseVozaci.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV File", "*.csv"));
        File selectedFileVozaci = fileChooser.showOpenDialog(mainStage);
        if (selectedFileVozaci != null) {
            Vozaci.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFileVozaci))) {

                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] lines = line.split(",");
                    Vozac temp = new Vozac();
                    temp.setIme(lines[0]);
                    temp.setPrezime(lines[1]);
                    temp.setBrojMobitela(lines[2]);
                    temp.setSerijskiBrojVozacke(lines[3]);
                    Vozaci.add(temp);
                }
                AppendToConsole("File -> " +selectedFileVozaci.toString() +" staged SUCCESSFULLY",MessageType.SUCCESS);
            } catch (IOException e) {
                AppendToConsole("ERROR TRYING TO STAGE FILE -> "+selectedFileVozaci.toString(),MessageType.ALERT);
            }
        }else{
            AppendToConsole("No File Staged",MessageType.INFORMATION);
        }

    }
    @FXML
    private void onClickbtnClearVozila(ActionEvent action){
        if (Vozila.size()>0) {
            Vozila.clear();
            AppendToConsole("Vozila Unstaged",MessageType.SUCCESS);
        }else{
            AppendToConsole("No Vozila Staged",MessageType.INFORMATION);
        }

    }
    @FXML
    private void onClickbtnClearVozaci(ActionEvent action){
        if (Vozaci.size()>0) {
            Vozaci.clear();
            AppendToConsole("Vozaci Unstaged",MessageType.SUCCESS);
        }else{
            AppendToConsole("No Vozaci Staged",MessageType.INFORMATION);
        }

    }

    @FXML
    private void onClickImportVozaci(ActionEvent action){
        if (Vozaci.size()>0){
            PreparedStatement statement = null;
            IVozacRepo repo = new VozacRepo();
            try {
                if(repo.Create(Vozaci)){
                    AppendToConsole("SUCCESSFUL IMPORT",MessageType.SUCCESS);
                }else{
                    AppendToConsole("IMPORT CHECK FAILED, DATA IN DATABASE DOESN'T MATCH RECORDED INPUT DATA",MessageType.ALERT);
                }
            } catch (SQLException e) {
                AppendToConsole("SQL ERROR"+ e.getMessage(),MessageType.ALERT);
            }
        }
    }
    @FXML
    private void onClickImportVozila(ActionEvent action){
        if (Vozila.size()>0){
            PreparedStatement statement = null;
            IVoziloRepo repo = new VoziloRepo();
            try {
                if(repo.Create(Vozila)){
                    AppendToConsole("SUCCESSFUL IMPORT",MessageType.SUCCESS);
                }else{
                    AppendToConsole("IMPORT CHECK FAILED, DATA IN DATABASE DOESN'T MATCH RECORDED INPUT DATA",MessageType.ALERT);
                }
            } catch (SQLException e) {
                AppendToConsole("SQL ERROR"+ e.getMessage(),MessageType.ALERT);
            }
        }
    }

    @FXML
    private void onClickbtnChooseVozila(ActionEvent action){
//        IME,Prezime,BrojMobitela,SerijskiBrojVozacke
        Stage mainStage = (Stage) btnChooseVozaci.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV File", "*.csv"));
        File selectedFileVozila = fileChooser.showOpenDialog(mainStage);
        if (selectedFileVozila != null) {
            Vozaci.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFileVozila))) {
                br.readLine();

                String line;
                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] lines = line.split(",");
                    Vozilo temp = new Vozilo();
                    temp.setTip(lines[0]);
                    temp.setMarka(lines[1]);
                    temp.setGodinaProizvodnje(new SimpleDateFormat("dd/MM/yyyy").parse(lines[2]));
                    temp.setInicijalKM(Integer.parseInt(lines[3]));
                    Vozila.add(temp);
                }

                AppendToConsole("File -> " +selectedFileVozila.toString() +" staged SUCCESSFULLY",MessageType.SUCCESS);
            } catch (IOException | ParseException e) {
                AppendToConsole("ERROR TRYING TO STAGE FILE -> "+selectedFileVozila.toString(),MessageType.ALERT);
            }
        }else{
            AppendToConsole("No File Staged",MessageType.INFORMATION);
        }
    }

    private void AppendToConsole(String text, MessageType imp) {
        Text t1 = new Text();
        switch (imp) {
            case ALERT:
                t1.setFill(Color.RED);
                break;
            case INFORMATION:
                t1.setFill(Color.DARKGOLDENROD);
                break;
            case NEUTRAL:
                t1.setFill(Color.BLACK);
                break;
            case SUCCESS:
                t1.setFill(Color.GREEN);
                break;


        }
        t1.setText(text + '\n');
        txtAConsole.getChildren().add(t1);
    }

    enum MessageType {ALERT, INFORMATION, SUCCESS,NEUTRAL}

    ;

}
