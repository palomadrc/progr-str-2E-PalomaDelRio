package com.example.practicaexamen.controllers;

import com.example.practicaexamen.contactos.Contacto;
import com.example.practicaexamen.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppControllers {

    private String[] arrParentescos = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};

    private ContactService service = new ContactService();

    @FXML private ComboBox<String> cdParentescos;
    @FXML private TextField txtName;
    @FXML private TextField txtTel;
    @FXML private ListView<Contacto> listViewContacts;

    private ObservableList<Contacto> obsContacts = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cdParentescos.setItems(FXCollections.observableArrayList(arrParentescos));
        listViewContacts.setItems(obsContacts);
    }

    @FXML
    public void onAddContact() {
        String name = txtName.getText().trim();
        String tel = txtTel.getText().trim();
        String parent = cdParentescos.getValue();

        if (!name.isEmpty() && tel.length() == 10 && parent != null) {
            Contacto nuevo = new Contacto(name, tel, parent);
            service.addContact(nuevo);
            onRefresh();
            onClear();
        }
    }

    @FXML
    public void onSearch() {
        Contacto c = listViewContacts.getSelectionModel().getSelectedItem();
        if (c != null) {
            txtName.setText(c.getNombre());
            txtTel.setText(c.getTelefono());
            cdParentescos.setValue(c.getParentesco());
        }
    }

    @FXML
    public void onDelete() {
        Contacto c = listViewContacts.getSelectionModel().getSelectedItem();

        if (c == null) {
            System.out.println("NO HAY SELECCION");
        } else {
            System.out.println("BORRANDO: " + c);
            service.removeContact(c);
            onRefresh();
            onClear();
        }
    }

    @FXML
    public void onClear() {
        txtName.clear();
        txtTel.clear();
        cdParentescos.getSelectionModel().clearSelection();
    }

    @FXML
    public void onUpdate() {
        Contacto seleccionado = listViewContacts.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            seleccionado.setNombre(txtName.getText());
            seleccionado.setTelefono(txtTel.getText());
            seleccionado.setParentesco(cdParentescos.getValue());

            onRefresh();
            onClear();
        }
    }

    @FXML
    private void onRefresh() {
        obsContacts.setAll(service.getAllContacts());
    }
}
