/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.onehost.onehostmaven;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lucas
 */
public class OneHostTest {

    private ArrayList<String> rotasValidas;
    private ArrayList<String> rotasInvalidas;
    private String jsonPath = "src/main/resources/estados.json";

    @Test
    @DisplayName("Validacao de rotas VALIDAS")
    public void testRotasValidas() {

        rotasValidas = new ArrayList<String>();
        Divisas divisas = new Divisas();
        Rota rota = new Rota();
        boolean invalidas = true;

        //Definição das rotas a serem testadas
        rotasValidas.add("RS");
        rotasValidas.add("RS, SC");
        rotasValidas.add("AM,PA,MA,PI,CE,RN");
        rotasValidas.add("MG,GO,DF,GO,TO");
        rotasValidas.add("pa, mt, MS, SP, MG, ba, to, pa");

        //Itera sobre as rotas fornecdias
        for(int i = 0; i < rotasValidas.size() ; i++)
        {
            divisas.setEstadosDivisasFromJsonPath(jsonPath);
            rota.setRota(rotasValidas.get(i));

            //Se alguma rota for invalidada, retornara falso
            if(!rota.validarRota(divisas.getEstadosDivisas()))
            {
                invalidas=false;
                System.err.println("Validacao de rotas VALIDAS falhou: " + rotasValidas.get(i));
                break;
            }
        }
        assertTrue(invalidas);
    }

    @Test
    @DisplayName("Validacao de rotas INVALIDAS")
    public void testRotasInvalidas() {

        rotasInvalidas = new ArrayList<String>();
        Divisas divisas = new Divisas();
        Rota rota = new Rota();
        boolean invalidas = true;

        //Definição das rotas a serem testadas
        rotasInvalidas.add("123");
        rotasInvalidas.add("  ,");
        rotasInvalidas.add("ES,MG,GO,PA,AM");
        rotasInvalidas.add("RS, TO, ");
        rotasInvalidas.add("   ,RS, SC");

            //Itera sobre as rotas fornecdias
            for(int i = 0; i < rotasInvalidas.size() ; i++)
            {
                divisas.setEstadosDivisasFromJsonPath(jsonPath);
                rota.setRota(rotasInvalidas.get(i));

                //Se alguma rota for validada, retornara falso
                if(rota.validarRota(divisas.getEstadosDivisas()))
                {
                    invalidas=false;
                    System.err.println("Validacao de rotas invalidas falhou: " + rotasInvalidas.get(i));
                    break;
                }
            }

        assertTrue(invalidas);
    }
}
