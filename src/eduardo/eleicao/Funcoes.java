package eduardo.eleicao;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {

	static Scanner sc = new Scanner(System.in);
	static int Votado;

	public static void Votar(Candidato[] cnd, int qtd) {
		while (Main.VOTACAO) {
			for (int i = 0; i < 4; i++) {
				if (!Main.VOTACAO)
					break;

				Linha();
				System.out.println("Digite o NÚMERO do candidato para VOTAR.");
				System.out.println("Categoria: " + Categ(i));
				System.out.println();
				ListarCandidatos(cnd, Categ(i));

				Votado = sc.nextInt();
				AddVoto(cnd, Categ(i));

			}
		}
	}

	// FUNÇÃO PARA TRADUZIR O NUMERO QUE ESTÁ NO (FOR) PARA O NOME DA CATEGORIA
	public static String Categ(int n) {
		String Cat = "";
		switch (n) {
		case 0:
			Cat = "Filme";
			break;
		case 1:
			Cat = "Música";
			break;
		case 2:
			Cat = "Escritor";
			break;
		case 3:
			Cat = "Autor";
			break;
		default:
			break;
		}
		return Cat;
	}

	public static void AddVoto(Candidato[] cnd, String categ) {
		for (int i = 0; i < Main.qtd_cand; i++) {
			if ((cnd[i].getNumero() == Votado) && cnd[i].getCateg().equals(categ)) {
				cnd[i].AddVoto();
				break;
			}
		}
		if (Votado == 999)
			EncerrarVotacao(cnd);
	}

	/*
	 * FUNÇÃO PARA PERCORRER O VETOR DE CANDIDATOS E IMPRIMIR O NOME COM FILTRO PELA
	 * CATEGORIA
	 */
	public static void ListarCandidatos(Candidato[] cnd, String Cate) {
		System.out.println("Numero do Candidato - Nome do Cantidado");
		for (int i = 0; i < Main.qtd_cand; i++) {
			if (cnd[i].getCateg().equals(Cate)) {
				System.out.println(cnd[i].getCandida());
			}
		}
		System.out.println("999 - ENCERRAR VOTAÇÃO");
	}

	/* FUNÇÃO QUE IMPRIME O CANDIDATO E SEUS VOTOS, SEPARADO POR CATEGORIA */
	public static void ListarVotos(Candidato[] cnd) {
		for (int categoriaa = 0; categoriaa < 4; categoriaa++) {
			System.out.println("Candidato - Votos");
			System.out.println("Categoria: " + Categ(categoriaa));
			System.out.println();

			for (int x = 0; x < Main.qtd_cand; x++) {
				if (cnd[x].getCateg() == Categ(categoriaa)) {
					System.out.println(cnd[x].getNome() + " " + cnd[x].getVotos());
				}

			}
			Linha();
		}
	}

	static int IntMaiorVoto, NmrDoMaior;
	static String StrMaiorVoto;
	static ArrayList<Candidato> Lista = new ArrayList<>();
	static ArrayList<Candidato> Empates = new ArrayList<>();

	public static void CalculaVencedor(Candidato[] cnd) {
		for (int categ = 0; categ < 4; categ++) {
			IntMaiorVoto = 0;
			NmrDoMaior = 0;
			Lista.clear();
			Empates.clear();

			/*
			 * SEPARA OS CANDITADOS DE DETERMINADA CATEGORIA EM UMA LISTA PARA FACILITAR NA
			 * HORA DE VERIFICAR EMPATE
			 */
			for (int cand = 0; cand < Main.qtd_cand; cand++) {
				if (cnd[cand].getCateg().equals(Categ(categ))) {

					Lista.add(cnd[cand]);
					if (cnd[cand].getVotos() > IntMaiorVoto) {
						IntMaiorVoto = cnd[cand].getVotos();
						StrMaiorVoto = cnd[cand].getNome();
					}
				}
			}

			/*
			 * FOREACH PARA PERCORRER A LISTA DA CATEGORIA - ADICIONA OS CANDIDADOS QUE
			 * TIVEREM A MESMA QUANTIDADE DE VOTOS QUE O IntMaiorVoto
			 */
			for (Candidato c : Lista) {
				if (c.getVotos() == IntMaiorVoto && IntMaiorVoto > 0)
					Empates.add(c);
			}
			if (Empates.size() > 1) {
				ImprimeEmpate(Empates, categ);
				Empates.clear();
				Lista.clear();
				continue;
			}

			// CASO NÃO HAJA VOTOS EM DETERMINADA CATEGORIA
			if (IntMaiorVoto == 0) {
				System.out.println("Não houve votação na Categoria " + Categ(categ));
				continue;
			}

			// CASO NÃO HAJA EMPATE, IMPRIME O MAIOR VOTO
			for (Candidato c : Lista) {
				if (c.getNome() == StrMaiorVoto) {
					System.out.println(c.getNome() + " Foi o VENCEDOR da Categoria " + Categ(categ));
					continue;
				}
			}

		}

	}

	public static void ImprimeEmpate(ArrayList<Candidato> a, int categ) {
		System.out.println("Categoria: " + Categ(categ));
		System.out.println("\nHouve EMPATE entre: ");
		for (Candidato c : a) {
			System.out.println(c.getNome());
		}
		Linha();
	}

	public static void EncerrarVotacao(Candidato[] cnd) {
		Linha();
		Main.VOTACAO = false;
		ListarVotos(cnd);
		CalculaVencedor(cnd);
	}

	public static void Linha() {
		System.out.println("==========================================");
	}
}
