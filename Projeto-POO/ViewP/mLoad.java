package ViewP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mLoad {
    private JButton Bsave1, Bsave2, Bsave3;
    private JPanel pLoad;


    public mLoad(){
        Bsave1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if(file == NULL)
                JOptionPane.showMessageDialog(null, "Nenhum jogo carregado");
                //else -> ler ficheiro; mudar de window e mostrar o estado segundo o que esta no ficheiro
            }
        });
        Bsave2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if(file == NULL)
                JOptionPane.showMessageDialog(null, "Nenhum jogo carregado");
                //else -> ler ficheiro; mudar de window e mostrar o estado segundo o que esta no ficheiro
            }
        });
        Bsave3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if(file == NULL)
                JOptionPane.showMessageDialog(null, "Nenhum jogo carregado");
                //else -> ler ficheiro; mudar de window e mostrar o estado segundo o que esta no ficheiro
            }
        });
    }

    static public void loadFrame(){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new mLoad().pLoad);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
