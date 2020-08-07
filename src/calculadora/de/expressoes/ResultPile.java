/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.de.expressoes;


//  Pilha de Resolução  

public class ResultPile {
    Double[] vetor;    
    int ultimo = -1;    
    
    //construtor da classe com um parametro
    public ResultPile(int valor) throws Exception{
        if(valor < 1)
            throw new Exception("Tamanho inválido");        
        this.vetor = new Double[valor];    
    }

    //construtor da classe sem parametro
    public ResultPile(){
        this.vetor = new Double[20];        
    }
    //adicionar um valor à pilha
    public void adicionar(Double valor) throws Exception{        
        if(this.vetor.length == ultimo)
            throw new Exception("Pilha cheia");
        this.ultimo++;
        this.vetor[ultimo] = valor;        
    }
    //retira um valor da pilha
    public void retirar()throws Exception{
        if(this.ultimo < 0)
            throw new Exception("Pilha vazia");
        this.vetor[ultimo] = null;        
        this.ultimo--;
    }
    //funcao verifica se a pilha esta cheia
    public boolean isCheia()throws Exception{
        return this.ultimo == this.vetor.length;
    }
    //funcao verifica se a pilha esta vazia
    public boolean isVazia()throws Exception{
        return this.ultimo == -1;
    }
    //funcao retorna o ultimo valor da pilha
    public Double getValor() throws Exception{
        if(this.ultimo == -1)
            throw new Exception("Pilha vazia");        
        
        return this.vetor[ultimo];
    }
    
    //TOSTRING//
    public String toString(){
        return (this.ultimo > 0 ? (this.ultimo) + " itens, sendo o ultimo [" + 
                this.vetor[this.ultimo] + "]": "Pilha vazia");
    }
    //EQUALS//
    public boolean equals(Object obj){
        if(this.vetor == obj)
            return true;
        if(this.vetor == null)
            return false;
        if(this.vetor.getClass() != obj.getClass())
            return false;
        
        ResultPile pilha = (ResultPile) obj;

        if(this.ultimo != pilha.ultimo)
            return false;
        
        for(int x = 0; x<this.ultimo; x++)
            if(!this.vetor[x].equals(pilha.vetor[x]))
                return false;
        
        return true;
    }
    //HASHCODE//
    public int hashCode(){        
        int ret = 7;
        for(int x = 0; x < this.ultimo; x++)
            ret = ret * 2 + this.vetor[x].hashCode();        
        ret = ret * 11 + new Integer(this.ultimo).hashCode();
        return ret;
    }
}
