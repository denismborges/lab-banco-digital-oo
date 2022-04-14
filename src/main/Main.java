package main;

import Service.ContaService;
import entity.Cliente;
import entity.Conta;
import entity.ContaCorrente;
import entity.ContaPoupanca;

public class Main {

    public static void main(String[] args) {
	
	ContaService service = new ContaService();
	
	Cliente venilton = new Cliente();
	venilton.setNome("Venilton");

	Conta cc = new ContaCorrente(venilton);
	Conta poupanca = new ContaPoupanca(venilton);

	service.depositar(cc, 100.0);
	service.transferir(cc, poupanca, 100.0);

	cc.imprimirExtrato();
	poupanca.imprimirExtrato();
    }

}
