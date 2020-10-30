import java.util.ArrayList;
import java.util.HashMap;

public class Camara {
	private String municipio;
	private HashMap<Integer, Partido> partidos = new HashMap<>();

	public Camara(String municipio) {
		this.setMunicipio(municipio);
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void addPartido(Partido p) {
		this.partidos.put(p.getNumero(), p);
	}
	
	public Partido getPartido(int numero) {
		return this.partidos.get(numero);
	}

	public int getTotalProjAprov() {
		int total = 0;
		for (Partido p : this.partidos.values()) {
			total += p.getTotalProjAprov();
		}
		return total;
	}

	public int getTotalProjApres() {
		int total = 0;
		for (Partido p : this.partidos.values()) {
			total += p.getTotalProjApres();
		}
		return total;
	}

	public Vereador getVereadorMenorDesempenho() {
		Vereador ruim = null;
		for (Partido p : this.partidos.values()) {
			Vereador piorDoPartido = p.getVereadorMenorDesempenho();
			if (piorDoPartido != null) {
				if (ruim == null || piorDoPartido.calcularDesempenho() < ruim.calcularDesempenho()) {
					ruim = piorDoPartido;
				}
			}
		}
		return ruim;
	}

	public Vereador getVereadorMaisProjAprov() {
		Vereador mais = null;
		for (Partido p : this.partidos.values()) {
			for (Vereador v: p.getVereadores()) {
				if (mais == null 
					||v.getQtdProjAprov() > mais.getQtdProjAprov()) {
					mais = v;
				}
			}
		}
		return mais;
	}

	public double getMediaDesempenho() {
		double total = 0;
		int contador = 0;
		for (Partido p : this.partidos.values()) {
			for (Vereador v: p.getVereadores()) {
				total += v.calcularDesempenho();
				contador++;
			}
		}
		return total/contador;
	}
	
	public ArrayList<Vereador> getVereadoresAcimaMedia(){
		ArrayList<Vereador> resultado = new ArrayList<>();
		double media = this.getMediaDesempenho();
		for (Partido p : this.partidos.values()) {
			for (Vereador v: p.getVereadores()) {
				if (v.calcularDesempenho() > media) {
					resultado.add(v);
				}
			}
		}
		return resultado;
	}
}