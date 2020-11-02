public class Vereador extends Partido {
	protected String nome;
	protected Partido partido;
	private int qtdProjAprov = 0;
	private int qtdProjApres = 0;

	public Vereador(String nome, Partido partido, String nomePartido, int numeroPartido) {
		
		super(nomePartido, numeroPartido);
		
		this.setNome(nome);
		this.setPartido(partido);
	}
	
	public Vereador(String nome, Partido partido) {
		this.setNome(nome);
		this.setPartido(partido);
	}
	
	public Vereador() {
		
	}

	public double getIndiceTrabalho() {
		double indiceTrab = 0;
		if (this.qtdProjApres == 0) {
			return 0;
		} else if (this.qtdProjApres <= 5) {
			indiceTrab = 0.80;
		} else if (this.qtdProjApres <= 10) {
			indiceTrab = 1;
		} else if (this.qtdProjApres <= 17) {
			indiceTrab = 1.08;
		} else {
			indiceTrab = 1.22;
		}
		return indiceTrab;
	}

	public double calcularDesempenho() {
		return (this.qtdProjAprov / (double)this.qtdProjApres) * this.getIndiceTrabalho();
	}    

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty()) {
			this.nome = nome;
		}
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		if (partido != null) {
			this.partido = partido;
			partido.addVereador(this);
		}
	}

	public int getQtdProjAprov() {
		return qtdProjAprov;
	}

	public void setQtdProjAprov(int qtdProjAprov) {
		if (qtdProjAprov >= 0) {
			this.qtdProjAprov = qtdProjAprov;
		}
	}

	public int getQtdProjApres() {
		return qtdProjApres;
	}

	public void setQtdProjApres(int qtdProjApres) {
		if (qtdProjApres >= 0) {
			this.qtdProjApres = qtdProjApres;
		}
	}
}
