package org.example;

import java.util.Scanner;

public class Exception5 {
    private double num;

    public void exception() {
        try {
            System.out.println("Digite um número: ");
            System.out.printf("-> ");
            this.num = leNumero();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static double leNumero() throws Exception {
        Scanner scanner = new Scanner(System.in);
        double numero = scanner.nextDouble();
        scanner.close();

        return numero;
    }
}
