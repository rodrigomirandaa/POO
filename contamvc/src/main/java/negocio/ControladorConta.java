package negocio;

import entidade.Conta;
import repositorio.*;

import java.util.ArrayList;

//Contém os métodos que serão chamados pela fachada
public class ControladorConta {
    
    //Tem um atributo do tipo IRepositorio para acessar os métodos da camada de acesso a dados.
    private IRepositorioConta repContas;

    public ControladorConta() {
        this.repContas = new RepositorioConta();
    }
    
    public boolean verificarExistenciaConta(int numero){
        return this.repContas.verificarExistenciaConta(numero);
    }
    
    public void inserirConta(Conta c) {
        if (repContas.verificarExistenciaConta(c.getNumero())){
            System.out.println("Conta já existe!");
        }else {
            this.repContas.inserirConta(c);
        }
    }
    
    public void alterarConta(Conta c) {
        this.repContas.alterarConta(c);
    }

    public void removerConta(int numero) {
        Conta conta = this.repContas.buscarConta(numero);
        
        if(conta != null){
            this.repContas.removerConta(conta);
        }else{
            System.out.println("Conta não encontrada!");
        }
    }

    public Conta buscarConta(int numero) {
        return this.repContas.buscarConta(numero);
    }

    public ArrayList<Conta> buscarTodas() {
        return this.repContas.buscarTodas();
    }
    
    
}
