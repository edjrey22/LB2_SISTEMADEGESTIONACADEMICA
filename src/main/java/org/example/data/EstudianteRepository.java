package org.example.data;
import org.example.bussines.Estudiante;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EstudianteRepository {
    private final String archivo = "data/Estudiantes.json";
    private final Gson gson = new Gson();

    public List <Estudiante> listar(){
        try(Reader reader= new FileReader(archivo)) {
            Type tipo=new TypeToken <List <Estudiante>> (){}.getType();
            List<Estudiante> estudiantes=gson.fromJson(reader,tipo);
            return estudiantes !=null? estudiantes: new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error al leer estudiantes: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    public void guardar(List<Estudiante> estudiantes){
        try (Writer writer=new FileWriter(archivo)){
            gson.toJson(estudiantes, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar estudiantes: " + e.getMessage());
        }
    }
}
