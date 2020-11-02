import java.util.ArrayList;
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
	private ArrayList<ProjetoDeLei> projetosFalsos = new ArrayList<>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
					msg = "Menor desempenho: " + mais.getNome() + " do partido " + mais.getPartido().getNome()
							+ " está com desempenho " + mais.calcularDesempenho();
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
		jPanel2 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jtfNomeVereador = new javax.swing.JTextField();
		jtfNumPartidoVereador = new javax.swing.JTextField();
		jtfNumPartidoVereador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				int num = Integer.parseInt(jtfNumPartidoVereador.getText());
				pesquisado = camara.getPartido(num);
				String msg;
				if (pesquisado == null) {
					msg = "Número não encontrado";
					jbCadastrarVereador.setEnabled(false); // desabilita o botão de Cadastrar pois não pode inserir um
															// Vereador sem partido
				} else {
					msg = pesquisado.getNome();
					jbCadastrarVereador.setEnabled(true); // habilita o botão
				}
				jlNomePartido.setText(msg);
			}
		});
		
				jLabel3.setText("Nome: ");
				
						jLabel4.setText("Número do partido:");
						jbCadastrarVereador = new javax.swing.JButton();
						jbCadastrarVereador.setEnabled(false);
						
								jbCadastrarVereador.setText("Cadastrar");
								jbCadastrarVereador.addActionListener(new java.awt.event.ActionListener() {
									public void actionPerformed(java.awt.event.ActionEvent evt) {
										jButton2ActionPerformed(evt);
									}
								});
								
								JSeparator separator = new JSeparator();
								
								JLabel lblLawType = new JLabel("Tipo de Lei:");
								lblLawType.setEnabled(false);
								
								JLabel lblTitulo = new JLabel("T\u00EDtulo:");
								lblTitulo.setEnabled(false);
								
								tfTituloLei = new JTextField();
								tfTituloLei.setEnabled(false);
								tfTituloLei.setColumns(10);
								
								JLabel lblDtApres = new JLabel("Data de apresenta\u00E7\u00E3o:");
								lblDtApres.setEnabled(false);
								
								tfDtApres = new JTextField();
								tfDtApres.setEnabled(false);
								tfDtApres.setColumns(10);
								
								JLabel lblDtAprov = new JLabel("Data de aprova\u00E7\u00E3o");
								lblDtAprov.setEnabled(false);
								
								tfDtAprov = new JTextField();
								tfDtAprov.setEnabled(false);
								tfDtAprov.setColumns(10);
								
								JLabel lblLeiOrganica = new JLabel("Lei Org\u00E2nica:");
								lblLeiOrganica.setEnabled(false);
								
								tfLO = new JTextField();
								tfLO.setEnabled(false);
								tfLO.setColumns(10);
								
								JLabel lblQtdVF = new JLabel("Qtd de votos favor\u00E1veis:");
								lblQtdVF.setEnabled(false);
								
								tfQtdVF = new JTextField();
								tfQtdVF.setEnabled(false);
								tfQtdVF.setColumns(10);
								
								JComboBox jcbProjectType = new JComboBox();
								jcbProjectType.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										if (jcbProjectType.getSelectedIndex() == 0){
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
										} else{
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
								jcbProjectType.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Projeto de Lei", "Projeto de Lei Complementar"}));
								
								JButton btnInserir = new JButton();
								btnInserir.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										if (jcbProjectType.getSelectedIndex() == 0) {
											JOptionPane.showMessageDialog(null, "Selecione um tipo de lei");
										} else if (jcbProjectType.getSelectedIndex() == 1) {
											LocalDate dtApres = LocalDate.parse(tfDtApres.getText(), formatter);
											LocalDate dtAprov = LocalDate.parse(tfDtAprov.getText(), formatter);
											ProjetoDeLei projetoDeLei = new ProjetoDeLei();
											projetoDeLei.setTitulo(tfTituloLei.getText());
											projetoDeLei.setDataApresentacao(dtApres);
											projetoDeLei.setDataApresentacao(dtAprov);
											projetosFalsos.add(projetoDeLei);
										} else {
											LocalDate dtApres = LocalDate.parse(tfDtApres.getText(), formatter);
											LocalDate dtAprov = LocalDate.parse(tfDtAprov.getText(), formatter);
											int qtdVF = Integer.parseInt(tfQtdVF.getText());
											ProjetoDeLeiComplementar projetoDeLeiComplementar = new ProjetoDeLeiComplementar();
											projetoDeLeiComplementar.setTitulo(tfTituloLei.getText());
											projetoDeLeiComplementar.setDataApresentacao(dtApres);
											projetoDeLeiComplementar.setDataApresentacao(dtAprov);
											projetoDeLeiComplementar.setArtigoLO(tfLO.getText());
											projetoDeLeiComplementar.setQtdVotosFavoraveis(qtdVF);
											projetosFalsos.add(projetoDeLeiComplementar);
										}
									}
								});
								btnInserir.setText("Inserir");
								
										javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
										jPanel2Layout.setHorizontalGroup(
											jPanel2Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel2Layout.createSequentialGroup()
													.addContainerGap()
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel2Layout.createSequentialGroup()
															.addComponent(jLabel3)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(jtfNomeVereador, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
														.addGroup(jPanel2Layout.createSequentialGroup()
															.addComponent(jLabel4)
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(jtfNumPartidoVereador, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
														.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
															.addComponent(separator, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
															.addGroup(jPanel2Layout.createSequentialGroup()
																.addGap(12)
																.addComponent(lblLawType, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
																.addGap(4)
																.addComponent(jcbProjectType, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
															.addGroup(jPanel2Layout.createSequentialGroup()
																.addGap(12)
																.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
																.addGap(95)
																.addComponent(tfTituloLei, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
															.addGroup(jPanel2Layout.createSequentialGroup()
																.addGap(12)
																.addComponent(lblDtApres, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
																.addGap(12)
																.addComponent(tfDtApres, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
															.addGroup(jPanel2Layout.createSequentialGroup()
																.addGap(12)
																.addComponent(lblDtAprov, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																.addGap(51)
																.addComponent(tfDtAprov, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
															.addGroup(jPanel2Layout.createSequentialGroup()
																.addGap(12)
																.addComponent(lblLeiOrganica, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
																.addGap(63)
																.addComponent(tfLO, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
															.addGroup(jPanel2Layout.createSequentialGroup()
																.addGap(12)
																.addComponent(lblQtdVF, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
																.addGap(4)
																.addComponent(tfQtdVF, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))))
													.addContainerGap(97, Short.MAX_VALUE))
												.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
													.addContainerGap(331, Short.MAX_VALUE)
													.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(jbCadastrarVereador)
													.addGap(67))
										);
										jPanel2Layout.setVerticalGroup(
											jPanel2Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel2Layout.createSequentialGroup()
													.addGap(19)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(jtfNomeVereador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(jtfNumPartidoVereador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel2Layout.createSequentialGroup()
															.addGap(3)
															.addComponent(lblLawType))
														.addComponent(jcbProjectType, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
													.addGap(27)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel2Layout.createSequentialGroup()
															.addGap(3)
															.addComponent(lblTitulo))
														.addComponent(tfTituloLei, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel2Layout.createSequentialGroup()
															.addGap(3)
															.addComponent(lblDtApres))
														.addComponent(tfDtApres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel2Layout.createSequentialGroup()
															.addGap(3)
															.addComponent(lblDtAprov))
														.addComponent(tfDtAprov, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel2Layout.createSequentialGroup()
															.addGap(3)
															.addComponent(lblLeiOrganica))
														.addComponent(tfLO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGap(18)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel2Layout.createSequentialGroup()
															.addGap(3)
															.addComponent(lblQtdVF))
														.addComponent(tfQtdVF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addGap(30)
													.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnInserir)
														.addComponent(jbCadastrarVereador))
													.addContainerGap())
										);
										jPanel2.setLayout(jPanel2Layout);
										
												jTabbedPane1.addTab("Vereador", jPanel2);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jSeparator1)
								.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel9)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(jbEstatisticas)
										.addGap(0, 41, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jbMenorDesempenho).addComponent(jbMaisProjetos)
								.addComponent(jbTotalProjetos).addComponent(jbVereadoresAcimaMedia))
						.addGap(0, 0, Short.MAX_VALUE)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9)
								.addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbEstatisticas)).addGap(13, 13, 13)
								.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jbMenorDesempenho).addGap(18, 18, 18).addComponent(jbMaisProjetos)
								.addGap(18, 18, 18).addComponent(jbTotalProjetos).addGap(18, 18, 18)
								.addComponent(jbVereadoresAcimaMedia).addContainerGap(45, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Consultas", jPanel3);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		Partido partido = new Partido(jtfNomePartido.getText(), Integer.parseInt(jtfNumPartido.getText()));
		camara.addPartido(partido);
		String msg = "Novo partido cadastrado.";
		
		JOptionPane.showMessageDialog(this, msg);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		Vereador vereador = new Vereador(jtfNomeVereador.getText(), pesquisado);
		String msg = "Vereador " + vereador.getNome() + " do partido " + vereador.getPartido().getNome()
				+ " está com desempenho " + vereador.calcularDesempenho();
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
			msg += "\nVereador " + v.getNome() + " do partido " + v.getPartido().getNome() + " com desempenho "
					+ v.calcularDesempenho();
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
	private javax.swing.JButton jbCadastrarVereador;
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
}
