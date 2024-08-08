package othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class View extends JFrame {
    Model model;
    Controller controller;
    JLabel announceLabel;
    
    public View(Model model) {
        
        setBounds(100, 100, 500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        JPanel boardPane = new JPanel();        //盤面(8×8)パネル作成、デザイン
        boardPane.setBackground(Color.WHITE);
        GridLayout grid = new GridLayout(model.getLength(),model.getLength());
        grid.setHgap(2);
        grid.setVgap(2);
        boardPane.setLayout(grid);  
        contentPane.add(boardPane);

        JPanel spaceserWest = new JPanel();     //上左右の余白用パネルの作成
        JPanel spaceserEast = new JPanel();
        JPanel spaceserNorth = new JPanel();
        spaceserWest.add(new JLabel("          "));
        spaceserEast.add(new JLabel("          "));
        spaceserNorth.add(new JLabel("          "));
        contentPane.add(spaceserWest, BorderLayout.WEST);
        contentPane.add(spaceserEast, BorderLayout.EAST);
        contentPane.add(spaceserNorth, BorderLayout.NORTH);


        JPanel announcePane = new JPanel();     //下段（アナウンス）パネル作成
        announceLabel = new JLabel(model.getAnnounce());
        announcePane.add(announceLabel);
        contentPane.add(announcePane, BorderLayout.SOUTH);

        model.setSpace(new JButton[model.getLength()][model.getLength()]);        //ボードにボタンを入れ、押された箇所により処理。
        ActionListener action = createActionListener();
        for(int i = 0; i < model.getLength(); i++) {
            for(int j = 0; j < model.getLength(); j++) {
                model.getSpace()[i][j] = new JButton();
                if(i == model.getLength() / 2 - 1 && j == model.getLength() / 2 - 1 || i == model.getLength() / 2 && j == model.getLength() / 2) {
                    model.getSpace()[i][j] = new JButton("●");
                }else if(i == model.getLength() / 2 - 1 && j == model.getLength() / 2 || i == model.getLength() / 2 && j == model.getLength() / 2 - 1) {
                    model.getSpace()[i][j] = new JButton("⚪");
                }
                model.getSpace()[i][j].setBackground(Color.GREEN);
                model.getSpace()[i][j].setBorder(new EtchedBorder(EtchedBorder.RAISED));
                model.getSpace()[i][j].addActionListener(action);
                boardPane.add(model.getSpace()[i][j]);
            }
        }
    }
    
    
    
    public JLabel getAnnounceLabel() {
        return announceLabel;
    }



    public void updateController(Controller controller) {
        this.controller = controller;
        
    }
    public ActionListener createActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.buttonAction(e);
            }
        };
    }

}
