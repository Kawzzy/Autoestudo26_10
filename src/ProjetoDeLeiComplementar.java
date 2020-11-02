import java.time.LocalDate;

public class ProjetoDeLeiComplementar extends ProjetoDeLei {
	
	private String artigoLO;
	private int qtdVotosFavoraveis;
	
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
		this.qtdVotosFavoraveis = qtdVotosFavoraveis;
	}

	public String mostrar() {
		String a = "";
		return a;
	}
}
