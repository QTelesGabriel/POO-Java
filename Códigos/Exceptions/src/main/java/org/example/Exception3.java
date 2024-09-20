package org.example;

public class Exception3 {
    private int numeros[] = {0, 1, 2, 3, 4, 5, 6};

    public void exception() {
        for(int i = 0; i < 10; i++) {
            try {
                System.out.println(numeros[i] + " ");
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("#");
            } finally {
                System.out.println("Ok");
            }
        }
    }
}
