import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaInterfaceGrafica  implements ActionListener{
    JFrame frame1;
    JFrame frame2;
    public MinhaInterfaceGrafica() {
        // Configurações da janela
        frame1 = new JFrame();
        frame2 = new JFrame();
        frame1.setTitle("HospitalHub");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Criação de componentes
        JLabel label1 = new JLabel("Ultimo paciente que tomou banho:");
        JButton button = new JButton("sair");
        button.addActionListener(this);
        
        // Adicionando os componentes à janela
        
        JMenuBar menuBar = new JMenuBar();

        // Cria um menu "Arquivo"
        JMenu menuArquivo = new JMenu("Cadastrar");
        JMenu menuArquivo2 = new JMenu("Pegar atestado");
        JMenu menuArquivo3 = new JMenu("Ler arquivo");
        

        // Cria um item de menu "Abrir"
        JMenuItem itemCAdProfissional = new JMenuItem("Cadastrar profissonal");
        itemCAdProfissional.addActionListener(this);
        menuArquivo.add(itemCAdProfissional);

        // Cria um item de menu "Sair"
        JMenuItem itemCAdPaciente = new JMenuItem("Cadastrar paciente");
        menuArquivo.add(itemCAdPaciente);

        // Adiciona o menu "Arquivo" à barra de menu
        menuBar.add(menuArquivo);
        menuBar.add(menuArquivo2);
        menuBar.add(menuArquivo3);

        menuBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Define a barra de menu para o frame
        frame1.setJMenuBar(menuBar);

        frame1.setSize(1000, 1000);

        frame1.setVisible(true);
        
        // Configurações de layout
        frame1.getContentPane().setLayout(new FlowLayout());
        
        // Exibição da janela
        frame1.pack();

    

        frame1.add(label1);
        frame1.setVisible(true);
        frame2.setVisible(false);

        JTextField txt = new JTextField("Text field", 15);
       




        JLabel label = new JLabel("Nome:");
        JTextField textField = new JTextField(20);
       

        // Criação do layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        frame2.setContentPane(panel);
        frame1.setTitle("Hospital Hub");

        // Adicionando os componentes ao painel com o layout SpringLayout
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        // Configurações de posicionamento dos componentes
        layout.putConstraint(SpringLayout.WEST, label, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, button, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, button, 10, SpringLayout.SOUTH, textField);

        // Configurações do frame
        frame2.setSize(300, 200);
        frame2.setVisible(false);
    }
    
    public static void main(String[] args) {
        
        new MinhaInterfaceGrafica();
           
    }

   
    public void actionPerformed(ActionEvent arg0) {
        if(frame1.isActive()){
        frame1.setVisible(false);
        frame2.setVisible(true);
        }
        else{
            frame1.setVisible(true);
            frame2.setVisible(false);
        }
    }

  
}
