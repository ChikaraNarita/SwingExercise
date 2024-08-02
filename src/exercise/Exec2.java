package exercise;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Exec2 extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Exec2().setVisible(true);
    }

    JButton moveLeft;
    JButton moveRight;
    JLabel[] space;
    int count;


    public Exec2() {
        setBounds(100, 100, 250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        JPanel spacesPane = new JPanel();
        JPanel buttonPane = new JPanel();

        space = new JLabel[5];
        for(int i = 0; i < space.length; i++) {
            if(i == 2) {
                space[i] = new JLabel("・");
            }else {
                space[i] = new JLabel(" ");                
            }
            space[i].setBorder(new LineBorder(Color.BLACK));
            space[i].setFont(new Font("",0 ,45));
            spacesPane.add(space[i]);
        }
        

        spacesPane.setLayout(new GridLayout(1, 5));


        moveLeft = new JButton("←");
        moveRight = new JButton("→");
        buttonPane.add(moveLeft);
        buttonPane.add(moveRight);

        contentPane.setLayout(new GridLayout(3,1));
        contentPane.add(new JPanel());
        contentPane.add(spacesPane);

        contentPane.add(buttonPane);

        moveLeft.addActionListener(this);
        moveRight.addActionListener(this);

        count = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == moveRight) {
            count++;
            if(count == 3) {
                count = -2;
            }
            switch(count) {
                case -2 :
                    space[4].setText(" ");
                    space[0].setText("・");
                    space[1].setText(" ");
                    break;
                case -1 :
                    space[0].setText(" ");
                    space[1].setText("・");
                    space[2].setText(" ");
                    break;
                case 0:
                    space[1].setText(" ");
                    space[2].setText("・");
                    space[3].setText(" ");
                    break;
                case 1 :
                    space[2].setText(" ");
                    space[3].setText("・");
                    space[4].setText(" ");
                    break;
                case 2 :
                    space[3].setText(" ");
                    space[4].setText("・");
                    space[0].setText(" ");
                    break;

            }
        }else {
            count--;
            if(count == -3) {
                count = 2;
            }
            switch(count) {
                case -2 :
                    space[4].setText(" ");
                    space[0].setText("・");
                    space[1].setText(" ");
                    break;
                case -1 :
                    space[0].setText(" ");
                    space[1].setText("・");
                    space[2].setText(" ");
                    break;
                case 0:
                    space[1].setText(" ");
                    space[2].setText("・");
                    space[3].setText(" ");
                    break;
                case 1 :
                    space[2].setText(" ");
                    space[3].setText("・");
                    space[4].setText(" ");
                    break;
                case 2 :
                    space[3].setText(" ");
                    space[4].setText("・");
                    space[0].setText(" ");
                    break;
            }

        }
    }
}