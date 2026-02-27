package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.ManagerLinkedList;
import co.edu.uptc.view.ConsoleView;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class Runner {

    public void run() {

        //ModelInterface model = new ManagerList();
        ModelInterface model = new ManagerLinkedList();
        ViewInterface view = new ConsoleView();
        PresenterInterface presenter = new MainPresenter();

        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);

        view.start();
    }
}
