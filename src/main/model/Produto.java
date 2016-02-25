package model;

import java.io.File;
import java.util.List;

public class Produto {
	private Long id;
	private String descricao;
	private List<File> imagens;
	private String detalhes;
	private double valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<File> getImagens() {
		return imagens;
	}
	public void setImagens(List<File> imagens) {
		this.imagens = imagens;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
