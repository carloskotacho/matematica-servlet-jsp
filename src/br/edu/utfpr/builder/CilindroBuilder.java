package br.edu.utfpr.builder;

public class CilindroBuilder extends SolidoBuilder {

	private double raio;
	private double altura;
	
	public CilindroBuilder(double raio, double altura) {
		this.raio = raio;
		this.altura = altura;
	}
	
	@Override
	public void nome() {
		solido.nome = "Cilindro";
	}

	@Override
	public void areaBase() {
		solido.areaBase = Math.PI * raio * raio;
	}

	@Override
	public void areaLateral() {
		solido.areaLateral = 2 * Math.PI * raio * altura;
	}

	@Override
	public void areaTotal() {
		solido.areaTotal = (2 * solido.areaBase) + solido.areaLateral;
	}

	@Override
	public void volume() {
		solido.volume = solido.areaBase * altura;
	}

}
