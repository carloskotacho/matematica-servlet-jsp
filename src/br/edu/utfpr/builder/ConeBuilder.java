package br.edu.utfpr.builder;

public class ConeBuilder extends SolidoBuilder {

	private double raio;
	private double altura;
	private double geratriz;
	
	public ConeBuilder(double raio, double altura, double geratriz) {
		this.raio = raio;
		this.altura = altura;
		this.geratriz = geratriz;
	}
	
	@Override
	public void nome() {
		solido.nome = "Cone";
	}

	@Override
	public void areaBase() {
		solido.areaBase = Math.PI * raio * raio;
	}

	@Override
	public void areaLateral() {
		solido.areaLateral = Math.PI * raio * geratriz;
	}

	@Override
	public void areaTotal() {
		solido.areaTotal = Math.PI * raio * (geratriz + raio);
	}

	@Override
	public void volume() {
		solido.volume = (Math.PI * raio * raio * altura) / 3;
	}

}
