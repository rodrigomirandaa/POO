package com.mycompany.mavenproject9;
public class Mavenproject9 {

    public static void main(String[] args) {
        
        //instanciando o banco
        Banco banco = new Banco();
        
        //instanciando as contas
        Conta c1 = new Conta("1111",500,"Claudio");
        Conta c2 = new Conta("1111",500,"Claudio");
        //Conta c3 = new Conta("3333", 3000, "Roger");
        
        banco.adicionarConta(c1);
        banco.adicionarConta(c2);
        
        
        //c1.deposito(100);
        //c1.saque(50);
        
        
        //System.out.println(c1.toString());
        
        //testando buscar conta por numero
        try {
            Conta contaEncontrada = banco.buscarContaPorNumero("1112");
            System.out.println("Conta encontrada pela instância: " + contaEncontrada);
        } catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }       
        
        // testando buscar conta
        try {
            Conta contaParaBuscar = new Conta("1111", 0, ""); // Criando uma nova conta com mesmo número
            Conta contaEncontrada = banco.buscarConta(contaParaBuscar);
            System.out.println("Conta encontrada pela instância: " + contaEncontrada);
        } catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
