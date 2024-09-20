package org.example;

public class Exception2 {
    private int numeros[] = {1, 2, 4, 8, 16, 32, 64};
    private int denomin[] = {1, 4, 6, 0, 10};

    public void exception() {
        for(int i = 0; i < numeros.length; i++) {
            try {
                float n = numeros[i] / denomin[i];
                System.out.println(numeros[i] + " / " + denomin[i] + " = " + n);
            } catch(ArithmeticException e) {
                System.out.println("A operação matemática desejada é inválida");
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("O índice não existe");
            }
        }
    }
}