package com.example.loginjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    public void onLogin(ActionEvent event){

        String correo = txtCorreo.getText() == null ? "" : txtCorreo.getText();
        String password = txtPassword.getText() == null ? "" : txtPassword.getText();

        List<String> errores = new ArrayList<>();

        if(correo.length() < 4){
            errores.add("Usuario mínimo 4 caracteres\n");
        }

        if(!correo.contains("@") || !correo.contains(".")){
            errores.add("Correo inválido\n");
        }

        if(password.length() < 6){
            errores.add("Password mínimo 6 caracteres\n");
        }

        if(errores.isEmpty()){

            try {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/views/dashboard.fxml")
                );

                Scene scene = new Scene(loader.load());

                DashboardController controller = loader.getController();
                controller.setUsuario(correo);

                Stage stage = (Stage) txtCorreo.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            lblError.setText(String.join("", errores));
            lblError.setStyle("-fx-text-fill: red;");
        }
    }
}