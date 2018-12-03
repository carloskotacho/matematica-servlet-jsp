package br.edu.utfpr.builder;

public class CuboBuilder extends SolidoBuilder {
	
	private double lado;
	
	public CuboBuilder(double lado) {
		this.lado = lado;
	}

	@Override
	public void nome() {
		solido.nome = "Cubo";
	}

	@Override
	public void areaBase() {
		solido.areaBase = lado * lado;
	}

	@Override
	public void areaLateral() {
		solido.areaLateral = 4 * lado * lado;
	}

	@Override
	public void areaTotal() {
		solido.areaTotal = 6 * lado * lado;
	}

	@Override
	public void volume() {
		solido.volume = lado * lado * lado;
	}

}
