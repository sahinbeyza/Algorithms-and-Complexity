/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package beyza_nur_sahin_hw3;

/**
 *
 * @author Beyza
 */
public class Beyza_Nur_Sahin_HW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HW3 deneme = new HW3();
        deneme.read_file("HW3Q2.txt");
        String figures = deneme.find_figures();
        deneme.print_figures(figures);
        deneme.print_figures_to_file(figures);

    }

}
