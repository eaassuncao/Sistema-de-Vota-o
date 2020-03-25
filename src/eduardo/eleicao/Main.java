package eduardo.eleicao;

public class Main {
	public static int qtd_cand = 5;
	public static final int VotacaoMinima = 4;
	public static int Votados = 0;

	public static Candidato[] categ1 = new Candidato[Main.qtd_cand];
	public static Candidato[] categ2 = new Candidato[Main.qtd_cand];
	public static Candidato[] categ3 = new Candidato[Main.qtd_cand];
	public static Candidato[] categ4 = new Candidato[Main.qtd_cand];
	
	public static int[] VotoNulo = new int[4];
	public static int[] VotoBranco = new int[4];

	public static void main(String[] args) {
		// FILME
		categ1[0] = new Candidato("José", 1, "Filme");
		categ1[1] = new Candidato("Alberto", 2, "Filme");
		categ1[2] = new Candidato("Mayron", 3, "Filme");
		categ1[3] = new Candidato("Junior", 4, "Filme");
		categ1[4] = new Candidato("Jorge", 5, "Filme");
		// MÚSICA
		categ2[0] = new Candidato("Adair", 1, "Música");
		categ2[1] = new Candidato("Elenilton", 2, "Música");
		categ2[2] = new Candidato("Joselinton", 3, "Música");
		categ2[3] = new Candidato("Diogo", 4, "Música");
		categ2[4] = new Candidato("Junin", 5, "Música");
		// ESCRITOR
		categ3[0] = new Candidato("Sergio", 1, "Escritor");
		categ3[1] = new Candidato("Altemar", 2, "Escritor");
		categ3[2] = new Candidato("Eduardo", 3, "Escritor");
		categ3[3] = new Candidato("Lilian", 4, "Escritor");
		categ3[4] = new Candidato("Josevaldo", 5, "Escritor");
		// AUTOR
		categ4[0] = new Candidato("Tico", 1, "Autor");
		categ4[1] = new Candidato("Teco", 2, "Autor");
		categ4[2] = new Candidato("Tuco", 3, "Autor");
		categ4[3] = new Candidato("Tucson", 4, "Autor");
		categ4[4] = new Candidato("Tucsonildo", 5, "Autor");
		
		new TelaCateg1();
		
	}
}