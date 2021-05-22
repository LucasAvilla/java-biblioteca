package model;

/**
 * Classe para armazenar os atributos e métodos do objeto Editora
 * 
 * @author Lucas Igor A M Nogueira
 * @since 18 de fev. de 2021
 */
public class Editora {

	// Método construtor da classe
	public Editora() {
	}

	// Declarando os atributos
	private int codigo;
	private String nome;
	private String pais;

	// Método getter e setter para acesso aos atributos
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
