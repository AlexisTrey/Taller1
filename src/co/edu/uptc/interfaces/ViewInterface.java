package co.edu.uptc.interfaces;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public interface ViewInterface {

    void setPresenter(PresenterInterface presenter);

    void showMessage(String message);

    void start();
}
