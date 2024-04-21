package repositorio;

import entidade.Conta;
import java.util.ArrayList;

public interface IRepositorioConta {
    
    
    public void inserirConta(Conta c);
    public void alterarConta(Conta c);
    public void removerConta(Conta c);
    public Conta buscarConta(int numero);
    public ArrayList<Conta> buscarTodas();
    
    public boolean verificarExistenciaConta(int numero);
       
}



