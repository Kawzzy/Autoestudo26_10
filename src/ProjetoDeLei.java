import java.time.LocalDate;

public class ProjetoDeLei extends Vereador {
	private String titulo;
	private LocalDate dataApresentacao,
					  dataAprovacao;
	private int numeroProjeto;
	
	public ProjetoDeLei(String titulo, LocalDate dtApres, LocalDate dtAprov, int numProjeto, 
			String nomeVereador, Partido partidoVereador, String nomePartido, int numeroPartido) {
		
		super(nomeVereador, partidoVereador, nomePartido, numeroPartido);
		this.setTitulo(titulo);
		this.setDataApresentacao(dtApres);
		this.setDataAprovacao(dtAprov);
		this.setNumeroProjeto(numProjeto);
	}
	
	public ProjetoDeLei() {
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDate getDataApresentacao() {
		return dataApresentacao;
	}
	public void setDataApresentacao(LocalDate dataApresentacao) {
		this.dataApresentacao = dataApresentacao;
	}
	public LocalDate getDataAprovacao() {
		return dataAprovacao;
	}
	public void setDataAprovacao(LocalDate dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}
	public int getNumeroProjeto() {
		return numeroProjeto;
	}
	public void setNumeroProjeto(int numeroProjeto) {
		this.numeroProjeto = numeroProjeto;
	}
	
	public String mostrar() {
		String a = "";
		return a;
	}
}
