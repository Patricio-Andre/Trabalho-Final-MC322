package HospHub;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.filechooser.FileFilter.*;



import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaInterfaceGrafica  {
	 JFrame frame0;
	 JFrame frame1;
	 JFrame frame2;
	 JFrame frame3; 
	 JFrame frame4;
	 JFrame frame5;
	 ButtonGroup buttonGroup;
	 ButtonGroup buttonGroup2;
     ButtonGroup gp_;
     ButtonGroup gp;
     Hospital hospital;
    
    MinhaInterfaceGrafica(Hospital hospital){
    	frame0 = new JFrame();
    	frame1 = new JFrame();
        frame2 = new JFrame();
        frame3 = new JFrame();
        frame4 = new JFrame();
        frame5 = new JFrame();
        this.hospital = hospital;
        
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
        
        JMenuItem itemReceita = new JMenuItem("Pegar receita");
        itemReceita.addActionListener(new Troca_frame5());
        menuArquivo2.add(itemReceita);
    
        menuBar.add(menuArquivo);
        menuBar.add(menuArquivo2);
       // menuBar.add(menuArquivo3);
        menuBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        SpringLayout layout0 = new SpringLayout();
        JPanel panel0 = new JPanel(layout0);
        frame0.setContentPane(panel0);
        
        JLabel label0 = new JLabel("Nome:  ");
        JTextField textField0 = new JTextField(23);
        JLabel label02 = new JLabel("Telefone:");
        JTextField textField02 = new JTextField(22);
        JLabel label03 = new JLabel("Endereço:  ");
        JTextField textField03 = new JTextField(21);
        JLabel label04 = new JLabel("Email: ");
        JTextField textField04 = new JTextField(24);
        JLabel label05 = new JLabel("Cnpj:  ");
        JTextField textField05 = new JTextField(24);
        
        JButton button0 = new JButton("Enviar");
        button0.addActionListener(new Enter_Hospital(textField0, textField02, textField04, textField03, textField05, hospital));
      
        
        panel0.add(label0);
        panel0.add(textField0);
        panel0.add(label02);
        panel0.add(textField02);
        panel0.add(label03);
        panel0.add(textField03);
        panel0.add(label04);
        panel0.add(textField04);
        panel0.add(label05);
        panel0.add(textField05);
        panel0.add(button0);
        
        layout0.putConstraint(SpringLayout.WEST, label0, 10, SpringLayout.WEST, panel0);
        layout0.putConstraint(SpringLayout.NORTH, label0, 10, SpringLayout.NORTH, panel0);
        layout0.putConstraint(SpringLayout.WEST, textField0, 10, SpringLayout.EAST, label0);
        layout0.putConstraint(SpringLayout.NORTH, textField0, 10, SpringLayout.NORTH, panel0);
        
        layout0.putConstraint(SpringLayout.WEST, label02, 10, SpringLayout.WEST, panel0);
        layout0.putConstraint(SpringLayout.NORTH, label02, 40, SpringLayout.NORTH, panel0);
        layout0.putConstraint(SpringLayout.WEST, textField02, 10, SpringLayout.EAST, label02);
        layout0.putConstraint(SpringLayout.NORTH, textField02, 40, SpringLayout.NORTH, panel0);
        
        layout0.putConstraint(SpringLayout.WEST, label03, 10, SpringLayout.WEST, panel0);
        layout0.putConstraint(SpringLayout.NORTH, label03, 70, SpringLayout.NORTH, panel0);
        layout0.putConstraint(SpringLayout.WEST, textField03, 10, SpringLayout.EAST, label03);
        layout0.putConstraint(SpringLayout.NORTH, textField03, 70, SpringLayout.NORTH, panel0);
        
        layout0.putConstraint(SpringLayout.WEST, label04, 10, SpringLayout.WEST, panel0);
        layout0.putConstraint(SpringLayout.NORTH, label04, 100, SpringLayout.NORTH, panel0);
        layout0.putConstraint(SpringLayout.WEST, textField04, 10, SpringLayout.EAST, label04);
        layout0.putConstraint(SpringLayout.NORTH, textField04, 100, SpringLayout.NORTH, panel0);
        
        layout0.putConstraint(SpringLayout.WEST, label05, 10, SpringLayout.WEST, panel0);
        layout0.putConstraint(SpringLayout.NORTH, label05, 130, SpringLayout.NORTH, panel0);
        layout0.putConstraint(SpringLayout.WEST, textField05, 10, SpringLayout.EAST, label05);
        layout0.putConstraint(SpringLayout.NORTH, textField05, 130, SpringLayout.NORTH, panel0);
        
        layout0.putConstraint(SpringLayout.SOUTH, button0, -20, SpringLayout.SOUTH, panel0);
        layout0.putConstraint(SpringLayout.WEST, button0, 10, SpringLayout.WEST, panel0);
        

        frame1.getContentPane().add(label1);
        frame0.setSize(350, 250);
        frame3.setVisible(false);
        frame1.setVisible(false);
        frame0.setVisible(true);
        
        frame2.setTitle("Paciente INFO");
        frame0.setTitle("Gerar hospital");
        frame2.setSize(350, 380);
        


        JButton button = new JButton("sair");
        JButton button2 = new JButton("Enviar");

        
        button.addActionListener(new Troca_frame2());

        frame2.setVisible(false);
        

        buttonGroup = new ButtonGroup();
        JRadioButton um = new JRadioButton("1", false);
        JRadioButton dois = new JRadioButton("2", false);
        JRadioButton tres = new JRadioButton("3", false);
        JRadioButton quatro = new JRadioButton("4", false);
        JRadioButton cinco = new JRadioButton("5", false);
        JRadioButton seis = new JRadioButton("6", false);
        JRadioButton sete = new JRadioButton("7", false);
        JRadioButton oito = new JRadioButton("8", false);
        JRadioButton nove = new JRadioButton("9", false);
        JRadioButton dez = new JRadioButton("10", false);
        
        buttonGroup.add(um);
        buttonGroup.add(dois);
        buttonGroup.add(tres);
        buttonGroup.add(quatro);
        buttonGroup.add(cinco);
        buttonGroup.add(seis);
        buttonGroup.add(sete);
        buttonGroup.add(oito);
        buttonGroup.add(nove);
        buttonGroup.add(dez);
        
        buttonGroup2 = new ButtonGroup();
        JRadioButton um2 = new JRadioButton("1", false);
        JRadioButton dois2 = new JRadioButton("2", false);
        JRadioButton tres2 = new JRadioButton("3", false);
        JRadioButton quatro2 = new JRadioButton("4", false);
        JRadioButton cinco2 = new JRadioButton("5", false);
        JRadioButton seis2 = new JRadioButton("6", false);
        JRadioButton sete2 = new JRadioButton("7", false);
        JRadioButton oito2 = new JRadioButton("8", false);
        JRadioButton nove2 = new JRadioButton("9", false);
        JRadioButton dez2 = new JRadioButton("10", false);
        
        buttonGroup2.add(um2);
        buttonGroup2.add(dois2);
        buttonGroup2.add(tres2);
        buttonGroup2.add(quatro2);
        buttonGroup2.add(cinco2);
        buttonGroup2.add(seis2);
        buttonGroup2.add(sete2);
        buttonGroup2.add(oito2);
        buttonGroup2.add(nove2);
        buttonGroup2.add(dez2);
        
        
        JLabel label = new JLabel("Nome:");
        JTextField textField = new JTextField(23);
        JLabel label2 = new JLabel("Idade:");
        JTextField textField2 = new JTextField(23);
        JLabel label3 = new JLabel("Remedios evitados:");
        JTextField textField3 = new JTextField(16);
        JLabel label4 = new JLabel("Exames evitados:");
        JTextField textField4 = new JTextField(16);
        JLabel label5 = new JLabel("Especiaidade do medico:");
        JLabel label6 = new JLabel("Numero do SUS:");
        JTextField textField6 = new JTextField(17);
        JLabel label7 = new JLabel("CPF:");
        JTextField textField7 = new JTextField(24);
        JLabel label8 = new JLabel("NÍvel de dor:");
  
        button2.addActionListener(new Enter_SUS(textField, textField2, textField3, textField7, textField4, textField6));
        
       
        
        SpringLayout layout = new SpringLayout();
 
        JPanel panel = new JPanel(layout);
        
       
        layout.putConstraint(SpringLayout.NORTH, um, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, um, 20, SpringLayout.WEST, panel);

        
        layout.putConstraint(SpringLayout.NORTH, dois, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, dois, 50, SpringLayout.WEST, panel);

        layout.putConstraint(SpringLayout.NORTH, tres, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, tres, 80, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, quatro, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, quatro, 110, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, cinco, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, cinco, 140, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, seis, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, seis, 170, SpringLayout.WEST, panel);

        
        layout.putConstraint(SpringLayout.NORTH, sete, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, sete, 200, SpringLayout.WEST, panel);

        layout.putConstraint(SpringLayout.NORTH, oito, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, oito, 230, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, nove, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST,nove, 260, SpringLayout.WEST, panel);
        
        layout.putConstraint(SpringLayout.NORTH, dez, 15, SpringLayout.SOUTH, label8);
        layout.putConstraint(SpringLayout.WEST, dez, 290, SpringLayout.WEST, panel);
        
        
        
        layout.putConstraint(SpringLayout.NORTH, button2, 0, SpringLayout.NORTH, button);
        layout.putConstraint(SpringLayout.EAST, button2, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, label6);
        layout.putConstraint(SpringLayout.WEST, textField7, 6, SpringLayout.EAST, label7);
        layout.putConstraint(SpringLayout.NORTH, textField7, -2, SpringLayout.NORTH, label7);
        layout.putConstraint(SpringLayout.EAST, textField7, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.NORTH, textField6, -2, SpringLayout.NORTH, label6);
        layout.putConstraint(SpringLayout.EAST, textField6, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.NORTH, textField4, -2, SpringLayout.NORTH, label4);
        layout.putConstraint(SpringLayout.WEST, textField4, 10, SpringLayout.EAST, label4);
        layout.putConstraint(SpringLayout.EAST, textField4, 0, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.EAST, textField3, 0, SpringLayout.EAST, textField); 
        layout.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, panel);
        frame2.setContentPane(panel);

     

        panel.add(label);
        panel.add(textField);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);
        panel.add(label8);
        panel.add(button);
        panel.add(button2);
        panel.add(um);
        panel.add(dois);
        panel.add(tres);
        panel.add(quatro);
        panel.add(cinco);
        panel.add(seis);
        panel.add(sete);
        panel.add(oito);
        panel.add(nove);
        panel.add(dez);
        
     
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
        layout.putConstraint(SpringLayout.NORTH, label6, 190, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label7, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label7, 220, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, label8, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label8, 250, SpringLayout.NORTH, panel);
        
        
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
        JLabel label4_ = new JLabel("ID do convenio:");
        JTextField textField4_ = new JTextField(19);
        JLabel label5_ = new JLabel("Exames evitados:");
        JTextField textField5_ = new JTextField(16);
        JLabel label6_ = new JLabel("Especialidade do medico:");
       // JTextField textField6_ = new JTextField(16);
        JLabel label7_ = new JLabel("CPF:");
        JTextField textField7_ = new JTextField(24);
        JLabel label8_ = new JLabel("Convenio:");
        JTextField textField8_ = new JTextField(21);
        JLabel label10_ = new JLabel("Nivel de dor:");

        button2_.addActionListener(new Enter_Particular(textField_, textField2_, textField3_, textField7_,textField5_, textField8_, textField4_ ));


        SpringLayout layout2 = new SpringLayout();
 
        layout2.putConstraint(SpringLayout.NORTH, label6_, 0, SpringLayout.NORTH, textField7_);
        layout2.putConstraint(SpringLayout.NORTH, label7_, 2, SpringLayout.NORTH, textField7_);
        layout2.putConstraint(SpringLayout.SOUTH, label7_, 44, SpringLayout.NORTH, textField7_);
        layout2.putConstraint(SpringLayout.SOUTH, label6_, -34, SpringLayout.NORTH, textField7_);
        layout2.putConstraint(SpringLayout.WEST, textField7_, 0, SpringLayout.WEST, textField_);
        layout2.putConstraint(SpringLayout.SOUTH, textField7_, -12, SpringLayout.NORTH, textField8_);
        layout2.putConstraint(SpringLayout.EAST, textField7_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.NORTH, dois2, 25, SpringLayout.SOUTH, label8_);
        layout2.putConstraint(SpringLayout.NORTH, um2, 25, SpringLayout.SOUTH, label8_);
        layout2.putConstraint(SpringLayout.NORTH, label5_, 11, SpringLayout.SOUTH, textField4_);
        layout2.putConstraint(SpringLayout.NORTH, label8_, 2, SpringLayout.NORTH, textField8_);
        layout2.putConstraint(SpringLayout.NORTH, dez2, 23, SpringLayout.SOUTH, textField8_);
        layout2.putConstraint(SpringLayout.NORTH, nove2, 23, SpringLayout.SOUTH, textField8_);
        layout2.putConstraint(SpringLayout.NORTH, oito2, 23, SpringLayout.SOUTH, textField8_);
        layout2.putConstraint(SpringLayout.NORTH, tres2, 23, SpringLayout.SOUTH, textField8_);
        layout2.putConstraint(SpringLayout.SOUTH, textField8_, -2, SpringLayout.NORTH, label10_);
        layout2.putConstraint(SpringLayout.EAST, textField8_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.NORTH, sete2, 6, SpringLayout.SOUTH, label10_);
        layout2.putConstraint(SpringLayout.NORTH, seis2, 6, SpringLayout.SOUTH, label10_);
        layout2.putConstraint(SpringLayout.NORTH, cinco2, 6, SpringLayout.SOUTH, label10_);
        layout2.putConstraint(SpringLayout.SOUTH, label10_, -6, SpringLayout.NORTH, quatro2);
        JPanel panel2 = new JPanel(layout2);
        layout2.putConstraint(SpringLayout.SOUTH, label2_, -317, SpringLayout.SOUTH, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label3_, 70, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.NORTH, textField2_, 40, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.WEST, textField_, 65, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, label8_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, label7_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, label6_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, label5_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, label4_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, label3_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, textField_, 10, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.NORTH, quatro2, 286, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.WEST, label10_, 127, SpringLayout.WEST, panel2);
        frame4.setContentPane(panel2); 
        
        layout2.putConstraint(SpringLayout.NORTH, textField3_, -2, SpringLayout.NORTH, label3_);
        layout2.putConstraint(SpringLayout.WEST, textField3_, 13, SpringLayout.EAST, label3_);
        layout2.putConstraint(SpringLayout.EAST, textField3_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.NORTH, button_, 0, SpringLayout.NORTH, button2_);
        layout2.putConstraint(SpringLayout.EAST, textField4_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.EAST, textField2_, 0, SpringLayout.EAST, textField_);
        layout2.putConstraint(SpringLayout.WEST, textField4_, 25, SpringLayout.EAST, label4_);
        layout2.putConstraint(SpringLayout.NORTH, textField4_, 0, SpringLayout.NORTH, label4_);
        layout2.putConstraint(SpringLayout.WEST, textField2_, 10, SpringLayout.EAST, label2_);
        layout2.putConstraint(SpringLayout.NORTH, label4_, 6, SpringLayout.SOUTH, label3_);
        layout2.putConstraint(SpringLayout.EAST, button2_, -23, SpringLayout.EAST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label_, 10, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.WEST, label_, 0, SpringLayout.WEST, panel2);
        
       
        
      
        
  

        
        
        panel2.add(label_);
        panel2.add(textField_);
        panel2.add(label2_);
        panel2.add(textField2_);
        panel2.add(label3_);
        panel2.add(textField3_);
        panel2.add(label4_);
        panel2.add(textField4_);
        panel2.add(label5_);
        panel2.add(label6_);
        panel2.add(label7_);
        panel2.add(textField7_);
        panel2.add(label8_);
        panel2.add(textField8_);
        panel2.add(label10_);
        panel2.add(button_);
        panel2.add(button2_);
        panel2.add(um2);
        panel2.add(dois2);
        panel2.add(tres2);
        panel2.add(quatro2);
        panel2.add(cinco2);
        panel2.add(seis2);
        panel2.add(sete2);
        panel2.add(oito2);
        panel2.add(nove2);
        panel2.add(dez2);
        panel2.add(textField5_);

        
        layout2.putConstraint(SpringLayout.WEST, label_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label_, 10, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.WEST, textField_, 10, SpringLayout.EAST, label_);
        layout2.putConstraint(SpringLayout.NORTH, textField_, 10, SpringLayout.NORTH, panel2);

        layout2.putConstraint(SpringLayout.WEST, textField5_, 10, SpringLayout.EAST, label5_);
        layout2.putConstraint(SpringLayout.NORTH, textField5_, 130, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label2_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label2_, 40, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.NORTH, textField2_, 40, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label3_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label3_, 70, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label4_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label4_, 100, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label5_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label5_, 130, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label6_, 160, SpringLayout.NORTH, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, label7_, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, label7_, 190, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.WEST, um2, 20, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, dois2, 50, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, tres2, 80, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, quatro2, 110, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, cinco2, 140, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, seis2, 170, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, sete2, 200, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, oito2, 230, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST,nove2, 260, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.WEST, dez2, 290, SpringLayout.WEST, panel2);
        
        layout2.putConstraint(SpringLayout.WEST, button_, 10, SpringLayout.WEST, panel2);
        
        layout2.putConstraint(SpringLayout.NORTH, button_, 10, SpringLayout.SOUTH, dez2);
        layout2.putConstraint(SpringLayout.NORTH,  button2_, 10, SpringLayout.SOUTH, dez2);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("Neurologia");
        layout2.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox, -2, SpringLayout.NORTH, label6_);
        layout2.putConstraint(SpringLayout.EAST, chckbxNewCheckBox, 0, SpringLayout.EAST, textField_);
        panel2.add(chckbxNewCheckBox);
        
        JCheckBox chckbxGastro = new JCheckBox("Pediatra");
        layout2.putConstraint(SpringLayout.WEST, chckbxGastro, 0, SpringLayout.WEST, label10_);
        layout2.putConstraint(SpringLayout.SOUTH, chckbxGastro, -6, SpringLayout.NORTH, textField7_);
        layout2.putConstraint(SpringLayout.EAST, chckbxGastro, 0, SpringLayout.EAST, label10_);
        panel2.add(chckbxGastro);
        
        JCheckBox chckbxCardiologia = new JCheckBox("Cardiologia");
        layout2.putConstraint(SpringLayout.NORTH, chckbxGastro, 0, SpringLayout.NORTH, chckbxCardiologia);
        layout2.putConstraint(SpringLayout.WEST, chckbxCardiologia, 0, SpringLayout.WEST, chckbxNewCheckBox);
        layout2.putConstraint(SpringLayout.SOUTH, chckbxCardiologia, -6, SpringLayout.NORTH, textField7_);
        panel2.add(chckbxCardiologia);
        
        JCheckBox chckbxGinecologia = new JCheckBox("Ginecologia");
        layout2.putConstraint(SpringLayout.SOUTH, chckbxGinecologia, -6, SpringLayout.NORTH, textField7_);
        panel2.add(chckbxGinecologia);
        frame4.setVisible(false);

        

        gp = new ButtonGroup();
        gp.add(chckbxNewCheckBox);
        gp.add(chckbxGastro);
        gp.add(chckbxCardiologia);
        gp.add(chckbxGinecologia);

        JCheckBox chckbxNewCheckBox_ = new JCheckBox("Neurologia");
        layout.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox_, -2, SpringLayout.NORTH, label5);
        layout.putConstraint(SpringLayout.EAST, chckbxNewCheckBox_, 0, SpringLayout.EAST, textField);
        panel.add(chckbxNewCheckBox_);
        
        JCheckBox chckbxGastro_ = new JCheckBox("Pediatra");
        layout.putConstraint(SpringLayout.WEST, chckbxGastro_, 0, SpringLayout.WEST, label8);
        layout.putConstraint(SpringLayout.SOUTH, chckbxGastro_, -6, SpringLayout.NORTH, textField6);
        layout.putConstraint(SpringLayout.EAST, chckbxGastro_, 0, SpringLayout.EAST, label8);
        panel.add(chckbxGastro_);
        
        JCheckBox chckbxCardiologia_ = new JCheckBox("Cardiologia");
        layout.putConstraint(SpringLayout.NORTH, chckbxGastro_, 0, SpringLayout.NORTH, chckbxCardiologia_);
        layout.putConstraint(SpringLayout.WEST, chckbxCardiologia_, 0, SpringLayout.WEST, chckbxNewCheckBox_);
        layout.putConstraint(SpringLayout.SOUTH, chckbxCardiologia_, -6, SpringLayout.NORTH, textField6);
        panel.add(chckbxCardiologia_);
        
        JCheckBox chckbxGinecologia_ = new JCheckBox("Ginecologia");
        layout.putConstraint(SpringLayout.SOUTH, chckbxGinecologia_, -6, SpringLayout.NORTH, textField6);
        panel.add(chckbxGinecologia_);
        frame2.setVisible(false);

        

        gp_ = new ButtonGroup();
        gp_.add(chckbxNewCheckBox_);
        gp_.add(chckbxGastro_);
        gp_.add(chckbxCardiologia_);
        gp_.add(chckbxGinecologia_);
        
        
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
    
    class Troca_frame1 implements ActionListener{
 	   public void actionPerformed(ActionEvent e){
         troca(1);
     }}
        
    
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
	   
	   if(i==1) {
		   if(frame1.isActive()){
	        	frame1.setVisible(false);
	        	frame0.setVisible(true);
	        }
	        else{
	            frame1.setVisible(true);
	            frame0.setVisible(false);}
	   }
   }
   
   class Enter_SUS implements ActionListener{
	   JTextField nome;
	   JTextField idade;
	   JTextField remedio;
	   JTextField especialidade; 
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
	   Enter_SUS(JTextField nome, JTextField idade, JTextField remedio, JTextField cpf, JTextField exames, JTextField sus){
		   this.nome = nome;
		   this.idade = idade;
		   this.remedio = remedio;
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
		  
		   cpfstr = cpf.getText();
		   cpf.setText("");
		   examesstr = exames.getText();
		   exames.setText("");
		   susstr = sus.getText();
		   sus.setText("");
		   if(nomestr.trim().isEmpty()  || idadestr.trim().isEmpty() || cpfstr.trim().isEmpty() || susstr.trim().isEmpty() ||  getBotao(buttonGroup) == null || getBotao(gp_) == null) {
			   JOptionPane.showMessageDialog(frame2,
					    "Preencha todos os itens!");
			
		   }
		   else {
             especialidadestr = getBotao(gp_).getText();
		   dorstr = getBotao(buttonGroup).getText();
			   if(ValidaDados.validarCPF(cpfstr) == false) {
				  JOptionPane.showMessageDialog(frame2,
						    "Inserir cpf valido!");
			   }
			  else {
		  new PacienteSus(cpfstr, Integer.parseInt(idadestr), Integer.parseInt(dorstr), nomestr, remediostr,
				  especialidadestr,  examesstr, hospital, Integer.parseInt(susstr));
		   System.out.println("\nNome:" + nomestr + "\nIdade:" + idadestr + " anos" + "\nExames:" + examesstr);
		   troca(2);}
    }}}
   
   class Enter_Hospital implements ActionListener{
	   JTextField nome;
	   JTextField telefone;
	   JTextField email;
	   JTextField endereco;
	   JTextField cnpj; 
	   String nomestr;
	   String telefonestr;
	   String emailstr;
	   String enderecostr;
	   String cnpjstr; 
	  
	   Enter_Hospital(JTextField nome, JTextField telefone, JTextField email, JTextField endereco, JTextField cnpj, Hospital hospital){
		   this.nome = nome;
		   this.telefone = telefone;
		   this.email =  email;
		   this.endereco = endereco;
		   this.cnpj = cnpj;

	   }
	   public void actionPerformed(ActionEvent e){
		   nomestr = nome.getText();
		   nome.setText("");
		   telefonestr = telefone.getText();
		   telefone.setText("");
		   emailstr =  email.getText();
		   email.setText("");
		   enderecostr = endereco.getText();
		   endereco.setText("");
		   cnpjstr = cnpj.getText();
		   cnpj.setText("");
		   if(nomestr.trim().isEmpty()  || telefonestr.trim().isEmpty() || emailstr.trim().isEmpty() || enderecostr.trim().isEmpty()|| cnpjstr.trim().isEmpty()) {
			   JOptionPane.showMessageDialog(frame2,
					    "Preencha todos os itens!");

		   }
		   
		   else {
			   if(ValidaDados.validaCNPJ(cnpjstr) == false) {
				   JOptionPane.showMessageDialog(frame2,
					    "Inserir cnpj valido!");
			   }
			   else
			   {
			  hospital = new Hospital(nomestr, cnpjstr, telefonestr, emailstr, enderecostr);
		   System.out.println("\nNome:" + nomestr + "\nTelefone:" +  telefonestr + "\nEmail:" + emailstr);
		   troca(1);}}
    }}
   
   AbstractButton getBotao(ButtonGroup b){
   				Enumeration<AbstractButton> elements = b.getElements();
   		        while (elements.hasMoreElements()) {
   		            AbstractButton button = elements.nextElement();
   		            if (button.isSelected())
   		                return button;
   		        }
   		        return null;
   		    }
   			
   
   class Enter_Particular implements ActionListener{
	   JTextField nome;
	   JTextField idade;
	   JTextField remedio;
	   JTextField cpf; 
	   JTextField exames;
	   JTextField convenio;
	   JTextField id;
	   String nomestr;
	   String idadestr;
	   String remediostr;
	   String dorstr;
	   String especialidadestr; 
	   String cpfstr; 
	   String examesstr;
	   String conveniostr;
	   String idstr;
	   Enter_Particular(JTextField nome, JTextField idade, JTextField remedio, JTextField cpf, JTextField exames, JTextField convenio,  JTextField id  ){
		   this.nome = nome;
		   this.idade = idade;
		   this.remedio = remedio;
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
		   examesstr = exames.getText();
		   exames.setText("");
		   conveniostr = convenio.getText();
		   convenio.setText("");
		   idstr =id.getText();
		   id.setText("");
		   cpfstr = cpf.getText();
		   cpf.setText("");
		   if(nomestr.trim().isEmpty()  || idadestr.trim().isEmpty()   || cpfstr.trim().isEmpty() || idstr.trim().isEmpty() || conveniostr.trim().isEmpty() ||  getBotao(buttonGroup2) == null || getBotao(gp) == null) {
			   JOptionPane.showMessageDialog(frame4,
					    "Preencha todos os itens!");
		   }
		   else {
            especialidadestr = getBotao(gp).getText();
		   dorstr = getBotao(buttonGroup2).getText();
				   if(ValidaDados.validarCPF(cpfstr) == false) {
					   JOptionPane.showMessageDialog(frame2,
							    "Inserir cpf valido!");
				   }
				   else {
					   new PacienteParticular(cpfstr, Integer.parseInt(idadestr), Integer.parseInt(dorstr), nomestr, remediostr,
							   especialidadestr,  examesstr,  hospital, conveniostr, Integer.parseInt(idstr));
		   System.out.println("\nNome:" + nomestr + "\nIdade:" + idadestr + " anos" + "\nExames:" + examesstr);
		   troca(4);}
    }}}
    
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
       
   	new MinhaInterfaceGrafica(new Hospital( "nome",  "cnpj", "telefone", "email", "endereco"));
   	
   	
   }
}
