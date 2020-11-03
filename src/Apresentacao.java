import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.GroupLayout;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author marcel
 */
public class Apresentacao extends javax.swing.JFrame {

	private Camara camara = new Camara("Blumenau");
	private Partido pesquisado;
	private ProjetoDeLei projetoDeLei;
	private ProjetoDeLeiComplementar projetoDeLeiComplementar;
	private ArrayList<ProjetoDeLei> projetos = new ArrayList<>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private ArrayList<Vereador> vereadores = new ArrayList<>();
	private HashMap<Vereador, ProjetoDeLei> planos = new HashMap<>();
	private int contProjetos;
	private int contProjetosAprov;

	/**
	 * Creates new form Apresentacao
	 */
	public Apresentacao() {
		initComponents();
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jLabel7 = new javax.swing.JLabel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jlNomePartido = new javax.swing.JLabel();
		jtfNumPartido = new javax.swing.JTextField();
		jtfNomePartido = new javax.swing.JTextField();
		jbCadastrarPartido = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jbMenorDesempenho = new javax.swing.JButton();
		jbMenorDesempenho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vereador menor = camara.getVereadorMenorDesempenho();
				String msg;
				if (menor == null) {
					msg = "Não há vereadores cadastrados";
				} else {
					msg = "Menor desempenho: " + menor.getNome() + " do partido " + menor.getPartido().getNome()
							+ " está com desempenho " + menor.calcularDesempenho();
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		jbMaisProjetos = new javax.swing.JButton();
		jbMaisProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vereador mais = camara.getVereadorMaisProjAprov();
				String msg;
				if (mais == null) {
					msg = "Não há vereadores cadastrados";
				} else {
					msg = "Vereador: " + mais.getNome() + "; Partido: " + mais.getPartido().getNome() + "; Quantidade: " + mais.getQtdProjAprov();
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		jLabel9 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField();
		jbEstatisticas = new javax.swing.JButton();
		jbEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		jSeparator1 = new javax.swing.JSeparator();
		jbTotalProjetos = new javax.swing.JButton();
		jbVereadoresAcimaMedia = new javax.swing.JButton();

		jLabel7.setText("jLabel7");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Lista 3 - Exercício 5");

		jLabel1.setText("Número:");

		jLabel2.setText("Nome:");

		jbCadastrarPartido.setText("Cadastrar");
		jbCadastrarPartido.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jbCadastrarPartido)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jtfNumPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jtfNomePartido, javax.swing.GroupLayout.PREFERRED_SIZE,
														177, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(153, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(jtfNumPartido, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jtfNomePartido,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(28, 28, 28).addComponent(jbCadastrarPartido).addContainerGap(139, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Partido", jPanel1);

		jbMenorDesempenho.setText("Vereador menor desempenho");

		jbMaisProjetos.setText("Vereador com mais proj. aprovados");

		jLabel9.setText("Número do partido:");

		jbEstatisticas.setText("Estatísticas do partido");

		jbTotalProjetos.setText("Total de projetos da Câmara");
		jbTotalProjetos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jbVereadoresAcimaMedia.setText("Vereadores acima da média");
		jbVereadoresAcimaMedia.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		JButton jbCadastrarVereador = new JButton();
		jbCadastrarVereador.setBounds(286, 50, 81, 23);
		jbCadastrarVereador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String msg;

				int num = Integer.parseInt(jtfNumPartidoVereador.getText());
				//TODO ADICIONAR VALIDAÇÃO SE É NÚMERO
				pesquisado = camara.getPartido(num);

				if (pesquisado == null) {
					msg = "Número de partido não encontrado!";
					JOptionPane.showMessageDialog(null, msg);
				} else {
					int numPartido = Integer.parseInt(jtfNumPartido.getText());
					pesquisado = camara.getPartido(numPartido);
					Vereador vereador = new Vereador(jtfNomeVereador.getText(), pesquisado);
					vereadores.add(vereador);

					jcbVereadores.addItem(vereador);
					msg = "Vereador adicionado ao partido ' " + pesquisado.getNome() + " " + pesquisado.getNumero() +  " ' com sucesso!";
					JOptionPane.showMessageDialog(null, msg);

				}	
			}
		});

		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(10, 22, 35, 14);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setBounds(10, 54, 95, 14);
		jtfNomeVereador = new javax.swing.JTextField();
		jtfNomeVereador.setBounds(49, 19, 264, 20);
		jtfNumPartidoVereador = new javax.swing.JTextField();
		jtfNumPartidoVereador.setBounds(109, 51, 35, 20);
		jtfNumPartidoVereador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

			}
		});

		jLabel3.setText("Nome: ");

		jLabel4.setText("Número do partido:");

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 84, 459, 2);

		JLabel lblLawType = new JLabel("Tipo de Lei:");
		lblLawType.setBounds(22, 107, 72, 14);
		lblLawType.setEnabled(false);

		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(22, 154, 48, 14);
		lblTitulo.setEnabled(false);

		tfTituloLei = new JTextField();
		tfTituloLei.setBounds(165, 151, 86, 20);
		tfTituloLei.setEnabled(false);
		tfTituloLei.setColumns(10);

		JLabel lblDtApres = new JLabel("Data de apresenta\u00E7\u00E3o:");
		lblDtApres.setBounds(22, 192, 131, 14);
		lblDtApres.setEnabled(false);

		tfDtApres = new JTextField();
		tfDtApres.setBounds(165, 189, 86, 20);
		tfDtApres.setEnabled(false);
		tfDtApres.setColumns(10);

		JLabel lblDtAprov = new JLabel("Data de aprova\u00E7\u00E3o");
		lblDtAprov.setBounds(22, 230, 92, 14);
		lblDtAprov.setEnabled(false);

		tfDtAprov = new JTextField();
		tfDtAprov.setBounds(165, 227, 86, 20);
		tfDtAprov.setEnabled(false);
		tfDtAprov.setColumns(10);

		JLabel lblLeiOrganica = new JLabel("Lei Org\u00E2nica:");
		lblLeiOrganica.setBounds(22, 268, 80, 14);
		lblLeiOrganica.setEnabled(false);

		tfLO = new JTextField();
		tfLO.setBounds(165, 265, 86, 20);
		tfLO.setEnabled(false);
		tfLO.setColumns(10);

		JLabel lblQtdVF = new JLabel("Qtd de votos favor\u00E1veis:");
		lblQtdVF.setBounds(22, 306, 139, 14);
		lblQtdVF.setEnabled(false);

		tfQtdVF = new JTextField();
		tfQtdVF.setBounds(165, 303, 86, 20);
		tfQtdVF.setEnabled(false);
		tfQtdVF.setColumns(10);

		JComboBox jcbProjectType = new JComboBox();
		jcbProjectType.setBounds(98, 104, 162, 20);
		jcbProjectType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbProjectType.getSelectedIndex() == 0) {
					lblTitulo.setEnabled(false);
					tfTituloLei.setEnabled(false);
					lblDtApres.setEnabled(false);
					tfDtApres.setEnabled(false);
					lblDtAprov.setEnabled(false);
					tfDtAprov.setEnabled(false);
					lblLeiOrganica.setEnabled(false);
					tfLO.setEnabled(false);
					lblQtdVF.setEnabled(false);
					tfQtdVF.setEnabled(false);
				} else if (jcbProjectType.getSelectedIndex() == 1) {
					lblTitulo.setEnabled(true);
					tfTituloLei.setEnabled(true);
					lblDtApres.setEnabled(true);
					tfDtApres.setEnabled(true);
					lblDtAprov.setEnabled(true);
					tfDtAprov.setEnabled(true);
					lblLeiOrganica.setEnabled(false);
					tfLO.setEnabled(false);
					lblQtdVF.setEnabled(false);
					tfQtdVF.setEnabled(false);
				} else {
					tfTituloLei.setEnabled(true);
					tfDtApres.setEnabled(true);
					tfDtAprov.setEnabled(true);
					lblLeiOrganica.setEnabled(true);
					tfLO.setEnabled(true);
					lblQtdVF.setEnabled(true);
					tfQtdVF.setEnabled(true);
				}
			}
		});
		jcbProjectType.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione", "Projeto de Lei", "Projeto de Lei Complementar" }));

		JButton btnInserir = new JButton();
		btnInserir.setBounds(286, 353, 81, 23);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				Vereador vereador = (Vereador) jcbVereadores.getSelectedItem();
				
				if (jcbProjectType.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um tipo de lei");
				} else if (jcbProjectType.getSelectedIndex() == 1) {
					
					LocalDate dtApres = null;
					LocalDate dtAprov = null;
					try {
						dtApres = LocalDate.parse(tfDtApres.getText(), formatter);
						dtAprov = LocalDate.parse(tfDtAprov.getText(), formatter);
					} catch (Exception e2) {}
					
					ProjetoDeLei projetoDeLei = new ProjetoDeLei();
					projetoDeLei.setTitulo(tfTituloLei.getText());
					// Falta aqui!!!
					projetoDeLei.setNumeroProjeto(Integer.parseInt(tfNumeroProjeto.getText()));
					
					if(dtApres != null) {
						projetoDeLei.setDataApresentacao(dtApres);
						vereador.setQtdProjApres(1);
					}
					if(dtAprov != null)
					{
						projetoDeLei.setDataAprovacao(dtAprov);
						vereador.setQtdProjAprov(1);
					}
					projetoDeLei.setVereador((Vereador) jcbVereadores.getSelectedItem());
					projetos.add(projetoDeLei);
					msg = "Projeto de Lei cadastrado com grande sucesso!";
					JOptionPane.showMessageDialog(null, msg);

				} else {
					LocalDate dtApres = null;
					LocalDate dtAprov = null;
					try {
						dtApres = LocalDate.parse(tfDtApres.getText(), formatter);
						dtAprov = LocalDate.parse(tfDtAprov.getText(), formatter);
					} catch (Exception e2) {}
					
					int qtdVF = Integer.parseInt(tfQtdVF.getText());
					ProjetoDeLeiComplementar projetoDeLeiComplementar = new ProjetoDeLeiComplementar();
					projetoDeLeiComplementar.setTitulo(tfTituloLei.getText());

					if(dtApres != null) {
						projetoDeLeiComplementar.setDataApresentacao(dtApres);
						vereador.setQtdProjApres(1);
					}
					if(dtAprov != null) {
						projetoDeLeiComplementar.setDataAprovacao(dtAprov);
						vereador.setQtdProjAprov(1);
					}
					
					projetoDeLeiComplementar.setArtigoLO(tfLO.getText());
					projetoDeLeiComplementar.setQtdVotosFavoraveis(qtdVF);
					projetoDeLeiComplementar.setVereador((Vereador) jcbVereadores.getSelectedItem());
					projetos.add(projetoDeLeiComplementar);
					msg = "Projeto de Lei Complementar cadastrado";
					JOptionPane.showMessageDialog(null, msg);

				}
			}
		});
		btnInserir.setText("Inserir");

		jbCadastrarVereador.setText("Cadastrar");

		jTabbedPane1.addTab("Vereador", jPanel2);
		jPanel2.setLayout(null);
		jPanel2.add(jLabel3);
		jPanel2.add(jtfNomeVereador);
		jPanel2.add(lblLawType);
		jPanel2.add(jcbProjectType);
		jPanel2.add(lblTitulo);
		jPanel2.add(tfTituloLei);
		jPanel2.add(lblDtApres);
		jPanel2.add(tfDtApres);
		jPanel2.add(lblDtAprov);
		jPanel2.add(tfDtAprov);
		jPanel2.add(lblLeiOrganica);
		jPanel2.add(tfLO);
		jPanel2.add(lblQtdVF);
		jPanel2.add(tfQtdVF);
		jPanel2.add(jLabel4);
		jPanel2.add(jtfNumPartidoVereador);
		jPanel2.add(jbCadastrarVereador);
		jPanel2.add(separator);
		jPanel2.add(btnInserir);

		jcbVereadores = new JComboBox();
		jcbVereadores.setBounds(130, 353, 72, 22);
		jPanel2.add(jcbVereadores);

		lblNewLabel = new JLabel("Vereador autoral");
		lblNewLabel.setBounds(22, 362, 101, 14);
		jPanel2.add(lblNewLabel);
		
		JLabel lblNumeroProjeto = new JLabel("N\u00FAmero Projeto:");
		lblNumeroProjeto.setEnabled(false);
		lblNumeroProjeto.setBounds(14, 331, 139, 14);
		jPanel2.add(lblNumeroProjeto);
		
		tfNumeroProjeto = new JTextField();
		tfNumeroProjeto.setEnabled(false);
		tfNumeroProjeto.setColumns(10);
		tfNumeroProjeto.setBounds(165, 328, 86, 20);
		jPanel2.add(tfNumeroProjeto);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Vereador vereador : vereadores) {
					String msg = "Nome do Vereador: " + vereador.getNome() + " \n" + "Partido: " + vereador.getPartido().getNome() + "\n" + 
							"Desempenho: " + vereador.calcularDesempenho();
					
					JOptionPane.showMessageDialog(null, msg);
					
				}
				
				for(ProjetoDeLei projeto : projetos) {
					String msg = projeto.mostrar();
					JOptionPane.showMessageDialog(null, msg);
				}

			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout
				.createSequentialGroup()
				.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout
						.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel9)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 52,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(jbEstatisticas))))
						.addComponent(jbMenorDesempenho).addComponent(jbMaisProjetos).addComponent(jbTotalProjetos)
						.addComponent(jbVereadoresAcimaMedia)
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(141).addComponent(btnConsultar)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel9)
								.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jbEstatisticas))
						.addGap(13)
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jbMenorDesempenho).addGap(18)
						.addComponent(jbMaisProjetos).addGap(18).addComponent(jbTotalProjetos).addGap(18)
						.addComponent(jbVereadoresAcimaMedia).addGap(63).addComponent(btnConsultar)
						.addContainerGap(81, Short.MAX_VALUE)));
		jPanel3.setLayout(jPanel3Layout);

		jTabbedPane1.addTab("Consultas", jPanel3);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup().addContainerGap().addComponent(jTabbedPane1,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap().addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		int numeroPartido = Integer.parseInt(jtfNumPartido.getText());
		Partido partido = new Partido(jtfNomePartido.getText(), numeroPartido);
		String msg = "Novo partido cadastrado com sucesso.";

		try {
			Partido partidoExistente = camara.getPartido(numeroPartido);
			 
			if(!(numeroPartido>=10 && numeroPartido < 100)) {
				msg = "Número inválido! Tente novamente.";
			}
			else if(partidoExistente != null) {
				msg = "Este número de partido já está cadastrado!";
			}
			else{
				camara.addPartido(partido);
			}
		} catch (Exception e) {
			msg = "Erro! Não é possível cadastrar o número de partido informado!";
		}
		
		JOptionPane.showMessageDialog(this, msg);
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		String msg = "CÂMARA\n\nTotal de projetos apresentados: " + camara.getTotalProjApres()
				+ "\nTotal de projetos aprovados:" + camara.getTotalProjAprov();
		JOptionPane.showMessageDialog(this, msg);
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		String msg = "Vereadores acima da média:" + camara.getMediaDesempenho();
		ArrayList<Vereador> lista = camara.getVereadoresAcimaMedia();
		for (Vereador v : lista) {
			msg += "\nVereador " + v.getNome() + " do partido " + v.getPartido().getNome();
		}
		JOptionPane.showMessageDialog(this, msg);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Apresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Apresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Apresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Apresentacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Apresentacao().setVisible(true);
			}
		});
	}

	// Variables declaration
	private javax.swing.JButton jbCadastrarPartido;
	private javax.swing.JButton jbMenorDesempenho;
	private javax.swing.JButton jbMaisProjetos;
	private javax.swing.JButton jbEstatisticas;
	private javax.swing.JButton jbTotalProjetos;
	private javax.swing.JButton jbVereadoresAcimaMedia;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private JLabel jlNomePartido;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTextField jtfNumPartido;
	private javax.swing.JTextField jtfNomePartido;
	private javax.swing.JTextField jtfNomeVereador;
	private javax.swing.JTextField jtfNumPartidoVereador;
	private javax.swing.JTextField jTextField7;
	private JTextField tfTituloLei;
	private JTextField tfDtApres;
	private JTextField tfDtAprov;
	private JTextField tfLO;
	private JTextField tfQtdVF;
	private JComboBox jcbVereadores;
	private JLabel lblNewLabel;
	private JButton btnConsultar;
	private JTextField tfNumeroProjeto;
}
