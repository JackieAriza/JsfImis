package com.gaes3.imisG.modelo;

public class VentasPorMesDTO {
	private String mes;
	
	private double valorTotal;

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public VentasPorMesDTO(String mes, double valorTotal) {
		super();
		this.mes = mes;
		this.valorTotal = valorTotal;
	}

	public VentasPorMesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "VentasPorMesDTO [mes=" + mes + ", valorTotal=" + valorTotal + "]";
	}
	
	
}
