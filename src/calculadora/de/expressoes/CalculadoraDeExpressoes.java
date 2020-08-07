/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.de.expressoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Romicasa
 */
public class CalculadoraDeExpressoes {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {        
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));            
                
                System.out.print("Digite uma expressão: ");
                ExpressionHandler.handler(reader.readLine());
                
                System.out.println("O RESULTADO DA SUA EXPRESSAO: " + ExpressionHandler.result());                
            }catch(Exception ex)
                {
                    System.err.println("EXPRESSÃO MAL FORMULADA: " + ex.getMessage());
                }
    }
    
}
