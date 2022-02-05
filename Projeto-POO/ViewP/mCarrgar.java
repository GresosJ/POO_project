package ViewP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ViewP.View.destroy_window;

public class mCarrgar {
    private JPanel cEquipa;
    private JTextField escolheAEquipa;
    private JLabel escolherE;
    private JButton Confirmar;
    private JTextArea equipas;
    private static final String[] Equi = {
            "Mahler Athletic",
            "Bach F. C.",
            "Sporting Club Chopin",
            "Beethoven F. C.",
            "Mozart F. C.",
            "Sporting Club Prokofiev",
            "Vivaldi F. C.",
            "Handel Athletic",
            "Schumann Athletic",
            "Wagner Athletic",
            "Brahms F. C.",
            "Sporting Club Schubert",
            "Sporting Club Dvorak",
            "Debussy Athletic",
            "Bartok F. C.",
            "Sporting Club Shostakovich",
            "Stravinsky Athletic",
            "Mendelssohn F. C.",
    };


    public mCarrgar() {

        Confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NEquipa = escolheAEquipa.getText();
                if(procurar(NEquipa)) {
                    JOptionPane.showMessageDialog(null,"Escolheste a equipa " + NEquipa +"\nPara seres treinador");
                    destroy_window(e);
                    jogoV.jogoF(NEquipa);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Esta nao equipa existe");
                }
            }

        });
    }

    static public void carregarFrame(){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new mCarrgar().cEquipa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static Boolean procurar(String p){
        for (String s : Equi) {
            if (p.equals(s)) return true;
        }
        return false;
    }
}

