package pantalla;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;


public class Pantall {
	private String especie, visita, habitual;
	private double plus, base, iva, total;
	private int pes, percentatge;

	private JFrame frmVeterinari;
	private JTextField txtPes;
	private JTextField txtPlus;
	private JTextField txtBase;
	private JTextField txtIva;
	private JTextField txtTotal;
	private JTextField txtError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Pantall window = new Pantall();
					window.frmVeterinari.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantall() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVeterinari = new JFrame();
		frmVeterinari.setTitle("Veterinari");
		frmVeterinari.setResizable(false);
		frmVeterinari.setBounds(100, 100, 370, 570);
		frmVeterinari.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel dadesAnimal = new JPanel();
		dadesAnimal.setBorder(new TitledBorder(new LineBorder(new Color(160, 160, 160), 1, true), "Dades Animal", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowText));
		
		JPanel dadesVisita = new JPanel();
		dadesVisita.setBorder(new TitledBorder(new LineBorder(new Color(160, 160, 160), 1, true), "Dades Visita", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowText));
		
		JPanel preusErrors = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmVeterinari.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(preusErrors, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(dadesVisita, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(dadesAnimal, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 332, Short.MAX_VALUE))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(dadesAnimal, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dadesVisita, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(preusErrors, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		
		JLabel lblTipusVis = new JLabel("Tipus Visita");
		lblTipusVis.setBounds(39, 46, 53, 14);
		
		JComboBox cmbVisita = new JComboBox();
		cmbVisita.setEditable(true);
		cmbVisita.setEnabled(false);
		cmbVisita.setBounds(122, 43, 138, 20);
		cmbVisita.setModel(new DefaultComboBoxModel(new String[] {"Anual", "Vacuna", "Urgència", "Hospitalització"}));
		
		JLabel lblClientHab = new JLabel("Client Habitual");
		lblClientHab.setBounds(39, 84, 69, 14);
		
		JComboBox cmbClientHab = new JComboBox();
		cmbClientHab.setEditable(true);
		cmbClientHab.setEnabled(false);
		cmbClientHab.setBounds(122, 81, 54, 20);
		cmbClientHab.setModel(new DefaultComboBoxModel(new String[] {"Sí", "No", "VIP"}));
		
		JLabel lblPlus = new JLabel("Plus");
		lblPlus.setBounds(39, 119, 19, 14);
		
		txtPlus = new JTextField();
		txtPlus.setToolTipText("altres càrrecs com pinso, joguines...");
		txtPlus.setEnabled(false);
		txtPlus.setBounds(76, 116, 86, 20);
		txtPlus.setColumns(10);
		
		JLabel lblEVisita = new JLabel("€");
		lblEVisita.setBounds(170, 119, 6, 14);
		
		JButton btnEsborrar = new JButton("ESBORRAR TOT");

		btnEsborrar.setEnabled(false);
		btnEsborrar.setBounds(39, 166, 109, 23);
		
		JButton btnCalcular = new JButton("CALCULAR");

		btnCalcular.setEnabled(false);
		btnCalcular.setBounds(217, 166, 85, 23);
		dadesVisita.setLayout(null);
		dadesVisita.add(btnEsborrar);
		dadesVisita.add(btnCalcular);
		dadesVisita.add(lblPlus);
		dadesVisita.add(txtPlus);
		dadesVisita.add(lblEVisita);
		dadesVisita.add(lblClientHab);
		dadesVisita.add(cmbClientHab);
		dadesVisita.add(lblTipusVis);
		dadesVisita.add(cmbVisita);
		
		JLabel lblEspecie = new JLabel("Espècie");
		
		JComboBox cmbEspecie = new JComboBox();
		cmbEspecie.setModel(new DefaultComboBoxModel(new String[] {"gos", "gat", "mascota"}));
		
		JLabel lblPes = new JLabel("Pes");
		
		txtPes = new JTextField();
		txtPes.setToolTipText("pes del animal en kg Exemple: 10.5 ");
		txtPes.setColumns(10);
		
		JLabel lblKg = new JLabel("Kg");
		
		JButton btnValidar = new JButton("VALIDAR");

		btnValidar.setBackground(UIManager.getColor("Button.background"));
		btnValidar.setForeground(new Color(0, 0, 0));
		btnValidar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_dadesAnimal = new GroupLayout(dadesAnimal);
		gl_dadesAnimal.setHorizontalGroup(
			gl_dadesAnimal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dadesAnimal.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addGroup(gl_dadesAnimal.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEspecie)
						.addComponent(lblPes))
					.addGroup(gl_dadesAnimal.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dadesAnimal.createSequentialGroup()
							.addGap(4)
							.addComponent(txtPes, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblKg)
							.addGap(33)
							.addComponent(btnValidar))
						.addGroup(gl_dadesAnimal.createSequentialGroup()
							.addGap(18)
							.addComponent(cmbEspecie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(86))
		);
		gl_dadesAnimal.setVerticalGroup(
			gl_dadesAnimal.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dadesAnimal.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dadesAnimal.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEspecie)
						.addComponent(cmbEspecie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_dadesAnimal.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKg)
						.addComponent(btnValidar)
						.addComponent(lblPes))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		dadesAnimal.setLayout(gl_dadesAnimal);
		
		JPanel preus = new JPanel();
		preus.setBorder(new TitledBorder(new LineBorder(new Color(160, 160, 160), 1, true), "PREUS", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowText));
		
		JPanel errors = new JPanel();
		errors.setBorder(new TitledBorder(new LineBorder(new Color(160, 160, 160), 1, true), "Errors i Aletres", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowText));
		GroupLayout gl_preusErrors = new GroupLayout(preusErrors);
		gl_preusErrors.setHorizontalGroup(
			gl_preusErrors.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_preusErrors.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_preusErrors.createParallelGroup(Alignment.TRAILING)
						.addComponent(errors, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(preus, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_preusErrors.setVerticalGroup(
			gl_preusErrors.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_preusErrors.createSequentialGroup()
					.addComponent(preus, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(errors, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
		);
		errors.setLayout(null);
		
		txtError = new JTextField();
		txtError.setEditable(false);
		txtError.setBounds(10, 22, 315, 28);
		errors.add(txtError);
		txtError.setColumns(10);
		preus.setLayout(null);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setBounds(35, 35, 46, 14);
		preus.add(lblBase);
		
		JLabel lblIva = new JLabel("IVA");
		lblIva.setBounds(130, 35, 46, 14);
		preus.add(lblIva);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(219, 35, 46, 14);
		preus.add(lblTotal);
		
		txtBase = new JTextField();
		txtBase.setEditable(false);
		txtBase.setBounds(20, 54, 61, 20);
		preus.add(txtBase);
		txtBase.setColumns(10);
		
		txtIva = new JTextField();
		txtIva.setEditable(false);
		txtIva.setBounds(110, 54, 61, 20);
		preus.add(txtIva);
		txtIva.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(198, 54, 86, 20);
		preus.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblEBase = new JLabel("€");
		lblEBase.setBounds(87, 57, 13, 14);
		preus.add(lblEBase);
		
		JLabel lblEBase_1 = new JLabel("€");
		lblEBase_1.setBounds(175, 57, 13, 14);
		preus.add(lblEBase_1);
		
		JLabel lblEBase_2 = new JLabel("€");
		lblEBase_2.setBounds(290, 57, 13, 14);
		preus.add(lblEBase_2);
		preusErrors.setLayout(gl_preusErrors);
		frmVeterinari.getContentPane().setLayout(groupLayout);
		
		
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtError.setText("");
					especie = (String) cmbEspecie.getSelectedItem();
					pes = Integer.parseInt(txtPes.getText());
					if(pes>=0) {
						if((pes==0) && ((especie.equals("gat") || especie.equals("gos")))){
							txtPes.requestFocus();
							txtPes.selectAll();
							txtError.setText("dada invalida - pes invalid per gat o gos");
						}else {
							txtPes.setEnabled(false);
							cmbEspecie.setEnabled(false);
							btnValidar.setEnabled(false);
						
							
							txtPlus.setEnabled(true);
							cmbVisita.setEnabled(true);
							cmbClientHab.setEnabled(true);
							btnEsborrar.setEnabled(true);
							btnCalcular.setEnabled(true);
						}
					}else {
						txtPes.requestFocus();
						txtPes.selectAll();
						txtError.setText("dada invalida - pes negatiu");
					}
				}catch(Exception ex) {
					txtPes.requestFocus();
					txtPes.selectAll();
					txtError.setText("dada invalida - no int");
				}
				
			}
			
		});
		
		btnEsborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPes.setText("");
				txtPlus.setText("");
				txtBase.setText("");
				txtIva.setText("");
				txtTotal.setText("");
				txtError.setText("");
				
				txtPes.setEnabled(true);
				cmbEspecie.setEnabled(true);
				btnValidar.setEnabled(true);
			
				txtPlus.setEnabled(false);
				cmbVisita.setEnabled(false);
				cmbClientHab.setEnabled(false);
				btnEsborrar.setEnabled(false);
				btnCalcular.setEnabled(false);
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtError.setText("");
					
					visita = (String) cmbVisita.getSelectedItem();
					habitual = (String) cmbClientHab.getSelectedItem();
					plus = Double.parseDouble(txtPlus.getText());
					
					if(plus<0) {
						txtPlus.requestFocus();
						txtPlus.selectAll();
						txtError.setText("dada invalida - valor negatiu");
					}else {
						switch(visita) {
							case "Anual":
								base = 45;
								break;
							case "Vacuna":
								base = 25;
								break;
							case "Urgència":
								base = 30;
								break;
							case "Hospitalització":
								base = 60;
								break;
						}
						
						switch(especie) {
							case "mascota":
								base = base - base*0.03;
								break;
							case "gat":
								break;
							case "gos":
								if(pes>50) {
									base = base + base*0.05;
								}else if(pes>25) {
									base = base + base*0.03;
								}else if(pes>15) {
									base = base + base*0.01;
								}else if(pes<5) {
									base = base - base*0.05;
								}
								break;
						}
						
						switch(habitual) {
							case "Sí":
								base = base - base*0.03;
								break;
							case "VIP":
								base = base - base*0.05;
								break;
						}
						
						base = base + plus;
						iva = base*0.21;
						total = base + iva;
						
						txtBase.setText(String.format("%.2f", base));
						txtIva.setText(String.format("%.2f", iva));
						txtTotal.setText(String.format("%.2f", total));
					}
					
				}catch(Exception ex) {
					txtPlus.requestFocus();
					txtPlus.selectAll();
					txtError.setText("dada invalida - no double o buida");
				}
			}
		});
		
	}
}
