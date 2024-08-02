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
    int xCount;
    int yCount;
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
        

        
        upperLeft = new JButton("↖");
        upper = new JButton("↑");
        upperRight = new JButton("↗");
        left = new JButton("←");
        center = new JButton("・");
        right = new JButton("→");
        lowerLeft = new JButton("↙");
        lower = new JButton("↓");
        lowerRight = new JButton("↘");
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(3,3));
        buttonPane.add(upperLeft);
        buttonPane.add(upper);
        buttonPane.add(upperRight);
        buttonPane.add(left);
        buttonPane.add(center);
        buttonPane.add(right);
        buttonPane.add(lowerLeft);
        buttonPane.add(lower);
        buttonPane.add(lowerRight);
        
        contentPane.setLayout(new GridLayout(2,1));
        contentPane.add(spacePane);
        contentPane.add(buttonPane);
        
        upperLeft.addActionListener(this);
        upper.addActionListener(this);
        upperRight.addActionListener(this);
        left.addActionListener(this);
        center.addActionListener(this);
        right.addActionListener(this);
        lowerLeft.addActionListener(this);
        lower.addActionListener(this);
        lowerRight.addActionListener(this);
        
        xCount = 2;
        yCount = 2;
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
