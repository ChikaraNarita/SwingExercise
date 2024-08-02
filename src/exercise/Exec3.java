package exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Exec3 extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Exec3().setVisible(true);
    }

    JButton upperLeft;
    JButton upper;
    JButton upperRight;
    JButton left;
    JButton center;
    JButton right;
    JButton lowerLeft;
    JButton lower;
    JButton lowerRight;
    int xCount = 2;
    int yCount = 2;
    List<JLabel[]> spaces = new ArrayList<JLabel[]>(); 
    
    public Exec3() {
        setBounds(100, 100, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        
        JPanel spacePane = new JPanel();
        spacePane.setLayout(new GridLayout(5,5));
        
        for(int i = 0; i < 5; i++) {
            JLabel[] space = new JLabel[5];
            for(int j = 0; j < space.length; j++) {
                space[j] = new JLabel(" ");
                space[j].setBorder(new LineBorder(Color.BLACK));
                space[j].setFont(new Font("",0 ,15));
                space[j].setHorizontalAlignment(JTextField.CENTER);
            }
            spaces.add(space);
            for(int k = 0; k < space.length; k++) {
                if(i == 2 && k == 2) {
                    spaces.get(i)[k].setText("●");
                }
                spacePane.add(spaces.get(i)[k]);
            }
        }   
        
        List<JButton> button = new ArrayList<JButton>();
        
        button.add(upperLeft = new JButton("↖"));
        button.add(upper = new JButton("↑"));
        button.add(upperRight = new JButton("↗"));
        button.add(left = new JButton("←"));
        button.add(center = new JButton("・"));
        button.add(right = new JButton("→"));
        button.add(lowerLeft = new JButton("↙"));
        button.add(lower = new JButton("↓"));
        button.add(lowerRight = new JButton("↘"));
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(3,3));
        for(JButton b : button) {
            buttonPane.add(b);
        }
 
        contentPane.setLayout(new GridLayout(2,1));
        contentPane.add(spacePane);
        contentPane.add(buttonPane);
        
        for(JButton b : button) {
            b.addActionListener(this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        spaces.get(yCount)[xCount].setText(" ");
        if(e.getSource() == upperLeft) {
            xCount -= 1;
            yCount -= 1;
            if(yCount == -1) {
                yCount = 4 - (xCount + 1);
                xCount = 4;
            }else if(xCount == -1) {
                xCount = 4 - (yCount + 1);
                yCount = 4;
            }
        }else if(e.getSource() == upper) {            
            yCount -= 1;
            if(yCount == -1) {
                yCount = 4;
            }
        }else if(e.getSource() == upperRight) {
            xCount += 1;
            yCount -= 1;
            if(yCount == -1) {
                yCount = xCount - 1;
                xCount = 0;
            }else if(xCount == 5) {
                xCount = yCount + 1;
                yCount = 4;
            }
            
        }else if(e.getSource() == left) {
            xCount -= 1;
            if(xCount == -1) {
                xCount = 4;
            }
        }else if(e.getSource() == center) {
            xCount = 2;
            yCount = 2;
            
        }else if(e.getSource() == right) {
            xCount += 1;
            if(xCount == 5) {
                xCount = 0;
            }
        }else if(e.getSource() == lowerLeft) {
            xCount -= 1;
            yCount += 1;
            if(yCount == 5) {
                yCount = xCount + 1;
                xCount = 4;
            }else if(xCount == -1) {
                xCount = yCount - 1;
                yCount = 0;
            }
            
        }else if(e.getSource() == lower) {
            yCount += 1;
            if(yCount == 5) {
                yCount = 0;
            }
        }else if(e.getSource() == lowerRight) {
            xCount += 1;
            yCount += 1;
            if(xCount == 5) {
                xCount = 4 - (yCount - 1);
                yCount = 0;
            }else if(yCount == 5) {
                yCount = 4 - (xCount - 1);
                xCount = 0;
            }
        }
        spaces.get(yCount)[xCount].setText("●");
       
    }
}
