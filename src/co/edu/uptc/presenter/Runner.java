package co.edu.uptc.presenter;

import co.edu.uptc.model.ManagerList;
import co.edu.uptc.view.ConsoleView;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class Runner {

    public void run() {

        ManagerList model = new ManagerList();
        //ManagerLinkedList model = new ManagerLinkedList();
        ConsoleView view = new ConsoleView();
        MainPresenter presenter = new MainPresenter();

        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);

        view.start();
    }
}
