package fachada;

import entidade.Conta;
import negocio.ControladorConta;

import java.util.ArrayList;


public class Fachada implements IFachada {
    
    
   //Tem um ou mais atributos do tipo Controlador.
   private ControladorConta controladorConta;
    
   public Fachada(){
       this.controladorConta=new ControladorConta();
   }
   
   //Obrigatoriamente, deve implementar todos os métodos da interface da fachada.
    @Override
    public void inserirConta(Conta c) {
        this.controladorConta.inserirConta(c);
    }

    @Override
    public void alterarConta(Conta c) {
        this.controladorConta.alterarConta(c);
    }

    @Override
    public void removerConta(int numero) {
        this.controladorConta.removerConta(numero);
    }

    @Override
    public Conta buscarConta(int numero) {
        return this.controladorConta.buscarConta(numero);
    }

    @Override
    public ArrayList<Conta> buscarTodas() {
        return this.controladorConta.buscarTodas();
    }
    
}
