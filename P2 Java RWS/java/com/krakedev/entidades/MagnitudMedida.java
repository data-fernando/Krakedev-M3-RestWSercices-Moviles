package com.krakedev.entidades;

public class MagnitudMedida {
	private String codigoMedida;
	private String objetoMedida;
	
	public String getCodigoMedida() {
		return codigoMedida;
	}
	public void setCodigoMedida(String codigoMedida) {
		this.codigoMedida = codigoMedida;
	}
	public String getObjetoMedida() {
		return objetoMedida;
	}
	public void setObjetoMedida(String objetoMedida) {
		this.objetoMedida = objetoMedida;
	}
	public MagnitudMedida(String codigoMedida, String objetoMedida) {
		super();
		this.codigoMedida = codigoMedida;
		this.objetoMedida = objetoMedida;
	}
	public MagnitudMedida() {
		super();
	}
	@Override
	public String toString() {
		return "MannitudMedida [codigoMedida=" + codigoMedida + ", objetoMedida=" + objetoMedida + "]";
	}
	
	

}
