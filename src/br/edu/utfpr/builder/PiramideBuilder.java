package br.edu.utfpr.builder;

public class PiramideBuilder extends SolidoBuilder {

	private double altura;
	private double ladoBase;
	private double apotemaBase;
	private double apotemaPiramide;
	//private String tipo;
	private int tipo;
	private int nFaces;
	
	public PiramideBuilder(double altura, double ladoBase, double apotemaBase, double apotemaPiramide, int tipo) {
		this.altura = altura;
		this.ladoBase = ladoBase;
		this.apotemaBase = apotemaBase;
		this.apotemaPiramide = apotemaPiramide;
		this.tipo = tipo;
		this.nFaces = 0;
	}
	
	@Override
	public void nome() {
		solido.nome = "Pirâmide " + tipo;
	}

	@Override
	public void areaBase() {
		
		if (tipo == 1) { // tipo.equals("triangular")
			solido.areaBase = (ladoBase * apotemaBase) / 2;
			nFaces = 3;
		}else if (tipo == 2) { // tipo.equals("quadrangular")
			solido.areaBase = ladoBase * ladoBase;
			nFaces = 4;
		}else if (tipo == 3) { // tipo.equals("pentagonal")
			solido.areaBase = 5 * ((ladoBase * apotemaBase) / 2);
			nFaces = 5;
		}else {
			solido.areaBase = 6 * ((ladoBase * apotemaBase) / 2);
			nFaces = 6;
		}	
		
	}

	/** 
	 * 	Al = soma das áreas de todas as faces laterais 
	 * */
	@Override
	public void areaLateral() {
		solido.areaLateral = nFaces * ((ladoBase * apotemaPiramide) / 2);
	}

	/**
	 *	At = Al + Ab 
	 * */
	@Override
	public void areaTotal() {
		solido.areaTotal = solido.areaLateral + solido.areaBase;
	}

	/** 
	 *	V = 1/3 Ab.h 
	 * */
	@Override
	public void volume() {
		solido.volume = (solido.areaBase * altura) / 3;
	}

}
