/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.de.expressoes;

import java.util.StringTokenizer;



// Resolução da equação

public class ExpressionHandler {    
   private static ExitFile extFile = new ExitFile();
   private static OperationPile opPile = new OperationPile();
   private static ResultPile rPile = new ResultPile();
   private static double v1,v2,resultado;
   private static char op;  
         
   public static void handler(String exp) throws Exception{
        StringTokenizer str = new StringTokenizer(exp.replace(" ", ""),"(^*/+-)", true);                
            while(str.hasMoreTokens()){
                
                String s = str.nextToken();          
                    if(isNumber(s))
                        extFile.adicionar(s);                
                    else if(isOperator(s))
                        addOperator(s);
                    else
                        throw new Exception("Caracteres inválidos");
            }            
            
            while(!opPile.isVazia()){
                    String valor = opPile.getValor();
                    opPile.retirar();
                    extFile.adicionar(valor);                                    
                }

            while(!extFile.isVazia()){
                String valor = extFile.getValor();
                extFile.retirar();

                if(isNumber(valor))
                    rPile.adicionar(Double.parseDouble(valor));
                if(isOperator(valor)){
                    op = valor.charAt(0);
                    if(!rPile.isVazia()){
                        v2 = rPile.getValor();
                        rPile.retirar();
                    }
                    else throw new Exception("revise sua expressao");
                    
                    if(!rPile.isVazia()){
                        v1 = rPile.getValor();
                        rPile.retirar();
                    }
                    else throw new Exception("revise sua expressao");

                if(op == '+'){
                    resultado = v1+v2;
                    rPile.adicionar(resultado);
                } 
                if(op == '-'){
                    resultado = v1-v2;
                    rPile.adicionar(resultado);
                }
                if(op == '*'){
                    resultado = v1*v2;
                    rPile.adicionar(resultado);
                }
                if(op == '/'){
                    if(v2 != 0){
                        resultado = v1/v2;
                        rPile.adicionar(resultado);
                    }
                    else 
                        throw new Exception("Denominador da divisão invalido");
                }
                if(op == '^'){
                    resultado = Math.pow(v1,v2);
                    rPile.adicionar(resultado);
                }
            }
        }            
    }
    
    private static boolean isNumber(String valor){
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException nfex) {                        
            return false;
        }
    }
    private static boolean isOperator(String valor){
        
        String operadores = "/*-+^()";        

        for(int x = 0; x < operadores.length(); x++)
            if(valor.charAt(0) == operadores.charAt(x))
                return true;        
        return false;     
    }

    private static void addOperator(String operator) throws Exception{        
            boolean passou = false;
            while((opPile.ultimo != -1) && (Tabela.isParaDesempilhar(opPile.getValor().charAt(0), operator.charAt(0))))
            {                                                          
                if(operator.equals(")")){                                    
                    retirarParenteses(); 
                    passou = true;
                    break;
                }               
                String valor = opPile.getValor();
                opPile.retirar();
                extFile.adicionar(valor);              
            }
            if(!passou)
                opPile.adicionar(operator);            
    }
    private static void retirarParenteses() throws Exception{        
        while(!opPile.isVazia() && !opPile.getValor().equals("(")){            
                String valor = opPile.getValor();
                opPile.retirar();
                extFile.adicionar(valor);
            }        
        if(!opPile.isVazia())
            opPile.retirar();
        else
            throw new Exception("Falta de abre parenteses parenteses ('(')");            
      
    }
    public static double result(){
        return resultado;
    }    
}
