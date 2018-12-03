package br.edu.utfpr.model;

import java.io.Serializable;

/** (Bean) - Procura as propriedadades usando métodos get. */
public class SolidoProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String nome;
	public double areaBase;
	public double areaLateral;
	public double areaTotal;
	public double volume;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getAreaBase() {
		return areaBase;
	}
	
	public void setAreaBase(double areaBase) {
		this.areaBase = areaBase;
	}
	
	public double getAreaLateral() {
		return areaLateral;
	}
	
	public void setAreaLateral(double areaLateral) {
		this.areaLateral = areaLateral;
	}
	
	public double getAreaTotal() {
		return areaTotal;
	}
	
	public void setAreaTotal(double areaTotal) {
		this.areaTotal = areaTotal;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
}
