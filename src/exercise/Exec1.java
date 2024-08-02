package exercise;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exec1 extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Exec1("来場者数カウンター").setVisible(true);
        
    }
    
    JButton addButton;
    JButton subButton;
    JLabel counter;
    int count = 0;

    public Exec1(String title) {
        setTitle(title);
        setBounds(100, 100, 200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane(); 

        counter = new JLabel(String.valueOf(count), JLabel.CENTER);
        contentPane.add(counter, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        this.addButton = new JButton("+");
        this.subButton = new JButton("-");
        
        panel.add(subButton);
        panel.add(addButton);

        contentPane.add(panel, BorderLayout.SOUTH);
        
        addButton.addActionListener(this);
        subButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton) {
            count++;
        }else if(e.getSource() == subButton) {
            count--;
        }
        counter.setText(String.valueOf(count));
    }
}

