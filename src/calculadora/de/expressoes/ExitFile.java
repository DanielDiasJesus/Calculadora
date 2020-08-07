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
public class ExitFile {
    String[] vetor;
    int primeiro = 0, ultimo = 0, total = 0;
    
    //Construtor com um parametro da classe
    public ExitFile(int valor) throws Exception{
        if(valor < 1)
            throw new Exception("Tamanho inválido");
        this.vetor =  new String[valor];
    }
    //Construtor sem parametro da classe
    public ExitFile(){
        this.vetor = new String[20];
    }
    //adicionar um elemento na fila
    public void adicionar(String valor) throws Exception{      
        if (this.total == this.vetor.length)
            throw new Exception ("Fila cheia");

        this.vetor[this.ultimo] = valor;
        this.ultimo = this.ultimo < this.vetor.length ? this.ultimo + 1 : 0;
        this.total++;
    }
    //retirar um elemento da fila
    public void retirar()throws Exception{
        if (this.total == 0)
            throw new Exception ("Fila vazia");

        this.vetor[this.primeiro] = null;
        this.primeiro = this.primeiro < this.vetor.length ? this.primeiro + 1 : 0;
        this.total--;        
    }
    //funcao verifica se a fila esta cheia
    public boolean isCheia()throws Exception{
        return this.total < this.vetor.length;
    }
    //funcao verifica se a fila esta vazia
    public boolean isVazia()throws Exception{
        return this.total == 0;
    }
    //funcao retorna o primeiro elemento da fila
    public String getValor() throws Exception{
        if (this.total == 0)
            throw new Exception ("Fila vazia");

        return this.vetor[this.primeiro];
    }
    
    //TOSTRING//
    public String toString(){
        return (this.total > 0 ? (this.ultimo) + " itens, sendo o primeiro sendo o primeiro [" + this.vetor[this.primeiro] + "]": "Fila vazia");
    }
    //EQUALS//
    public boolean equals(Object obj){
        if(this.vetor == obj)
            return true;
        if(this.vetor == null)
            return false;
        if(this.vetor.getClass() != obj.getClass())
            return false;

        ExitFile Fila = (ExitFile) obj;

        if(this.ultimo != Fila.ultimo)
            return false;
        if(this.primeiro != Fila.primeiro)
            return false;
        if(this.total != Fila.total)
            return false;

        for(this.primeiro = this.vetor.length ; this.primeiro >= this.ultimo; this.primeiro--)
            if(!this.vetor[primeiro].equals(Fila.vetor[primeiro]))
                return false;

        return true;
    }
    
    //HASHCODE//
    public int hashCode(){
        int ret = 7;
        for(int x = this.primeiro; x < this.ultimo; x++)
            ret = ret * 2 + this.vetor[x].hashCode();
        ret = ret * 11 + new Integer(this.primeiro).hashCode();
        ret = ret * 11 + new Integer(this.ultimo).hashCode();
        return ret;
    }
}
