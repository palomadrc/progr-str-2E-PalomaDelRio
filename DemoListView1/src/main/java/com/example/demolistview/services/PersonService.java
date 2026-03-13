package com.example.demolistview.services;

import com.example.demolistview.repository.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo=new PersonFileRepository();


        public List<String> loadDataListView() throws IOException {
            List<String> lines= repo.readAllLines();
            List<String> result= new ArrayList<>();

            for (String line: lines){

                if(line==null || line.isBlank()) continue;
                String[] parts = line.split(",");
                if (parts.length < 3) continue;

                String name= parts[0];
                String email= parts[1];
                int edad= Integer.parseInt(parts[2]);

                result.add("Nombre:"+name+"-"+email+"-"+edad);
            }
            return result;

        }

        public void addPerson(String name, String email, int edad) throws IOException {
            validate(name, email, edad);
            repo.appendNewLine(name+","+email+","+edad);
        }

        //aqui se va si los datos son inválidos
        private void validate(String name, String email, int edad){
            if (name==null || name.isBlank() || name.length()<3){
                throw new IllegalArgumentException("El nomre es incorrecto");
            }

            //actua como el if par que no truene
            String em= (email==null) ? "" : email.trim();
            if (em.isBlank() || !em.contains("@") || !em.contains(".")){
                throw new IllegalArgumentException("El email es incorrecto");
            }

            if (edad <= 18){
                throw new IllegalArgumentException("Edad debe ser mayor o igual a 18");
            }
        }
    }

