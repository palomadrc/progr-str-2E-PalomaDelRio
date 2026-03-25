package com.example.practicaexamen.services;

import com.example.practicaexamen.contactos.Contacto;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contacto> listContactos = new ArrayList<>();

    public List<Contacto> getAllContacts() {
        return listContactos;
    }

    public void addContact(Contacto contacto) {
        listContactos.add(contacto);
    }

    public Contacto findByName(String name) {
        return listContactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public void removeContact(Contacto contacto) {
        listContactos.remove(contacto);
    }
}

