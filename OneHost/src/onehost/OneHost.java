/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onehost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class OneHost {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Divisas divisas = new Divisas();
        Rota rota = new Rota();
        
        String input = "RS, SC, SP";
        String jsonPath = "src/onehost/estados.json";
        
        divisas.setEstadosDivisasFromJsonPath(jsonPath);
        rota.setRota(input);
        
        System.out.println(rota.validarRota(divisas.getEstadosDivisas()));
        
    }
}
