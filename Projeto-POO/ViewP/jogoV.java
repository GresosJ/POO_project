package ViewP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ViewP.View.destroy_window;
import static ViewP.View.nFrame;

public class jogoV {
    private JButton Jogar;
    private JButton verEquipa;
    private JButton sair;
    private JLabel MinhaEquipa;
    private JPanel jogo;
    //private Equipa myTeam;

    public jogoV(String Equipa){
        MinhaEquipa.setText(Equipa);

        Jogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        verEquipa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "");
                //myTeam = getEquipa(Equipa);
            }
        });
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destroy_window(e);
                nFrame();
            }
        });
    }



     static void jogoF(String Equipa){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new jogoV(Equipa).jogo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
