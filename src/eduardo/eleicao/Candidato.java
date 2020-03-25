package eduardo.eleicao;

public class Candidato {
	
	private String Nome;
	private int Numero;
	private int Votos;
	private String Categ;
	
	public Candidato() {}
	public Candidato(String nome, int num, String categ) {
		Nome = nome;
		Numero = num;
		Categ = categ;
	}
	public String getNome() {
		return Nome;
	}
	public int getNumero() {
		return Numero;
	}
	public int getVotos() {
		return Votos;
	}
	public String getCateg() {
		return Categ;
	}
	public void AddVoto() {
		Votos++;
	}
	@Override
	public String toString() {
		return "\nNome: " + getNome() +
				"\nNumero: " + getNumero() + 
				"\nCategoria: " + getCateg() +
				"\nVotos: " + getVotos();
	}
}