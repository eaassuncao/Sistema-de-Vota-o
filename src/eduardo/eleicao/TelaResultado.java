package eduardo.eleicao;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaResultado extends JFrame {

	public TelaResultado() {
		ConfigBotoes();
		AcoesBotoes();

		setTitle("Sistema de Votação - Eduardo Assunção");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setVisible(true);
	}

	private void AcoesBotoes() {
		btnCateg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculaResultado(Main.categ1, 0);
			}
		});
		btnCateg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculaResultado(Main.categ2, 1);
			}
		});
		btnCateg3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculaResultado(Main.categ3, 1);
			}
		});
		btnCateg4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculaResultado(Main.categ4, 3);
			}
		});

		btnEncerrarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void ConfigBotoes() {
		lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Microsoft Tai Le", Font.BOLD, 33));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(10, 11, 774, 116);
		getContentPane().add(lblResultado);

		lblInstrucao = new JLabel("CLIQUE EM QUEM DESEJA VER O RESULTADO!");
		lblInstrucao.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblInstrucao.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucao.setBounds(10, 113, 774, 20);
		getContentPane().add(lblInstrucao);
		
		btnCateg1 = new JButton(Main.categ1[0].getCateg());
		btnCateg1.setBounds(126, 191, 155, 83);
		getContentPane().add(btnCateg1);

		btnCateg2 = new JButton(Main.categ2[0].getCateg());
		btnCateg2.setBounds(474, 191, 155, 83);
		getContentPane().add(btnCateg2);

		btnCateg3 = new JButton(Main.categ3[0].getCateg());
		btnCateg3.setBounds(126, 341, 155, 83);
		getContentPane().add(btnCateg3);

		btnCateg4 = new JButton(Main.categ4[0].getCateg());
		btnCateg4.setBounds(474, 341, 155, 83);
		getContentPane().add(btnCateg4);

		btnEncerrarPrograma = new JButton("Encerrar Programa");
		btnEncerrarPrograma.setBounds(574, 506, 170, 35);
		getContentPane().add(btnEncerrarPrograma);
	}

	private void CalculaResultado(Candidato[] cand, int NulosBrancos) {
		ArrayList<Candidato> Empates = new ArrayList<>();
		int MaiorVoto = 0;

		/* PEGA O MAIOR VOTO */
		for (int i = 0; i < Main.qtd_cand; i++) {
			if (cand[i].getVotos() > MaiorVoto) {
				MaiorVoto = cand[i].getVotos();
			}
		}

		/* COLOCA OS JOGADORES COM VOTOS IGUAIS A VARIAVEL MAIOR VOTO */
		for (int i = 0; i < Main.qtd_cand; i++) {
			if (cand[i].getVotos() == MaiorVoto) {
				Empates.add(cand[i]);
			}
		}
		if (Empates.size() > 1) {
			JOptionPane.showMessageDialog(null, "Houve empate entre:\n" + Empates(Empates) + "\n\n" + Candidatos(cand) + "Nulos: "
					+ Main.VotoNulo[NulosBrancos] + "\nBrancos: " + Main.VotoBranco[NulosBrancos]);
			return;
		} else {
			for (int i = 0; i < Main.qtd_cand; i++) {
				if (cand[i].getVotos() == MaiorVoto) {
					JOptionPane.showMessageDialog(null,
							"O Vencedor foi " + cand[i].getNome() + "\n\n" + Candidatos(cand) + "Nulos: "
									+ Main.VotoNulo[NulosBrancos] + "\nBrancos: " + Main.VotoBranco[NulosBrancos]);
				}
			}
		}
	}

	private String Empates(ArrayList<Candidato> c) {
		StringBuilder ret = new StringBuilder();

		for (Candidato candidato : c) {
			ret.append(candidato.getNome() + "\n");
		}

		return ret.toString();
	}

	private String Candidatos(Candidato[] c) {
		StringBuilder ret = new StringBuilder();
		ret.append("Votos:\n");
		for (int i = 0; i < Main.qtd_cand; i++) {
			ret.append(c[i].getNome() + ": " + c[i].getVotos() + "\n");
		}

		return ret.toString();
	}

	private static final long serialVersionUID = 1L;
	private JLabel lblResultado;
	private JLabel lblInstrucao;
	private JButton btnCateg1;
	private JButton btnCateg2;
	private JButton btnCateg3;
	private JButton btnCateg4;
	private JButton btnEncerrarPrograma;
}
