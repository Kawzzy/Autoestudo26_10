import java.util.ArrayList;

public class Partido {
	private String nome;
	private int numero;
	private ArrayList<Vereador> vereadores = new ArrayList<>();

	public Partido(String nome, int numero) {
		this.setNome(nome);
		this.setNumero(numero);
	}
	
	protected void addVereador(Vereador v) {
		this.vereadores.add(v);
	}

	public int getTotalProjApres() {
		int total = 0;
		for (Vereador v:this.vereadores) {  // for-each
			total += v.getQtdProjApres();
		}
		return total;
	}

	public int getTotalProjAprov() {
		int total = 0;
		for (Vereador v:this.vereadores) {  // for-each
			total += v.getQtdProjAprov();
		}
		return total;
	}

	public Vereador getVereadorMenorDesempenho() {
		Vereador pior = null;
		for (Vereador v: this.vereadores) {
			if (pior == null || v.calcularDesempenho() < pior.calcularDesempenho()) {
				pior = v;
			}
		}
		return pior;
	}
	
	public double getMediaDesempenho() {
		if (this.vereadores.isEmpty()) {
			return 0;
		}
		double total = 0;
		for (Vereador veread:this.vereadores) {  // for-each
			total += veread.calcularDesempenho();
		}
		return total/this.vereadores.size();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty()) {
			this.nome = nome;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero>=10 && numero < 100) {
			this.numero = numero;
		}
	}

	public ArrayList<Vereador> getVereadores(){
		return new ArrayList<>(this.vereadores);
	}
}