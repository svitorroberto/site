package model;

import java.util.List;

public class Venda {
	private Usuario cliente;
	private List<Item> itens;
	private double valorFinal;
	private String meioDePagamento;
	private String status;
	
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	public String getMeioDePagamento() {
		return meioDePagamento;
	}
	public void setMeioDePagamento(String meioDePagamento) {
		this.meioDePagamento = meioDePagamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
