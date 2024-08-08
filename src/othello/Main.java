package othello;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        view.updateController(controller);
        
        view.setVisible(true);
    }

}
