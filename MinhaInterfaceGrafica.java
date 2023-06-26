import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.filechooser.FileFilter.*;



import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaInterfaceGrafica  {
	 JFrame frame1;
	 JFrame frame2;
	 JFrame frame3; 
	 JFrame frame4;
	 JFrame frame5;
    
    MinhaInterfaceGrafica(){
    	frame1 = new JFrame();
        frame2 = new JFrame();
        frame3 = new JFrame();
        frame4 = new JFrame();
        frame5 = new JFrame();
        
        JLabel txt = new JLabel("");
        
        
        frame1.getContentPane().add(txt);
        
        frame1.setTitle("Hospital Hub");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        frame1.setSize(300, 1000);
        JLabel label1 = new JLabel("Ultimo paciente que tomou banho:");
        JMenuBar menuBar = new JMenuBar();
        frame1.setJMenuBar(menuBar);
        frame1.getContentPane().setLayout(new FlowLayout());
        
        JMenu menuArquivo = new JMenu("Cadastrar Paciente");
        JMenu menuArquivo2 = new JMenu("Area do paciente");
        JMenu menuArquivo3 = new JMenu("Ler arquivo");
        
        JMenuItem itemCAdPaciente_SUS = new JMenuItem("Paciente SUS");
        itemCAdPaciente_SUS.addActionListener(new Troca_frame2());
        menuArquivo.add(itemCAdPaciente_SUS);

        JMenuItem texto = new JMenuItem("Ler Txt");
        texto.addActionListener(new Ler_arquivo());
        menuArquivo3.add(texto);
        
        
        JMenuItem itemCAdPaciente_Particular = new JMenuItem("Paciente particular");
        itemCAdPaciente_Particular.addActionListener(new Troca_frame4());
        menuArquivo.add(itemCAdPaciente_Particular);
        
        JMenuItem itemAtestado = new JMenuItem("Pegar atestado");
        itemAtestado.addActionListener(new Troca_frame5());
        menuArquivo2.add(itemAtestado);
        
        JMenuItem itemExame = new JMenuItem("Pegar exames");
        itemExame.addActionListener(new Troca_frame5());
        menuArquivo2.add(itemExame);
        
        JMenuItem itemLaudo = new JMenuItem("Pegar laudos");
        itemLaudo.addActionListener(new Troca_frame5());
        menuArquivo2.add(itemLaudo);
    
        menuBar.add(menuArquivo);
        menuBar.add(menuArquivo2);
        menuBar.add(menuArquivo3);
        menuBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frame1.getContentPane().add(label1);
        frame3.setVisible(false);
        frame1.setVisible(true);
        
        frame2.setTitle("Paciente INFO");
        frame2.setSize(350, 350);

  
        
        // Criação de botoes
        JButton button = new JButton("sair");
        JButton button2 = new JButton("Enviar");

        
        button.addActionListener(new Troca_frame2());

        frame2.setVisible(false);
        
        
//textfields e labels
        JLabel label = new JLabel("Nome:");
        JTextField textField = new JTextField(23);
        JLabel label2 = new JLabel("Idade:");
        JTextField textField2 = new JTextField(23);
        JLabel label3 = new JLabel("Remedios evitados:");
        JTextField textField3 = new JTextField(16);
        JLabel label4 = new JLabel("Nivel de dor:");
        JTextField textField4 = new JTextField(19);
        JLabel label5 = new JLabel("Especiaidade do medico:");
        JTextField textField5 = new JTextField(11);
        JLabel label6 = new JLabel("Gravidade:");
        JTextField textField6 = new JTextField(20);
        JLabel label7 = new JLabel("CPF:");
        JTextField textField7 = new JTextField(24);
        JLabel label8 = new JLabel("Exames evitados:");
        JTextField textField8 = new JTextField(16);
        JLabel label9 = new JLabel("Numero do SUS:");
        JTextField textField9 = new JTextField(17);
        button2.addActionListener(new Enter_SUS(textField, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9));
        
       
        
        // Criação do layout
        SpringLayout layout = new SpringLayout();
 
        JPanel panel = new JPanel(layout);
     
        
        layout.putConstraint(SpringLayout.NORTH, label9, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, textField9, 6, SpringLayout.EAST, label9);
        layout.putConstraint(SpringLayout.WEST, label9, 0, SpringLayout.WEST, label);
        layout.putConstraint(SpringLayout.NORTH, textField9, 9, SpringLayout.SOUTH, textField8);
        layout.putConstraint(SpringLayout.NORTH, button2, 0, SpringLayout.NORTH, button);
        layout.putConstraint(SpringLayout.EAST, button2, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, label6);
        layout.putConstraint(SpringLayout.WEST, textField7, 6, SpringLayout.EAST, label7);
        layout.putConstraint(SpringLayout.NORTH, textField8, -2, SpringLayout.NORTH, label8);
        layout.putConstraint(SpringLayout.EAST, textField8, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.NORTH, textField7, -2, SpringLayout.NORTH, label7);
        layout.putConstraint(SpringLayout.EAST, textField7, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.NORTH, textField6, -2, SpringLayout.NORTH, label6);
        layout.putConstraint(SpringLayout.EAST, textField6, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.NORTH, textField5, 0, SpringLayout.NORTH, label5);
        layout.putConstraint(SpringLayout.EAST, textField5, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.NORTH, textField4, -2, SpringLayout.NORTH, label4);
        layout.putConstraint(SpringLayout.WEST, textField4, 54, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.EAST, textField4, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.EAST, textField3, 0, SpringLayout.EAST, textField); 
       // layout.putConstraint(SpringLayout.EAST, textField9, -18, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, panel);
        frame2.setContentPane(panel);
        
  
       
        
        
        
        
        // Adicionando os componentes ao painel com o layout SpringLayout
        panel.add(label);
        panel.add(textField);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);
        panel.add(label8);
        panel.add(textField8);
        panel.add(label9);
        panel.add(textField9);
        panel.add(button);
        panel.add(button2);
        
        
       

        // Configurações de posicionamento dos componentes
        layout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label2, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label2, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textField2, 10, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField2, 40, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label3, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label3, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textField3, 105, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField3, 70, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label4, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label4, 100, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label5, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label5, 130, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label6, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label6, 160, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label7, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label7, 190, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label8, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label8, 220, SpringLayout.NORTH, panel);
        
        
        frame2.setVisible(false);
        
        frame4.setTitle("Paciente INFO");
        frame4.setSize(354, 402);
  

        JButton button_ = new JButton("sair");
        JButton button2_ = new JButton("Enviar");

        button_.addActionListener(new Troca_frame4());
        

        
      
        JLabel label_ = new JLabel("Nome:");
        JTextField textField_ = new JTextField(23);
        JLabel label2_ = new JLabel("Idade:");
        JTextField textField2_ = new JTextField(23);
        JLabel label3_ = new JLabel("Remedios evitados:");
        JTextField textField3_ = new JTextField(16);
        JLabel label4_ = new JLabel("Nivel de dor:");
        JTextField textField4_ = new JTextField(19);
        JLabel label5_ = new JLabel("Especiaidade do medico:");
        JTextField textField5_ = new JTextField(11);
        JLabel label6_ = new JLabel("Gravidade:");
        JTextField textField6_ = new JTextField(20);
        JLabel label7_ = new JLabel("CPF:");
        JTextField textField7_ = new JTextField(24);
        JLabel label8_ = new JLabel("Exames evitados:");
        JTextField textField8_ = new JTextField(16);
        JLabel label10_ = new JLabel("Convenio:");
        JTextField textField10_ = new JTextField(16);
        JLabel label11_ = new JLabel("ID do convenio:");
        JTextField textField11_ = new JTextField(16);
        
        // Criação do layout
        SpringLayout layout2 = new SpringLayout();
        layout2.putConstraint(SpringLayout.NORTH, textField3_, -2, SpringLayout.NORTH, label3_);
        layout2.putConstraint(SpringLayout.WEST, textField3_, 13, SpringLayout.EAST, label3_);
        layout2.putConstraint(SpringLayout.EAST, textField3_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.NORTH, button_, 0, SpringLayout.NORTH, button2_);
        layout2.putConstraint(SpringLayout.EAST, button_, 0, SpringLayout.EAST, label10_);
        layout2.putConstraint(SpringLayout.NORTH, button2_, 16, SpringLayout.SOUTH, textField11_);
        layout2.putConstraint(SpringLayout.EAST, textField11_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.NORTH, label5_, 11, SpringLayout.SOUTH, textField4_);
        layout2.putConstraint(SpringLayout.EAST, textField4_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.NORTH, label3_, 11, SpringLayout.SOUTH, textField2_);
        layout2.putConstraint(SpringLayout.EAST, textField2_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.WEST, textField11_, 6, SpringLayout.EAST, label11_);
        layout2.putConstraint(SpringLayout.NORTH, textField11_, -2, SpringLayout.NORTH, label11_);
        layout2.putConstraint(SpringLayout.WEST, label11_, 0, SpringLayout.WEST, label_);
        layout2.putConstraint(SpringLayout.NORTH, textField10_, 15, SpringLayout.SOUTH, textField7_);
        layout2.putConstraint(SpringLayout.NORTH, textField8_, -2, SpringLayout.NORTH, label8_);
        layout2.putConstraint(SpringLayout.EAST, textField8_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.NORTH, label8_, 15, SpringLayout.SOUTH, textField10_);
        layout2.putConstraint(SpringLayout.WEST, label8_, 0, SpringLayout.WEST, label_);
        layout2.putConstraint(SpringLayout.NORTH, label10_, 2, SpringLayout.NORTH, textField10_);
        layout2.putConstraint(SpringLayout.WEST, label10_, 0, SpringLayout.WEST, label_);
        layout2.putConstraint(SpringLayout.EAST, textField10_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.WEST, textField4_, 25, SpringLayout.EAST, label4_);
        layout2.putConstraint(SpringLayout.NORTH, textField5_, -2, SpringLayout.NORTH, label5_);
        layout2.putConstraint(SpringLayout.EAST, textField5_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.NORTH, textField4_, 0, SpringLayout.NORTH, label4_);
        layout2.putConstraint(SpringLayout.NORTH, textField7_, -2, SpringLayout.NORTH, label7_);
        layout2.putConstraint(SpringLayout.WEST, textField7_, 0, SpringLayout.WEST, textField_);
        layout2.putConstraint(SpringLayout.EAST, textField7_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.WEST, textField6_, 11, SpringLayout.EAST, label6_);
        layout2.putConstraint(SpringLayout.WEST, textField2_, 10, SpringLayout.EAST, label2_);
        layout2.putConstraint(SpringLayout.NORTH, label7_, 10, SpringLayout.SOUTH, label6_);
        layout2.putConstraint(SpringLayout.WEST, label7_, 0, SpringLayout.WEST, label_);
        layout2.putConstraint(SpringLayout.NORTH, textField6_, -2, SpringLayout.NORTH, label6_);
        layout2.putConstraint(SpringLayout.NORTH, label6_, 6, SpringLayout.SOUTH, label5_);
        layout2.putConstraint(SpringLayout.WEST, label5_, 0, SpringLayout.WEST, label_);
        layout2.putConstraint(SpringLayout.NORTH, label4_, 6, SpringLayout.SOUTH, label3_);
        layout2.putConstraint(SpringLayout.WEST, label4_, 0, SpringLayout.WEST, label_);
        layout2.putConstraint(SpringLayout.WEST, label3_, 0, SpringLayout.WEST, label_);
        layout2.putConstraint(SpringLayout.NORTH, textField2_, -2, SpringLayout.NORTH, label2_);
        layout2.putConstraint(SpringLayout.NORTH, label2_, 38, SpringLayout.SOUTH, label_);
        layout2.putConstraint(SpringLayout.NORTH, textField_, -2, SpringLayout.NORTH, label_);
        layout2.putConstraint(SpringLayout.WEST, textField_, 6, SpringLayout.EAST, label_);
        JPanel panel2 = new JPanel(layout2);
        layout2.putConstraint(SpringLayout.EAST, button2_, -23, SpringLayout.EAST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label11_, 292, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.WEST, textField10_, 86, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label_, 10, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.WEST, label_, 0, SpringLayout.WEST, panel2);
        
      
        
  
        frame4.setContentPane(panel2); 
        
        
        panel2.add(label_);
        panel2.add(textField_);
        panel2.add(label2_);
        panel2.add(textField2_);
        panel2.add(label3_);
        panel2.add(textField3_);
        panel2.add(label4_);
        panel2.add(textField4_);
        panel2.add(label5_);
        panel2.add(textField5_);
        panel2.add(label6_);
        panel2.add(textField6_);
        panel2.add(label7_);
        panel2.add(textField7_);
        panel2.add(label8_);
        panel2.add(textField8_);
        panel2.add(label10_);
        panel2.add(textField10_);
        panel2.add(label11_);
        panel2.add(textField11_);
        panel2.add(button_);
        panel2.add(button2_);
        

        
        layout2.putConstraint(SpringLayout.WEST, label_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label_, 10, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.WEST, textField_, 10, SpringLayout.EAST, label_);
        layout2.putConstraint(SpringLayout.NORTH, textField_, 10, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label2_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label2_, 40, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.NORTH, textField2_, 40, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label3_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label3_, 70, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label4_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label4_, 100, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label5_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label5_, 130, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label6_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label6_, 160, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label7_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label7_, 190, SpringLayout.NORTH, panel2);
        
        button2_.addActionListener(new Enter_Particular(textField_, textField2_, textField3_, textField4_, textField5_, textField6_, textField7_, textField8_, textField10_, textField11_));
        frame4.setVisible(false);
        
        JButton button3 = new JButton("Buscar");
        JButton button4 = new JButton("Voltar");
        JLabel label12 = new JLabel("Cfp do paciente:");
        JTextField textfield12 = new JTextField(15);
        frame5.setVisible(false);
        frame5.setSize(400, 110);
        frame5.setTitle("Buscar paciente");
        button3.addActionListener(new Buscar(textfield12 ));
        button4.addActionListener(new Troca_frame5());
        SpringLayout layout3= new SpringLayout();
        JPanel panel3 = new JPanel(layout3);
        frame5.setContentPane(panel3); 
        panel3.add(label12);
        panel3.add(textfield12);
        panel3.add(button3);
        panel3.add(button4);
        
        layout3.putConstraint(SpringLayout.WEST, label12, 10, SpringLayout.WEST, panel3);
        layout3.putConstraint(SpringLayout.NORTH, label12, 10, SpringLayout.NORTH, panel3);
        layout3.putConstraint(SpringLayout.WEST, textfield12, 10, SpringLayout.EAST, label12);
        layout3.putConstraint(SpringLayout.NORTH, textfield12, 10, SpringLayout.NORTH, panel3);
        layout3.putConstraint(SpringLayout.SOUTH, button3, -10, SpringLayout.SOUTH, panel3);
        layout3.putConstraint(SpringLayout.WEST, button3, 10, SpringLayout.WEST, panel3);
        layout3.putConstraint(SpringLayout.SOUTH, button4, -10, SpringLayout.SOUTH, panel3);
        layout3.putConstraint(SpringLayout.WEST, button4, 10, SpringLayout.EAST, button3);
        
        frame1.pack();
    	
    }
    
        
    
   class Troca_frame2 implements ActionListener{
	   public void actionPerformed(ActionEvent e){
        troca(2);
    }}
   
   class Troca_frame3 implements ActionListener{
	   public void actionPerformed(ActionEvent e){
        troca(3);
    }}
   
   class Troca_frame4 implements ActionListener{
	   public void actionPerformed(ActionEvent e){
        troca(4);
    }}
   
   class Troca_frame5 implements ActionListener{
	   public void actionPerformed(ActionEvent e){
        troca(5);
    }}
   
   public void troca(int i) {
	   if(i==5) {
		   if(frame1.isActive()){
	       	frame1.setVisible(false);
	       	frame5.setVisible(true);
	       }
	       else{
	           frame1.setVisible(true);
	           frame5.setVisible(false);}
		   }
	   if(i==4) {
		   if(frame1.isActive()){
	       	frame1.setVisible(false);
	       	frame4.setVisible(true);
	       }
	       else{
	           frame1.setVisible(true);
	           frame4.setVisible(false);}
		   }
	   
	   if(i==3) {
	   if(frame1.isActive()){
       	frame1.setVisible(false);
       	frame3.setVisible(true);
       }
       else{
           frame1.setVisible(true);
           frame3.setVisible(false);}
	   }
	   
	   if(i==2) {
		   if(frame1.isActive()){
	        	frame1.setVisible(false);
	        	frame2.setVisible(true);
	        }
	        else{
	            frame1.setVisible(true);
	            frame2.setVisible(false);}
	   }
   }
   
   class Enter_SUS implements ActionListener{
	   JTextField nome;
	   JTextField idade;
	   JTextField remedio;
	   JTextField dor;
	   JTextField especialidade; 
	   JTextField gravidade; 
	   JTextField cpf; 
	   JTextField exames;
	   JTextField sus;
	   String nomestr;
	   String idadestr;
	   String remediostr;
	   String dorstr;
	   String especialidadestr; 
	   String gravidadestr; 
	   String cpfstr; 
	   String examesstr;
	   String susstr;
	   Enter_SUS(JTextField nome, JTextField idade, JTextField remedio, JTextField dor, JTextField especialidade, JTextField gravidade, JTextField cpf, JTextField exames, JTextField sus){
		   this.nome = nome;
		   this.idade = idade;
		   this.remedio = remedio;
		   this.dor = dor;
		   this.especialidade = especialidade;
		   this.gravidade = gravidade;
		   this.cpf = cpf;
		   this.exames = exames;
		   this.sus = sus;
	   }
	   public void actionPerformed(ActionEvent e){
		   nomestr = nome.getText();
		   nome.setText("");
		   idadestr = idade.getText();
		   idade.setText("");
		   remediostr = remedio.getText();
		   remedio.setText("");
		   dorstr = dor.getText();
		   dor.setText("");
		   especialidadestr = especialidade.getText();
		   especialidade.setText("");
		   gravidadestr = gravidade.getText();
		   gravidade.setText("");
		   cpfstr = cpf.getText();
		   gravidade.setText("");
		   examesstr = exames.getText();
		   exames.setText("");
		   susstr = sus.getText();
		   sus.setText("");
		   if(nomestr.trim().isEmpty()  || idadestr.trim().isEmpty() || dorstr.trim().isEmpty() || especialidadestr.trim().isEmpty()|| gravidadestr.trim().isEmpty() || cpfstr.trim().isEmpty() || susstr.trim().isEmpty()) {
			   JOptionPane.showMessageDialog(frame2,
					    "Preencha todos os itens!");
		   }
		   else {
		   System.out.println("\nNome:" + nomestr + "\nIdade:" + idadestr + " anos" + "\nExames:" + examesstr);
		   troca(2);}
    }}
   
   class Enter_Particular implements ActionListener{
	   JTextField nome;
	   JTextField idade;
	   JTextField remedio;
	   JTextField dor;
	   JTextField especialidade; 
	   JTextField gravidade; 
	   JTextField cpf; 
	   JTextField exames;
	   JTextField convenio;
	   JTextField id;
	   String nomestr;
	   String idadestr;
	   String remediostr;
	   String dorstr;
	   String especialidadestr; 
	   String gravidadestr; 
	   String cpfstr; 
	   String examesstr;
	   String conveniostr;
	   String idstr;
	   Enter_Particular(JTextField nome, JTextField idade, JTextField remedio, JTextField dor, JTextField especialidade, JTextField gravidade, JTextField cpf, JTextField exames, JTextField convenio,  JTextField id){
		   this.nome = nome;
		   this.idade = idade;
		   this.remedio = remedio;
		   this.dor = dor;
		   this.especialidade = especialidade;
		   this.gravidade = gravidade;
		   this.cpf = cpf;
		   this.exames = exames;
		   this.convenio = convenio;
		   this.id = id;
	   }
	   public void actionPerformed(ActionEvent e){
		   nomestr = nome.getText();
		   nome.setText("");
		   idadestr = idade.getText();
		   idade.setText("");
		   remediostr = remedio.getText();
		   remedio.setText("");
		   dorstr = dor.getText();
		   dor.setText("");
		   especialidadestr = especialidade.getText();
		   especialidade.setText("");
		   gravidadestr = gravidade.getText();
		   gravidade.setText("");
		   cpfstr = cpf.getText();
		   gravidade.setText("");
		   examesstr = exames.getText();
		   exames.setText("");
		   conveniostr = convenio.getText();
		   convenio.setText("");
		   idstr =id.getText();
		   id.setText("");
		   if(nomestr.trim().isEmpty()  || idadestr.trim().isEmpty() || dorstr.trim().isEmpty() || especialidadestr.trim().isEmpty()|| gravidadestr.trim().isEmpty() || cpfstr.trim().isEmpty() || idstr.trim().isEmpty() || conveniostr.trim().isEmpty() ) {
			   JOptionPane.showMessageDialog(frame4,
					    "Preencha todos os itens!");
		   }
		   else {
		   System.out.println("\nNome:" + nomestr + "\nIdade:" + idadestr + " anos" + "\nExames:" + examesstr);
		   troca(4);}
    }}
    
   class Ler_arquivo implements ActionListener{
	   public void actionPerformed(ActionEvent e) {
		   try {
		   JFileChooser chooser = new JFileChooser();
		   int result = chooser.showOpenDialog(null);
		   String file = chooser.getSelectedFile().getAbsolutePath();
		   System.out.println("\nEndereço do arquivo escolhido:" + file );
		   } catch (NullPointerException exp) {
			   troca(3);
		   } 
		   
		   
	   }
		    
	    
   }
   
   class Buscar implements ActionListener{
	   JTextField txt;
	   String txtstr;
	   Buscar(JTextField txt){
	   this.txt = txt;
	   }
	   public void actionPerformed(ActionEvent e) {
	   txtstr = txt.getText();
	   txt.setText("");
	   if(txtstr.trim().isEmpty()) {
		   JOptionPane.showMessageDialog(frame5,
				    "Preencha o CPF!");
	   }
	   else {
		   troca(5);
	   }
	   }
   }
   
    public static void main(String[] args) {
        
    	new MinhaInterfaceGrafica();
    	
    	
    }
}
