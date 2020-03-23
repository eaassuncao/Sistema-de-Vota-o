package eduardo.eleicao;


public class Main {
	/*
	 * Desenvolver um projeto para votação de 4 categorias, sendo filme, música,
	 * escritor e autor.
	 * 
	 * Cada uma das categorias deverá possuir 5 candidatos.
	 * 
	 * O esquema para votação deverá contemplar apenas essas 4 categorias e mostrar
	 * no final da votação a apuração dos votos, mostrando o vencedor ou o empate
	 * entre os candidatos com maior número de votos.
	 */
	public static boolean VOTACAO = true;
	public static int qtd_cand = 20;

	public static void main(String[] args) {

		Candidato[] cand = new Candidato[qtd_cand];

		// FILME
		cand[0] = new Candidato("José", 1, "Filme");
		cand[1] = new Candidato("Alberto", 2, "Filme");
		cand[2] = new Candidato("Mayron", 3, "Filme");
		cand[3] = new Candidato("Junior", 4, "Filme");
		cand[4] = new Candidato("Jorge", 5, "Filme");
		// MÚSICA
		cand[5] = new Candidato("Adair", 1, "Música");
		cand[6] = new Candidato("Elenilton", 2, "Música");
		cand[7] = new Candidato("Joselinton", 3, "Música");
		cand[8] = new Candidato("Diogo", 4, "Música");
		cand[9] = new Candidato("Junin", 5, "Música");
		// ESCRITOR
		cand[10] = new Candidato("Sergio", 1, "Escritor");
		cand[11] = new Candidato("Altemar", 2, "Escritor");
		cand[12] = new Candidato("Eduardo", 3, "Escritor");
		cand[13] = new Candidato("Lilian", 4, "Escritor");
		cand[14] = new Candidato("Josevaldo", 5, "Escritor");
		// AUTOR
		cand[15] = new Candidato("Tico", 1, "Autor");
		cand[16] = new Candidato("Teco", 2, "Autor");
		cand[17] = new Candidato("Tuco", 3, "Autor");
		cand[18] = new Candidato("Tucson", 4, "Autor");
		cand[19] = new Candidato("Tucsonildo", 5, "Autor");

		Funcoes.Votar(cand, qtd_cand);

	}
}