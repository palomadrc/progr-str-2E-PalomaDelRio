package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppControllers {

    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;


     //conersion del listado a ObservableList
    @FXML
    private ObservableList<String> data= FXCollections.observableArrayList();

    private PersonService service=  new PersonService();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,newValue) -> {
                    loadDataToForm(newValue);
                }
        );
        listView.setItems(data);
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onUpdate(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name=txtName.getText();
            String email=txtEmail.getText();
            String edadTexto=txtEdad.getText();

            int edad = Integer.parseInt(edadTexto);
            if (edad <= 18) {
                lblMsg.setText("La edad debe ser mayor a 18");
                lblMsg.setStyle("-fx-text-fill: #f5405e");
                return;
            }
            service.updatePerson(index,name,email,edad);
            lblMsg.setText("Persona Actualizada con Éxito");
            lblMsg.setStyle("-fx-text-fill: purple");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
            loadFromFile();
            }catch (NumberFormatException e){
                lblMsg.setText("Edad inválida");
                lblMsg.setStyle("-fx-text-fill: blue");
            }catch (IOException e){
                lblMsg.setText("Hubo un error con el archivo: ");
                lblMsg.setStyle("-fx-text-fill: blue");
            }catch (IllegalArgumentException e){
                lblMsg.setText("Hubo un error con los datos"+e.getMessage());
                lblMsg.setStyle("-fx-text-fill: blue");
        }

    }

    public void onDelete(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name=txtName.getText();
            String email=txtEmail.getText();
            String edadTexto=txtEdad.getText();

            int edad = Integer.parseInt(edadTexto);
            if (edad <= 18) {
                lblMsg.setText("La edad debe ser mayor a 18");
                lblMsg.setStyle("-fx-text-fill: #f5405e");
                return;
            }
            service.deletePerson(index,name,email,edad);
            lblMsg.setText("Borrado con éxtio");
            lblMsg.setStyle("-fx-text-fill: purple");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
            loadFromFile();
        }catch (NumberFormatException e){
            lblMsg.setText("Borrado con éxtio");
            lblMsg.setStyle("-fx-text-fill: blue");
        }catch (IOException e){
            lblMsg.setText("Borrado con éxtio");
            lblMsg.setStyle("-fx-text-fill: blue");
        }catch (IllegalArgumentException e){
            lblMsg.setText("Borrado con éxtio"+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: blue");
        }

    }


    @FXML
    public void onAdd(){
        try {
            String name=txtName.getText();
            String email=txtEmail.getText();
            String edadTexto=txtEdad.getText();

            int edad = Integer.parseInt(edadTexto);
            if (edad <= 18) {
                lblMsg.setText("La edad debe ser mayor a 18");
                lblMsg.setStyle("-fx-text-fill: #f5405e");
                return;
            }
            service.addPerson(name, email, edad);
            lblMsg.setText("Persona creada con éxito");
            lblMsg.setStyle("-fx-text-fill: purple");

            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();

            loadFromFile();
        }catch (NumberFormatException e){
            lblMsg.setText("Edad inválida");
            lblMsg.setStyle("-fx-text-fill: blue");
        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo: ");
            lblMsg.setStyle("-fx-text-fill: blue");
        }catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error con los datos"+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: blue");
        }

    }



    private void loadFromFile(){
        try{
            List<String> items= service.loadDataListView();
            data.setAll(items);
        }catch (IOException e){
            lblMsg.setText("Error al cargar los archivos: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
    private void loadDataToForm(String data){
        String[] parts= data.split("-");
        txtName.setText(parts[0]);
        txtEmail.setText(parts[1]);
        txtEdad.setText(parts[2]);
    }

    public TextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(TextField txtEdad) {
        this.txtEdad = txtEdad;
    }
}
