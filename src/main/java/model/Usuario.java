package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	@Id
	private Long matricula;
	private String login;
	@Column(name="nome")
	private String nomeCompleto;
	private String senha;
	private String email;
	@Column(name="datanascimento")
	private Date dataNasc;
	@Column(name="psecreta")
	private String perguntaSecreta;
	@Column(name="rsecreta")
	private String respostaSecreta;
	private String telefone;
	private String tipo;
	
	

	public Usuario(Long matricula, String login, String nomeCompleto, String senha, String email, Date dataNasc, String perguntaSecreta, String respostaSecreta, String telefone, String tipo){
		this.matricula = matricula;
		this.login = login;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
		this.email = email;
		this.dataNasc = dataNasc;
		this.perguntaSecreta = perguntaSecreta;
		this.respostaSecreta = perguntaSecreta;
		this.telefone = telefone;
		this.tipo = tipo;
	}
	public Usuario(){
	
	}
	public void limpar(){
		this.setDataNasc(null);
		this.setEmail(null);
		this.setLogin(null);
		this.setMatricula(null);
		this.setNomeCompleto(null);
		this.setPerguntaSecreta(null);
		this.setRespostaSecreta(null);
		this.setSenha(null);
		this.setTelefone(null);
		this.setTipo(null);
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNasc() {
		return this.dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		format.format(dataNasc);
		this.dataNasc = dataNasc;		
	}
	public String getPerguntaSecreta() {
		return perguntaSecreta;
	}
	public void setPerguntaSecreta(String perguntaSecreta) {
		this.perguntaSecreta = perguntaSecreta;
	}
	public String getRespostaSecreta() {
		return respostaSecreta;
	}
	public void setRespostaSecreta(String respostaSecreta) {
		this.respostaSecreta = respostaSecreta;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}