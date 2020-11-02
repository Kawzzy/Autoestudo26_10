import java.time.LocalDate;

public class ProjetoDeLei extends Vereador {
	private String titulo;
	private LocalDate dataApresentacao,
					  dataAprovacao;
	private int numeroProjeto;
	
	public ProjetoDeLei(String titulo, LocalDate dtApres, LocalDate dtAprov, int numProjeto, 
			String nomeVereador, Partido partidoVereador) {
		
		super(nomeVereador, partidoVereador);
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
		
	String msg = "Nome: " + super.getNome() +  " \n" + "Partido: " + super.getPartido() + " \n" + "Desempenho: " + super.calcularDesempenho() + " \n" + "Título: " + this.getTitulo() + " \n" +
			"Data de Apresentação: " + this.getDataApresentacao() + " \n" + "Data de Aprovação: " + this.getDataAprovacao() + " \n" + "Número do Projeto: " + this.getNumeroProjeto();
		
		
		
		
		
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
