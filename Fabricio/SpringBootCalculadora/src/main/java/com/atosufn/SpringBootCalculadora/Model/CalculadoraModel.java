package com.atosufn.SpringBootCalculadora.Model;

public class CalculadoraModel {
	
	private Double primeiro;
	
	private Double segundo;
	
	private Double resultado;

	public CalculadoraModel(Double primeiro, Double segundo, Double resultado) {
		super();
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
	}

	public Double getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Double primeiro) {
		this.primeiro = primeiro;
	}

	public Double getSegundo() {
		return segundo;
	}

	public void setSegundo(Double segundo) {
		this.segundo = segundo;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "CalculadoraModel [primeiro=" + primeiro + ", segundo=" + segundo + ", resultado=" + resultado + "]";
	}

}
