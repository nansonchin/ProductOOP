/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaFashionAssignment;

import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author guoc7
 */
public class TestDriver {

    /**
     * @param args the command line arguments1
     */
    public static void main(String[] args) {
        File oldFile = new File("Cart.txt");
        oldFile.delete();
        testFashionPosSystem FPS = new testFashionPosSystem();
        FPS.register();
        System.out.println("\n");
        productMenu.menuproduct();

    }
}
