/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onehost;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Lucas
 */
public class Divisas {
    
    Map<String, ArrayList<String>> listaEstadosDivisas = new HashMap<>();

    public Map<String, ArrayList<String>> getEstadosDivisas() {
        return listaEstadosDivisas;
    }
    
    public void setEstadosDivisasFromJsonPath(String path)
    {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray estadosArray = (JSONArray) jsonObject.get("estados");

            for (Object estadoObj : estadosArray) {
                JSONObject estado = (JSONObject) estadoObj;
                String siglaEstado = (String) estado.get("sigla");
                JSONArray divisasArray = (JSONArray) estado.get("divisas");
                listaEstadosDivisas.put(siglaEstado, divisasArray);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    
}
