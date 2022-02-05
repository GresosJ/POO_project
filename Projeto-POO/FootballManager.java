import java.util.Observer;

public class FootballManager {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);

        model.addObserver(controller);
        controller.addObserver(view);

        view.runView();
    }
}
