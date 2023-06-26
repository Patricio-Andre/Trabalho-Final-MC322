package hospitaleservicos;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
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
    public MinhaInterfaceGrafica() {
        // Configurações da janela
        frame1 = new JFrame();
        frame2 = new JFrame();
        frame3 = new JFrame();
        frame1.setTitle("HospitalHub");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(300, 1000);
        frame2.setSize(350, 350);
  
        
        // Criação de botoes
        JButton button = new JButton("sair");
        JButton button2 = new JButton("Enviar");
     
        
        button.addActionListener(new Troca_frame());
       
    
        
        JLabel label1 = new JLabel("Ultimo paciente que tomou banho:");
        // Adicionando os componentes à janela
        
        JMenuBar menuBar = new JMenuBar();

        // Cria um menu "Arquivo"
        JMenu menuArquivo = new JMenu("Cadastrar");
        JMenu menuArquivo2 = new JMenu("Pegar atestado");
        JMenu menuArquivo3 = new JMenu("Ler arquivo");
        
        

        // Cria um item de menu "Abrir"
        JMenuItem itemCAdProfissional = new JMenuItem("Cadastrar paciente");
        itemCAdProfissional.addActionListener(new Troca_frame());
        menuArquivo.add(itemCAdProfissional);

        JMenuItem texto = new JMenuItem("Ler Txt");
        texto.addActionListener(new Ler_arquivo());
        menuArquivo3.add(texto);
        
        // Cria um item de menu "Sair"
        JMenuItem itemCAdPaciente = new JMenuItem("Cadastrar profissonal");
        menuArquivo.add(itemCAdPaciente);

        // Adiciona o menu "Arquivo" à barra de menu
        menuBar.add(menuArquivo);
        menuBar.add(menuArquivo2);
        menuBar.add(menuArquivo3);

        menuBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Define a barra de menu para o frame
        frame1.setJMenuBar(menuBar);

    

        frame1.setVisible(true);
        
        // Configurações de layout
        frame1.getContentPane().setLayout(new FlowLayout());
        
        // Exibição da janela
        

    

        frame1.getContentPane().add(label1);
        frame1.setVisible(true);
        frame2.setVisible(false);

        JTextField txt = new JTextField("Text field", 15);
        JLabel label = new JLabel("Nome:");
        JTextField textField = new JTextField(23);
        JLabel label2 = new JLabel("Idade:");
        JTextField textField2 = new JTextField(23);
        JLabel label3 = new JLabel("Remedios evitados:");
        JTextField textField3 = new JTextField(14);
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
        button2.addActionListener(new Enter(textField, textField2, textField3, textField4, textField5, textField6, textField7, textField8));

        // Criação do layout
        SpringLayout layout = new SpringLayout();
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
        JPanel panel = new JPanel(layout);
        layout.putConstraint(SpringLayout.SOUTH, button, -26, SpringLayout.SOUTH, panel);
        frame2.setContentPane(panel);
        frame1.setTitle("Hospital Hub");
        frame2.setTitle("Paciente INFO");
        
        
        
        
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

        // Configurações do frame
        frame1.pack();
        
        frame2.setVisible(false);
        
        
       
    }
    
   class Troca_frame implements ActionListener{
	   public void actionPerformed(ActionEvent e){
        if(frame1.isActive()){
        	frame1.setVisible(false);
        	frame2.setVisible(true);
        }
        else{
            frame1.setVisible(true);
            frame2.setVisible(false);}
    }}
   
   class Troca_frame3 implements ActionListener{
	   public void actionPerformed(ActionEvent e){
        troca();
    }}
   
   public void troca() {
	   if(frame1.isActive()){
       	frame1.setVisible(false);
       	frame3.setVisible(true);
       }
       else{
           frame1.setVisible(true);
           frame3.setVisible(false);}
   }
   
   class Enter implements ActionListener{
	   JTextField nome;
	   JTextField idade;
	   JTextField remedio;
	   JTextField dor;
	   JTextField especialidade; 
	   JTextField gravidade; 
	   JTextField cpf; 
	   JTextField exames;
	   String nomestr;
	   String idadestr;
	   String remediostr;
	   String dorstr;
	   String especialidadestr; 
	   String gravidadestr; 
	   String cpfstr; 
	   String examesstr;
	   Enter(JTextField nome, JTextField idade, JTextField remedio, JTextField dor, JTextField especialidade, JTextField gravidade, JTextField cpf, JTextField exames){
		   this.nome = nome;
		   this.idade = idade;
		   this.remedio = remedio;
		   this.dor = dor;
		   this.especialidade = especialidade;
		   this.gravidade = gravidade;
		   this.cpf = cpf;
		   this.exames = exames;
	   }
	   public void actionPerformed(ActionEvent e){
		   nomestr = nome.getText();
		   idadestr = idade.getText();
		   remediostr = remedio.getText();
		   dorstr = dor.getText();
		   especialidadestr = especialidade.getText();
		   gravidadestr = gravidade.getText();
		   cpfstr = cpf.getText();
		   examesstr = exames.getText();
		   System.out.println("\nNome:" + nomestr + "\nIdade:" + idadestr + " anos" + "\nExames:" + examesstr);
    }}
    
   class Ler_arquivo implements ActionListener{
	   public void actionPerformed(ActionEvent e) {
		   try {
		   JFileChooser chooser = new JFileChooser();
		   int result = chooser.showOpenDialog(null);
		   String file = chooser.getSelectedFile().getAbsolutePath();
		   System.out.println("\nEndereço do arquivo escolhido:" + file );
		   } catch (NullPointerException exp) {
			   troca();
		   }
		   
		   
		   
		    
	   }
   }
   
    public static void main(String[] args) {
        
        new MinhaInterfaceGrafica();}


   
    }

  

