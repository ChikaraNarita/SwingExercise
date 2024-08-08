package othello;

import javax.swing.JButton;

public class Model {
    private int length = 8;
    private int turn = 1;
    private int blackTotal;
    private int whiteTotal;
    private String announce = "黒の番です";
    private String myStone;
    private String opponentStone;
    private JButton[][] space;
    
    public Model() {
        
    }

    public int getLength() {
        return length;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getBlackTotal() {
        return blackTotal;
    }

    public void setBlackTotal(int blackTotal) {
        this.blackTotal = blackTotal;
    }

    public int getWhiteTotal() {
        return whiteTotal;
    }

    public void setWhiteTotal(int whiteTotal) {
        this.whiteTotal = whiteTotal;
    }

    public String getAnnounce() {
        return announce;
    }

    public void setAnnounce(String announce) {
        this.announce = announce;
    }

    public String getMyStone() {
        return myStone;
    }

    public void setMyStone(String myStone) {
        this.myStone = myStone;
    }

    public String getOpponentStone() {
        return opponentStone;
    }

    public void setOpponentStone(String opponentStone) {
        this.opponentStone = opponentStone;
    }

    public JButton[][] getSpace() {
        return space;
    }

    public void setSpace(JButton[][] space) {
        this.space = space;
    }
    
    //空白の盤面を探す。
    public boolean searchFreeSpace(JButton[][] space) {
        stoneCheck();
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(space[i][j].getText().isEmpty()) {
                    if(CanPutUpperLeft(space, i, j) || CanPutUpper(space, i, j) || CanPutUpperRight(space, i, j) ||
                            CanPutLeft(space, i, j) || CanPutRight(space, i, j) || 
                            CanPutLowerLeft(space, i, j) || CanPutLower(space, i, j) || CanPutLowerRight(space, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //空白の箇所から八方を確認し隣に敵石がある&&延長線上に自石があるかを判断（左上）。
    public boolean CanPutUpperLeft(JButton[][] space, int y, int x) {
        if(y != 0 && x != 0 && space[y - 1][x - 1].getText().equals(myStone)) { //左上に相手の石があるかどうか
            for(int i = 2 ; i <= upperLeftCheckLength(y,x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(y - i < 0 || x - i < 0 || space[y - i][x - i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y - i][x - i].getText().equals(opponentStone)) { //あればtrue
                    return true;
                }
            }
        }
        return false;
    } 

    //空白の箇所から八方を確認し隣に敵石がある&&延長線上に自石があるかを判断（上）。
    public boolean CanPutUpper(JButton[][] space, int y, int x) {
        if(y != 0 && space[y -1][x].getText().equals(myStone)) {
            for(int i = 2 ; i <= y; i++ ) {
                if(y - i < 0 || space[y - i][x].getText().isEmpty()) {
                    return false;
                }else if(space[y - i][x].getText().equals(opponentStone)) {
                    return true;
                }
            }
        }
        return false;
    }
    //空白の箇所から八方を確認し隣に敵石がある&&延長線上に自石があるかを判断（右上）。
    public boolean CanPutUpperRight(JButton[][] space, int y, int x) {
        if(y != 0 && x != 7 && space[y - 1][x + 1].getText().equals(myStone)) { //左上に相手の石があるかどうか
            for(int i = 2 ; i <= upperRightCheckLength(y, x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(y - i < 0 || x + i > 7 || space[y - i][x + i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y - i][x + i].getText().equals(opponentStone)) { //あればtrue
                    return true;
                }
            }
        }
        return false;
    }
    //空白の箇所から八方を確認し隣に敵石がある&&延長線上に自石があるかを判断（左）。
    public boolean CanPutLeft(JButton[][] space, int y, int x) {
        if(y != 0 && x != 0 && space[y][x - 1].getText().equals(myStone)) { //左に相手の石があるかどうか
            for(int i = 2 ; i <= x; i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(x - i < 0 || space[y][x - i].getText().isEmpty()) {
                    return false;//無ければ終了
                }else if(space[y][x - i].getText().equals(opponentStone)) { //あればtrue
                    return false;
                }
            }
        }
        return false;
    }

    //空白の箇所から八方を確認し隣に敵石がある&&延長線上に自石があるかを判断（右）。
    public boolean CanPutRight(JButton[][] space, int y, int x) {
        if(y != 7 && x != 7 && space[y + 1][x + 1].getText().equals(myStone)) { //右下に相手の石があるかどうか
            for(int i = 2 ; i <= lowerRightCheckLength(y,x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(x + i > 7 || space[y][x + i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y][x + i].getText().equals(opponentStone)) { //あればtrue
                    return true;
                }
            }
        }
        return false;
    }
    //空白の箇所から八方を確認し隣に敵石がある&&延長線上に自石があるかを判断（左下）。
    public boolean CanPutLowerLeft(JButton[][] space, int y, int x) {
        if(y != 7 && x != 0 && space[y + 1][x - 1].getText().equals(myStone)) { //左下に相手の石があるかどうか
            for(int i = 2 ; i <= lowerLeftCheckLength(y, x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(y + i > 7 || x - i < 0 || space[y + i][x - i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y + i][x - i].getText().equals(opponentStone)) { //あればtrue
                    return true;
                }
            }
        }
        return false;
    }
    //空白の箇所から八方を確認し隣に敵石がある&&延長線上に自石があるかを判断（下）。
    public boolean CanPutLower(JButton[][] space, int y, int x) {
        if(y != 7 && space[y + 1][x].getText().equals(myStone)) {
            for(int i = 2 ; i <= 7 - y; i++ ) {
                if(y + i > 7 || space[y + i][x].getText().isEmpty()) {
                    return false;
                }else if(space[y + i][x].getText().equals(opponentStone)) {
                    return true;
                }
            }
        }
        return false;
    }
    //空白の箇所から八方を確認し隣に敵石がある&&延長線上に自石があるかを判断（右下）。
    public boolean CanPutLowerRight(JButton[][] space, int y, int x) {
        if(y != 7 && x != 7 && space[y + 1][x + 1].getText().equals(myStone)) { //右下に相手の石があるかどうか
            for(int i = 2 ; i <= lowerRightCheckLength(y,x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(y + i > 7 || x + i > 7 || space[y + i][x + i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y + i][x + i].getText().equals(opponentStone)) { //あればtrue
                    return true;
                }
            }
        }
        return false;
    }

    public String countStoneAndJudge(JButton[][] space) {
        int brackStone = 0;
        int whiteStone = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(space[i][j].getText().equals("●")) {
                    brackStone++;
                }else if(space[i][j].getText().equals("⚪")) {
                    whiteStone++;
                }
            }
        }
        if(brackStone > whiteStone) {
            return "黒:%d 白%d 黒の勝ち".formatted(brackStone, whiteStone);
        }else if( whiteStone > brackStone) {
            return "黒:%d 白%d 白の勝ち".formatted(brackStone, whiteStone);
        }else {
            return "黒:%d 白%d 引き分け".formatted(brackStone, whiteStone);
        }
    }

    public boolean spaceFullCheck(JButton[][] space) {//falseの場合はまだ空きがある
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(space[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean upperLeftCheck(int y, int x) {
        stoneCheck();
        if(y != 0 && x != 0 && space[y - 1][x - 1].getText().equals(opponentStone)) { //左上に相手の石があるかどうか
            for(int i = 2 ; i <= upperLeftCheckLength(y,x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(y - i < 0 || x - i < 0 || space[y - i][x - i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y - i][x - i].getText().equals(myStone)) { //あればその間の石を全て自分の石に変更
                    for(int j = 1; j < i; j++) {
                        space[y - j][x -j].setText(myStone);
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public boolean upperCheck(int y, int x) {
        stoneCheck();
        if(y != 0 && space[y -1][x].getText().equals(opponentStone)) {
            for(int i = 2 ; i <= y; i++ ) {
                if(y - i < 0 || space[y - i][x].getText().isEmpty()) {
                    return false;
                }else if(space[y - i][x].getText().equals(myStone)) {
                    for(int j = 1; j < i; j++) {
                        space[y - j][x].setText(myStone);
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public boolean upperRightCheck(int y, int x) {
        stoneCheck();
        if(y != 0 && x != 7 && space[y - 1][x + 1].getText().equals(opponentStone)) { //右上に相手の石があるかどうか
            for(int i = 2 ; i <= upperRightCheckLength(y, x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(y - i < 0 || x + i > 7 || space[y - i][x + i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y - i][x + i].getText().equals(myStone)) { //あればその間の石を全て自分の石に変更
                    for(int j = 1; j < i; j++) {
                        space[y - j][x + j].setText(myStone);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean leftCheck(int y, int x) {
        stoneCheck();
        if(y != 0 && x != 0 && space[y][x - 1].getText().equals(opponentStone)) { //左に相手の石があるかどうか
            for(int i = 2 ; i <= x; i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(x - i < 0 || space[y][x - i].getText().isEmpty()) {
                    return false;//無ければ終了
                }else if(space[y][x - i].getText().equals(myStone)) { //あればその間の石を全て自分の石に変更
                    for(int j = 1; j < i; j++) {
                        space[y][x -j].setText(myStone);
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public boolean rightCheck(int y, int x) {
        stoneCheck();
        if(x != 7 && space[y][x + 1].getText().equals(opponentStone)) { //右に相手の石があるかどうか
            for(int i = 2 ; i <= 8 - (x + 1); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(x + i < 0 || space[y][x + i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y][x + i].getText().equals(myStone)) { //あればその間の石を全て自分の石に変更
                    for(int j = 1; j < i; j++) {
                        space[y][x +j].setText(myStone);
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public boolean lowerLeftCheck(int y, int x) {
        stoneCheck();
        if(y != 7 && x != 0 && space[y + 1][x - 1].getText().equals(opponentStone)) { //左下に相手の石があるかどうか
            for(int i = 2 ; i <= lowerLeftCheckLength(y, x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(y + i < 0 || x - i < 0 || space[y + i][x - i].getText().isEmpty()) {
                    return false; //無ければ終了
                }else if(space[y + i][x - i].getText().equals(myStone)) { //あればその間の石を全て自分の石に変更
                    for(int j = 1; j < i; j++) {
                        space[y + j][x -j].setText(myStone);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean lowerCheck(int y, int x) {
        stoneCheck();
        if(y != 7 && space[y + 1][x].getText().equals(opponentStone)) {
            for(int i = 2 ; i <= 7 - y; i++ ) {
                if(y + i < 0 || space[y + i][x].getText().isEmpty()) {
                    return false;
                }else if(space[y + i][x].getText().equals(myStone)) {
                    for(int j = 1; j < i; j++) {
                        space[y + j][x].setText(myStone);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean lowereRightCheck(int y, int x) {
        stoneCheck();
        if(y != 7 && x != 7 && space[y + 1][x + 1].getText().equals(opponentStone)) { //右下に相手の石があるかどうか
            for(int i = 2 ; i <= lowerRightCheckLength(y,x); i++) { //あった場合その延長線上に自分の石があるか（挟んでいるか）
                if(y + i > 7 || x + i > 7 || space[y + i][x + i].getText().isEmpty()) {
                    return false;//無ければ終了
                }else if(space[y + i][x + i].getText().equals(myStone)) { //あればその間の石を全て自分の石に変更
                    for(int j = 1; j < i; j++) {
                        space[y + j][x + j].setText(myStone);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean omnidirectionalCanput(int y, int x) { //8方向をサーチして石が置けるかどうかを確認
        boolean canput = false;
        if(upperLeftCheck(y, x)) {
            canput = true;
        }
        if(upperCheck(y, x)) {
            canput = true;
        }
        if(upperRightCheck(y, x)) {
            canput = true;
        }
        if(leftCheck(y, x)) {
            canput = true;
        }
        if(rightCheck(y, x)) {
            canput = true;
        }
        if( lowerLeftCheck(y, x)) {
            canput = true;
        }
        if(lowerCheck(y, x)) {
            canput = true;
        }
        if(lowereRightCheck(y, x)) {
            canput = true;
        }
        return canput;
    }

    public void stoneCheck() {
        if(turn % 2 != 0) {
            myStone = "●";
            opponentStone ="⚪";
        }else {
            myStone = "⚪";
            opponentStone ="●";
        }
    }
    public int upperLeftCheckLength(int y ,int  x) { //upperLeftCheckの回数計算
        if(x < y){
            return x ;
        }else {
            return y;
        }
    }
    public int upperRightCheckLength(int y, int x) { //upperRightCheckの回数計算
        if(x < 8 - y) {
            return y;
        }
        return 8 - (x + 1);
    }
    public int lowerLeftCheckLength(int y, int x) { //lowerLeftCheckの回数計算
        if(x < 8 - y) {
            return x;
        }
        return 8 - (y + 1);
    }

    public int lowerRightCheckLength(int y, int x) { //lowerRightCheckの回数計算
        if(y <= x) {
            return 7 - y;
        }
        return 7 - x;
    }


    public boolean  blackStoneElominationCheck() {//falseだと全滅、負けとなる
        int blackCount = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length ; j++) {
                if(space[i][j].getText().equals("●")) {
                    blackCount++;
                }
            }
        }
        return blackCount > 0;
    }
    public boolean  whiteStoneElominationCheck() {//falseだと全滅、負けとなる
        int whiteCount = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length ; j++) {
                if(space[i][j].getText().equals("⚪")) {
                    whiteCount++;
                }
            }
        }
        return whiteCount > 0;
    }

}
