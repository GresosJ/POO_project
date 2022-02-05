package ViewP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ViewP.mCarrgar.*;
import static ViewP.mLoad.*;

public class View{
    private JButton bNGame, bLGame, bSair;
    private JPanel NGame;

    public View(){
        bNGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destroy_window(e);
                carregarFrame();
            }
        });
        bLGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destroy_window(e);
                loadFrame();
            }
        });
        bSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    static public void nFrame(){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new View().NGame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    static public void destroy_window (ActionEvent e){
        JComponent comp = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }


    public static void main(String[] args) {
        nFrame();
    }
}