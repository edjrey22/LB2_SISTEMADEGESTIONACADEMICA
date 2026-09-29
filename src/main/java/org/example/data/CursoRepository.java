package org.example.data;
import org.example.bussines.Curso;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class CursoRepository {
    private final  String archivo = "data/Cursos.json";
    private final Gson gson = new Gson();

    public List<Curso> listar (){
        try (Reader reader = new FileReader(archivo)) {
            Type tipo = new TypeToken<List<Curso>>() {}.getType();
            List<Curso> cursos = gson.fromJson(reader, tipo);

            return cursos != null
                    ? cursos
                    : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error al leer Curso " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public  void  guardar(List<Curso> cursos){
            try (Writer writer = new FileWriter(archivo)) {
                gson.toJson(cursos, writer);
            } catch (Exception e) {
                System.out.println("Error al guardar cursos: " + e.getMessage());
            }
        }

}
