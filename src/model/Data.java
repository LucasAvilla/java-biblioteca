package model;

/**
 * Classe para armazenar os atributos e m�todos do objeto Data
 * 
 * @author Lucas Igor A M Nogueira
 * @since 18 de fev. de 2021
 */
public class Data {

	// M�todo construtor da classe
	public Data() {
	}

	// Declarando os atributos
	private int dia;
	private int mes;
	private int ano;

	// M�todo getter e setter para acesso aos atributos
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

}
