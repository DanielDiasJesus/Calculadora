/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.de.expressoes;

/**
 *
 * @author Romicasa
 */
public class Tabela {
    private static String simbolo = "(^*/+-)";

    private static boolean[][] tabela =
       {{false,false,false,false,false,false,true },
        {false,true ,true ,true ,true ,true ,true },
        {false,false,true ,true ,true ,true ,true },
        {false,false,true ,true ,true ,true ,true },
        {false,false,false,false,true ,true ,true },
        {false,false,false,false,true ,true ,true },
        {false,false,false,false,false,false,false}};

    public static boolean isParaDesempilhar (char doTopo, char doStrTok) throws Exception
    {
        int lin = Tabela.simbolo.indexOf (doTopo);

        if (lin == -1)
            throw new Exception ("Char do topo invalido");

        int col = Tabela.simbolo.indexOf (doStrTok);

        if (col == -1)
            throw new Exception ("Char pego do StringTokenizer invalido");

        return Tabela.tabela[lin][col];
    }
}
