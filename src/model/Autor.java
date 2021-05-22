package model;

/**
 * Classe para armazenar os atributos e métodos do objeto Autor
 * 
 * @author Lucas Igor A M Nogueira
 * @since 18 de fev. de 2021
 */
public class Autor {

	// Método construtor da classe
	public Autor() {
	}

	// Declarando os atributos
	private int codigo;
	private String nome;
	private String nacionalidade;

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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

}
