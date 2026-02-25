/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.interfaces;

import co.edu.uptc.model.Product;

/**
 *
 * @author Yulian Alexis Tobar Rios
 * @author Maryory Patricia Orozco
 */
public interface ModelInterface {

    void addEnd(Product product);

    String showProducts();

    String sortByName();

    String deleteByName(String name);
}
