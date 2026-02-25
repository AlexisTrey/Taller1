package co.edu.uptc.interfaces;

import co.edu.uptc.model.Product;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public interface PresenterInterface {

    void setView(ViewInterface view);

    void setModel(ModelInterface model);

    void addEnd(Product product);

    void showProducts();

    void sortByName();

    void deleteByName(String name);
}
