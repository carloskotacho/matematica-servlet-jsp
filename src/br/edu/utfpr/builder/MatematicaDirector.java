package br.edu.utfpr.builder;

import br.edu.utfpr.model.SolidoProduct;

public class MatematicaDirector {
	
	protected SolidoBuilder montador;
	
	public MatematicaDirector(SolidoBuilder montador) {
		this.montador = montador;
	}
	
	public void construirSolido() {
		montador.nome();
		montador.areaBase();
		montador.areaLateral();
		montador.areaTotal();
		montador.volume();
	}
	
	public SolidoProduct getSolido() {
		return montador.getSolido();
	}
	
}
