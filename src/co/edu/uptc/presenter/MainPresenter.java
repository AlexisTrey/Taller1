/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.Product;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class MainPresenter implements PresenterInterface {

    private ViewInterface view;
    private ModelInterface model;

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void addEnd(Product product) {
        model.addEnd(product);
        view.showMessage("Producto agregado correctamente.");
    }

    @Override
    public void showProducts() {
        view.showMessage(model.showProducts());
    }

    @Override
    public void sortByName() {
        view.showMessage(model.sortByName());
    }

    @Override
    public void deleteByName(String name) {
        view.showMessage(model.deleteByName(name));
    }
}
