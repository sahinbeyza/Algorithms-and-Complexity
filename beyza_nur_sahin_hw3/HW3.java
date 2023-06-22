/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beyza_nur_sahin_hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beyza
 */
public class HW3 implements HW3_2Interface {

    // 2 boyutlu matris oluşturma
    private int[][] matrix;
    // list to store the shapes
    private List<List<String>> shapes;

    @Override
    public void read_file(String filepath) {
        // read the file and store the matrix
        try ( BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            BufferedReader br1 = new BufferedReader(new FileReader(filepath));

            String lineforcolumn;
            int row = 0; //satır
            int column = 0;
            while ((lineforcolumn = br1.readLine()) != null) {

                row++;                                      
                column = lineforcolumn.split(" ").length;         //column ve row sayısı belirlenir

            }
            //System.out.println(row);
            //System.out.println(column);
            matrix = new int[row][column];
            row = 0;
            System.out.println(matrix.length);
            System.out.println(matrix[0].length);
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");    //boşluk 
                for (int col = 0; col < values.length; col++) {
                    matrix[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String find_figures() {
        // initialize the list to store the shapes
        shapes = new ArrayList<>();
        // iterate through the matrix and find the shapes
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                // if the current cell is a 1, then it is part of a shape
                if (matrix[row][col] == 1) {
                    // create a new shape and add it to the list
                    List<String> shape = new ArrayList<>();
                    shapes.add(shape);
                    // mark the cell as visited
                    matrix[row][col] = -1;
                    // DFS kullanarak şeklin geri kalan hücrelerini bul.
                    dfs(row, col, shape);
                }
            }
        }
        // return the count and shapes as a string
        return getShapeString();
    }

    // üst, alt, sol, sağ, üst-sol, üst-sağ, alt-sol, alt-sağ kontrol ederve 1'ler ise şekle ekler.
    private void dfs(int row, int col, List<String> shape) {
        // add the current cell to the shape mevcut hücreyi ekle.
        shape.add(row + " " + col);
        // check the adjacent cells (top, bottom, left, right, top-left, top-right,
        // bottom-left, bottom-right)
        if (row > 0 && col > 0 && matrix[row - 1][col - 1] == 1) {
            // hücreyi ziyaret edildi olarak işaretle
            matrix[row - 1][col - 1] = -1;
            // şekildeki hücrelerin geri kalanını bul
            dfs(row - 1, col - 1, shape);
        }
        if (row > 0 && matrix[row - 1][col] == 1) {
            // hücreyi ziyaret edildi olarak işaretle
            matrix[row - 1][col] = -1;

            dfs(row - 1, col, shape);
        }
        if (row > 0 && col < matrix[0].length - 1 && matrix[row - 1][col + 1] == 1) {
            // hücreyi ziyaret edildi olarak işaretle
            matrix[row - 1][col + 1] = -1;

            dfs(row - 1, col + 1, shape);
        }
        if (col > 0 && matrix[row][col - 1] == 1) {
            // hücreyi ziyaret edildi olarak işaretle
            matrix[row][col - 1] = -1;

            dfs(row, col - 1, shape);
        }
        if (col < matrix[0].length - 1 && matrix[row][col + 1] == 1) {
            // hücreyi ziyaret edildi olarak işaretle
            matrix[row][col + 1] = -1;

            dfs(row, col + 1, shape);
        }
        if (row < matrix.length - 1 && col > 0 && matrix[row + 1][col - 1] == 1) {
            // hücreyi ziyaret edildi olarak işaretle
            matrix[row + 1][col - 1] = -1;

            dfs(row + 1, col - 1, shape);
        }
        if (row < matrix.length - 1 && matrix[row + 1][col] == 1) {
            // hücreyi ziyaret edildi olarak işaretle
            matrix[row + 1][col] = -1;

            dfs(row + 1, col, shape);
        }
        if (row < matrix.length - 1 && col < matrix[0].length - 1 && matrix[row + 1][col + 1] == 1) {
            // hücreyi ziyaret edildi olarak işaretle
            matrix[row + 1][col + 1] = -1;

            dfs(row + 1, col + 1, shape);
        }
    }

    // method to get the count and shapes as a string
    private String getShapeString() {
        StringBuilder sb = new StringBuilder();
        sb.append("There are ").append(shapes.size()).append(" shapes\n");  // şeklin size belirlenir
        for (int i = 0; i < shapes.size(); i++) {
            sb.append("Shape ").append(i + 1).append("\n");
            List<String> shape = shapes.get(i);
            // find the min and max row and column indices of the shape
            int minRow = Integer.MAX_VALUE, maxRow = Integer.MIN_VALUE, minCol = Integer.MAX_VALUE,
                    maxCol = Integer.MIN_VALUE;
            for (String cell : shape) {
                String[] indeks = cell.split(" ");
                int row = Integer.parseInt(indeks[0]);
                int col = Integer.parseInt(indeks[1]);
                minRow = Math.min(minRow, row);
                maxRow = Math.max(maxRow, row);
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
            }
            // print the shape to the string builder
            for (int row = minRow; row <= maxRow; row++) {
                for (int col = minCol; col <= maxCol; col++) {
                    sb.append(shape.contains(row + " " + col) ? "*" : " ").append(" ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public void print_figures(String myfigures) {
        // print the figures to the screen
        System.out.print(myfigures);
    }

    @Override
    public void print_figures_to_file(String myfigures) {
        // write the figures to a file
        try ( FileWriter fw = new FileWriter(new File("output.txt"))) {
            fw.write(myfigures);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
