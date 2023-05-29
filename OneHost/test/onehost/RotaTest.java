/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package onehost;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lucas
 */
public class RotaTest {
    
    public RotaTest() {
    }

    @Test
    public void testSetRota() {
        Rota testRota = new Rota();
        boolean result = testRota.setRota("RS, SC, PR, RJ");
        assertTrue(result);
    }

    @Test
    public void testValidarRota() {
        Rota testRota = new Rota();
        Divisas testDivisas = new Divisas();
        
        String testInput = "RS, SC, PR, RJ";
        testRota.setRota(testInput);
        
        String path = "src/onehost/estados.json";
        testDivisas.setEstadosDivisasFromJsonPath(path);
        
        boolean result = testRota.validarRota(testDivisas.getEstadosDivisas());
        assertTrue(result);
    }
    
}
