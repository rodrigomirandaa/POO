package repositorio;

import entidade.Conta;
import java.util.ArrayList;

public class RepositorioConta implements IRepositorioConta {
    
    private ArrayList<Conta> contas;
    
    public RepositorioConta(){
        this.contas= new ArrayList<>();
    }

 
    @Override
    public void inserirConta(Conta c) {
        this.contas.add(c);
    }

    @Override
    public void alterarConta(Conta c) {
        if (this.verificarExistenciaConta(c.getNumero())) {
            this.contas.set(this.buscarIndice(c),c);
        }
    }

    @Override
    public void removerConta(Conta c) {
        this.contas.remove(c);
    }

    @Override
    public Conta buscarConta(int numero) {
        for (int i=0 ; i<this.contas.size(); i++){
            Conta temp = contas.get(i);
            if(temp.getNumero()==numero){
                return temp;
            }
        }
        return null;
    }
    
    public int buscarIndice(Conta c){
        return c.getNumero();
    }
        
    
    @Override
    public boolean verificarExistenciaConta(int numero) {
        return (this.buscarConta(numero) != null);
    }
    
    @Override
    public ArrayList<Conta> buscarTodas() {
        return contas;
    }

   
    
}
