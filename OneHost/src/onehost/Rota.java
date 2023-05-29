/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onehost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class Rota {
    
    ArrayList<String> rota;
    boolean rotaValida;

    public boolean isRotaValida() {
        return rotaValida;
    }

    public ArrayList<String> getRota() {
        return rota;
    }

    public void setRota(ArrayList<String> rota) {
        this.rota = rota;
    }
    
    public void setRota(String inputRota)
    {
        String[] inputArray  =  inputRota.toUpperCase().split(",");
        for(int i = 0; i < inputArray.length; i++){
            inputArray[i]  = inputArray[i].trim();
        }
        this.rota = new ArrayList<String>(Arrays.asList(inputArray));
    }
    
    public boolean validarRota(Map<String, ArrayList<String>> estadosDivisas)
    {
        rotaValida = true;
        
        for(int i =0 ; i<this.rota.size() ; i++)
        {
            //Valida a divisa com o estado seguinte; 
            if(i+1 < this.rota.size())
            {
                String estado = this.rota.get(i);
                ArrayList<String> divisas = estadosDivisas.get(estado);

                //Se for inserido um valor nao correspondente a sigla dos estados estados retorna false;
                if(divisas == null)
                {
                    return false;         
                }else if(!divisas.contains(this.rota.get(i+1))){
                    rotaValida=false;
                    return false;
                }
            }  
            
        }
        return rotaValida;
    }
}
