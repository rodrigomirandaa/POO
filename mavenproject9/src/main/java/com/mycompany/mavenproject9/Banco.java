package com.mycompany.mavenproject9;

import java.util.ArrayList;


public class Banco {
    private ArrayList<Conta> contas;
    
    public Banco(){
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta){ //criar a conta com base na classe
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso!");
    }
    
    public void removerConta(String numero) {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero().equals(numero)) {
                contas.remove(i);
                System.out.println("Conta removida com sucesso.");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
    
    public Conta buscarContaPorNumero(String numeroConta) throws ContaNaoEncontradaException{
        // para as contas ref a classe conta presente no ArrayList contas
        for (Conta conta : contas){
            if (conta.getNumero().equals(numeroConta)){
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("Conta não encontrada");
    }
    
    public Conta buscarConta(Conta c) throws ContaNaoEncontradaException{
        for(Conta conta : contas){
            if(conta.equals(c)){
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("Conta não encontrada");
    }
}
