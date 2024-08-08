package othello;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Controller {
    Model model;
    View view;
    public Controller(Model model, othello.View view) {
        this.model = model;
        this.view = view;
    }

    public void buttonAction(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        int x = 0, y = 0;
        for (int i = 0; i < model.getLength(); i++) {
            for (int j = 0; j < model.getLength(); j++) {
                if (button == model.getSpace()[i][j]) {
                    y = i; 
                    x = j;
                    break;
                }
            }
        }
        System.out.println(model.getTurn());
        if(!button.getText().isEmpty()) {
            if(model.getTurn() % 2 != 0) {
                model.setAnnounce("そのマスには置けません。黒の番です");
            }else {
                model.setAnnounce("そのマスには置けません。白の番です"); 
            }
            return;
        }
        if(!model.omnidirectionalCanput(y, x)) {//置ける条件がそろっていないと置けない
            if(model.getTurn() % 2 != 0) {
                view.getAnnounceLabel().setText("そのマスには置けません。黒の番です");
               }else {
               view.getAnnounceLabel().setText("そのマスには置けません。白の番です"); 
               }
            return;
        }
        if(model.getTurn() % 2 != 0) {
             view.getAnnounceLabel().setText("白の番です");
            model.getSpace()[y][x].setText("●");
        }else {
            view.getAnnounceLabel().setText("黒の番です");
            model.getSpace()[y][x].setText("⚪"); 
        }
        if(model.spaceFullCheck(model.getSpace())) { //ボードに全て石を置くとゲーム終了
            view.getAnnounceLabel().setText("ゲーム終了。" + model.countStoneAndJudge(model.getSpace()));
            return;
        }
        if(!model.blackStoneElominationCheck()){//石が方色のみになると終了
            view.getAnnounceLabel().setText("ゲーム終了。" + model.countStoneAndJudge(model.getSpace()));
            return;
        }
        if(!model.whiteStoneElominationCheck()){//石が方色のみになると終了
            view.getAnnounceLabel().setText("ゲーム終了。" + model.countStoneAndJudge(model.getSpace()));
            return;
        }
        if(!model.searchFreeSpace(model.getSpace())) {
            model.setTurn(model.getTurn() + 2);
            if(model.getTurn() % 2 != 0) {
                view.getAnnounceLabel().setText("パス。黒の番です");
            }else {
                view.getAnnounceLabel().setText("パス。白の番です"); 
            }
            return;
        }
        model.setTurn(model.getTurn() + 1);
    }
}
