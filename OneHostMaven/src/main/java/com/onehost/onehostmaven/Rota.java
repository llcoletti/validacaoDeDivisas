/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onehost.onehostmaven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class Rota {
    
    ArrayList<String> rota;

    public ArrayList<String> getRota() {
        return rota;
    }
    
    public boolean setRota(String inputRota)
    {
        try{
            String[] inputArray  =  inputRota.toUpperCase().split(",");
            for(int i = 0; i < inputArray.length; i++){
                inputArray[i]  = inputArray[i].trim();
            }
            this.rota = new ArrayList<String>(Arrays.asList(inputArray));
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean validarRota(Map<String, ArrayList<String>> estadosDivisas)
    {
        String estadoAtual;
        ArrayList<String> divisas;
        String proximoEstado;

        //Caso a rota seja composta por apenas um estado, testará se é um estado válido;
        if(rota.size() == 1)
        {
            try{
                estadoAtual = rota.get(0);
                if(estadosDivisas.get(estadoAtual) != null)
                {
                    return true;
                }else{
                    return false;
                }

            }catch(Exception e)
            {
                return false;
            }
        }

        //Se a rota possuir mais de um estado, iterará sobre os valores informados
        for(int i = 0; i < rota.size() ;i++)
        {

            estadoAtual = rota.get(i);
            divisas = estadosDivisas.get(estadoAtual);


            //Valida se o estado existe e se possui divisas
            if(divisas == null)
            {
                return false;
            }

            //Não buscara pelo proximo estado caso seja o ultimo estado;
            if(i+1 < rota.size())
            {
                proximoEstado = rota.get(i+1);

                //Verifica se o proximo estado faz divisa com o estado atual;
                if(!divisas.contains(proximoEstado))
                {
                    return false;
                }
            }
        }
        return true;

    }
}
