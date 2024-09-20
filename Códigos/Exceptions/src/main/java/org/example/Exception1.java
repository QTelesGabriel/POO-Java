package org.example;

import java.util.ArrayList;

public class Exception1 {

    private int[] numeros;

    public void exception() {
        try {
            numeros = new int[4];
            numeros[5] = 0;
            System.out.println("Esse texto não vai aparecer");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Exceção ao acessar índice inexistente");
        }

        System.out.println("Este texto vai aparecer após a exceção");
    }

}
