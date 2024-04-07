
package com.mycompany.mavenproject9;
public class Conta {
    private String numero;
    private double saldo;
    private String nomeCliente;

    
    public Conta(String numero, double saldo, String nomeCliente){ //constructor   
        this.numero=numero;
        this.saldo=0;
        this.nomeCliente=nomeCliente;
    }    
    
    public void deposito(double valor){
        this.saldo=this.saldo+valor; //setSaldo(getSaldo()+valor)
    }
    
    public void saque(double valor){
        if(valor>saldo){
            System.out.println("Saldo insuficiente!");
        }else{
            System.out.println("Saque de: R$ "+valor+" realizado");
            setSaldo(getSaldo()-valor);
        }
    }
    
    public void setNumero(String numero){
        this.numero=numero;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    
    public double getSaldo(){
        return saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    @Override
    public String toString() {
        return "Conta{" + "numero=" + numero + ", saldo=" + getSaldo() + ", nomeCliente=" + nomeCliente + '}';
    }
    
    //equals já existe implicitamente para objetos no java, porém não para especificamente o objeto conta
    //o equals implicito só checaria o endereço de memoria
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        
        //converte o obj para conta
        Conta outraConta = (Conta) obj;
        return numero.equals(outraConta.numero);
    }
}
