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
        
        String jsonPath = "src/onehost/estados.json";        
        Map<String, ArrayList<String>> estadosDivisas = new HashMap<>();
        
        estadosDivisas = popularLista(jsonPath);    
        
        String inputRota = "AM, PA, MA, PI, CE";
        
        ArrayList <String> rota = refatorarInput(inputRota);
        
        System.out.println(validaRota(estadosDivisas, rota));
        
    }
    public static Boolean validaRota(Map<String, ArrayList<String>> estadosDivisas, ArrayList<String> rota) {
        
        Boolean fazDivisa = false;
        for(int i =0 ; i<rota.size() ; i++)
        {
            if(i+1 < rota.size())
            {
                String estado = rota.get(i);
                ArrayList<String> divisas = estadosDivisas.get(estado);
                
                //Se for inserido um valor nao correspondente a sigla dos estados estados retorna false;
                if(divisas == null)
                {
                       return false;         
                }else
                {
                    fazDivisa = divisas.contains(rota.get(i+1));
                }
            }  
        }
        return fazDivisa;
    }

    public static Map<String, ArrayList<String>> popularLista(String path) {
         Map<String, ArrayList<String>> listaEstadosDivisas = new HashMap<>();
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
        return listaEstadosDivisas;
    }

    public static ArrayList<String> refatorarInput(String inputRota) 
    {
        String[] inputArray  =  inputRota.toUpperCase().split(",");
        for(int i = 0; i < inputArray.length; i++){
            inputArray[i]  = inputArray[i].trim();
        }
        ArrayList <String> inputRefatorado = new ArrayList<String>(Arrays.asList(inputArray));
        
        return inputRefatorado;
    }
}
