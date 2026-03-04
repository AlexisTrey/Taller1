/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.view;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.util.Utilities;

import java.util.Scanner;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public class ConsoleView implements ViewInterface {

    private PresenterInterface presenter;
    private Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;

    private final MainMenu mainMenu;
    private final ProductReader productReader;
    private final ActionDelete actionDelete;

    public ConsoleView() {
        this.mainMenu = new MainMenu(scanner);
        this.productReader = new ProductReader(scanner);
        this.actionDelete = new ActionDelete(scanner);
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMessage(String message) {
        System.out.println(Utilities.VERDE + "\n" + message + Utilities.RESET);
    }

    @Override
    public void start() {
        while (isRunning) {
            String option = mainMenu.showOption();
            processOption(option);
        }
    }

    private void processOption(String option) {
        switch (option) {
            case "1":
                addProduct();
                break;
            case "2":
                presenter.showProducts();
                break;
            case "3":
                presenter.sortByName();
                break;
            case "4":
                actionDelete.delete(presenter);
                break;
            case "0":
                isRunning = false;
                System.out.println(Utilities.AZUL + "\nSaliendo..." + Utilities.RESET);
                break;
            default:
                System.out.println(Utilities.ROJO + "\nOpcion invalida." + Utilities.RESET);
        }
    }

    private void addProduct() {
        Product p = productReader.readProduct();
        if (p != null) {
            presenter.addEnd(p);
        }
    }

}
