package Service;

import entity.Conta;
import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;

public class ContaService {


    public void sacar(Conta conta, double valor) {

	try {
	    if (valor <= 0.0) {
		throw new ValorInvalidoException();
	    }
	    
	    if (valor > conta.getSaldo()) {
		throw new SaldoInsuficienteException();
	    }
	    
	    conta.setSaldo(conta.getSaldo() - valor);
	    
	} catch (SaldoInsuficienteException e) {
	    System.err.println(String.format("Ocorreu o seguinte erro ao sacar o valor na conta: %s", e.getMessage()));
	} catch (ValorInvalidoException e) {
	    System.err.println(String.format("Ocorreu o seguinte erro ao sacar o valor na conta: %s", e.getMessage()));
	}
    }


    public void depositar(Conta conta, double valor) {
	try {
	    if (valor <= 0.0) {
		throw new ValorInvalidoException();
	    }
	    
	    conta.setSaldo(conta.getSaldo() + valor);
	    
	} catch (ValorInvalidoException e) {
	    System.err.println(String.format("Ocorreu o seguinte erro ao sacar o valor na conta: %s", e.getMessage()));
	}
	
    }


    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
	
	try {
	    if (valor <= 0.0) {
		throw new ValorInvalidoException();
	    }
	    
	    if (valor > contaOrigem.getSaldo()) {
		throw new SaldoInsuficienteException();
	    }
	    
	    this.sacar(contaOrigem, valor);
	    this.depositar(contaDestino, valor);
	    	    
	} catch (SaldoInsuficienteException e) {
	    System.err.println(String.format("Ocorreu o seguinte erro ao sacar o valor na conta: %s", e.getMessage()));
	} catch (ValorInvalidoException e) {
	    System.err.println(String.format("Ocorreu o seguinte erro ao sacar o valor na conta: %s", e.getMessage()));
	}	
    }
    
    
}
