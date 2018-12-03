package br.edu.utfpr.builder;

import br.edu.utfpr.model.SolidoProduct;

public abstract class SolidoBuilder {

	protected SolidoProduct solido;
	
	public SolidoBuilder() {
		solido = new SolidoProduct();
	}
	
	public abstract void nome();
	
	public abstract void areaBase();
	
	public abstract void areaLateral();
	
	public abstract void areaTotal();
	
	public abstract void volume();
	
	public SolidoProduct getSolido() {
		return solido;
	}
	
}
