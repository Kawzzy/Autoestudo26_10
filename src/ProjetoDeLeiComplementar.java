import java.time.LocalDate;

public class ProjetoDeLeiComplementar extends ProjetoDeLei {
	
	private String artigoLO;
	private int qtdVotosFavoraveis;
	private Vereador vereador;


	public Vereador getVereador() {
		return vereador;
	}

	public void setVereador(Vereador vereador) {
		this.vereador = vereador;
	}

	public ProjetoDeLeiComplementar(String titulo, LocalDate dtApres, LocalDate dtAprov, 
			int numProjeto, String artigoLO, int qtdVF, 
			String nomeVereador, Partido partidoVereador) {
		
		super(titulo, dtApres, dtAprov, numProjeto, nomeVereador, 
				partidoVereador);
		
		this.setArtigoLO(artigoLO);
		this.setQtdVotosFavoraveis(qtdVF);
	}
	
	public ProjetoDeLeiComplementar() {
		
	}
	
	public String getArtigoLO() {
		return artigoLO;
	}

	public void setArtigoLO(String artigoLO) {
		this.artigoLO = artigoLO;
	}

	public int getQtdVotosFavoraveis() {
		return qtdVotosFavoraveis;
	}

	public void setQtdVotosFavoraveis(int qtdVotosFavoraveis) {
		this.qtdVotosFavoraveis += qtdVotosFavoraveis;
	}

	public String mostrar() {
		String msg = "Título: " + this.getTitulo() + " \n" + "Data de Apresentação: " + super.getDataApresentacao() + 
				" \n" + "Data de Aprovação: " + this.getDataAprovacao() + " \n" + "Número do Projeto: " + this.getNumeroProjeto() + "\n" + 
				"Lei Orgânica: " + this.getArtigoLO() + "\n" + "Qtd votos Favoráveis: " + this.getQtdVotosFavoraveis();

		return msg;
	}
}
