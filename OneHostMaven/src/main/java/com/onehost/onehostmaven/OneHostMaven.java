/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.onehost.onehostmaven;

import javax.swing.*;

/**
 *
 * @author Lucas
 */
public class OneHostMaven {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Divisas divisas = new Divisas();
        Rota rota = new Rota();
        String jsonPath = "src/main/resources/estados.json";

        String input = javax.swing.JOptionPane.showInputDialog("Informe a rota a ser verificada", "");

        if(input != null)
        {
            divisas.setEstadosDivisasFromJsonPath(jsonPath);
            rota.setRota(input);

            if(rota.validarRota(divisas.getEstadosDivisas()))
            {
                JOptionPane.showMessageDialog(null, "A rota "+ rota.getRota().toString().replace("[", "").replace("]", "") +" é valida", "Validado", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "A rota "+ rota.getRota().toString().replace("[", "").replace("]", "") +" é invalida", "Invalido", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            System.exit(0);
        }

    }
}
