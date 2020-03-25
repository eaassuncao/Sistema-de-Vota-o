package eduardo.eleicao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCateg3 extends JFrame {
	public TelaCateg3() {

		Config();
		AcoesBotao();

		setTitle("Sistema de Votação - Eduardo Assunção");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		setVisible(true);
	}

	private void Config() {
		lblCateg = new JLabel(Main.categ3[0].getCateg());
		lblCateg.setFont(new Font("Microsoft Tai Le", Font.BOLD, 33));
		lblCateg.setHorizontalAlignment(SwingConstants.CENTER);
		lblCateg.setBounds(10, 11, 774, 116);
		getContentPane().add(lblCateg);

		btnCand1 = new JButton(Main.categ3[0].getNome());
		btnCand1.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		btnCand1.setBounds(79, 168, 157, 65);
		getContentPane().add(btnCand1);

		btnCand2 = new JButton(Main.categ3[1].getNome());
		btnCand2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		btnCand2.setBounds(312, 168, 157, 65);
		getContentPane().add(btnCand2);

		btnCand3 = new JButton(Main.categ3[2].getNome());
		btnCand3.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		btnCand3.setBounds(542, 168, 157, 65);
		getContentPane().add(btnCand3);

		btnCand4 = new JButton(Main.categ3[3].getNome());
		btnCand4.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		btnCand4.setBounds(171, 266, 157, 65);
		getContentPane().add(btnCand4);

		btnCand5 = new JButton(Main.categ3[4].getNome());
		btnCand5.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		btnCand5.setBounds(453, 266, 157, 65);
		getContentPane().add(btnCand5);

		btnNulo = new JButton("Nulo");
		btnNulo.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		btnNulo.setBounds(225, 377, 157, 65);
		getContentPane().add(btnNulo);
		
		btnBranco = new JButton("Branco");
		btnBranco.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		btnBranco.setBounds(392, 377, 157, 65);
		getContentPane().add(btnBranco);
		
		btnEncerraVot = new JButton("Encerrar Votação");
		btnEncerraVot.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 16));
		btnEncerraVot.setBounds(542, 485, 215, 57);
		getContentPane().add(btnEncerraVot);
		
		lblInstrucao = new JLabel("CLIQUE EM QUEM DESEJA VOTAR!");
		lblInstrucao.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 15));
		lblInstrucao.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrucao.setBounds(10, 113, 774, 20);
		getContentPane().add(lblInstrucao);
	}

	private void AcoesBotao() {
		btnCand1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar(0);
			}
		});
		btnCand2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar(1);
			}
		});
		btnCand3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar(2);
			}
		});
		btnCand4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar(3);
			}
		});
		btnCand5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Votar(4);
			}
		});
		btnNulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.VotoNulo[2]++;
				new TelaCateg4();
			}
		});
		btnBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.VotoBranco[2]++;
				new TelaCateg4();
			}
		});
		btnEncerraVot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Main.Votados < Main.VotacaoMinima) {
					JOptionPane.showMessageDialog(null,
							"A votação não pode ser encerrada, pois não huve o número mínimo de votos!\nVotação Mínima: "
									+ Main.VotacaoMinima);
				} else {
					setVisible(false);
					new TelaResultado();
				}
			}
		});
	}

	private void Votar(int Votado) {
		Main.Votados++;
		Main.categ3[Votado].AddVoto();
		new TelaCateg4();
	}

	private static final long serialVersionUID = 1L;
	private JLabel lblCateg;
	private JButton btnCand1;
	private JButton btnCand2;
	private JButton btnCand3;
	private JButton btnCand4;
	private JButton btnCand5;
	private JButton btnEncerraVot;
	private JButton btnNulo;
	private JButton btnBranco;
	private JLabel lblInstrucao;
}
