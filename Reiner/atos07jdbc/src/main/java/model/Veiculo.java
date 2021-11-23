package model;

public class Veiculo {
	
	public int id;
	public int ano;
	public String marca;
	public String modelo;
	
	public Veiculo() {
	}

	public Veiculo(int ano, String marca, String modelo) {
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
	}

	public int getId() {
		return id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", ano=" + ano + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

	
}