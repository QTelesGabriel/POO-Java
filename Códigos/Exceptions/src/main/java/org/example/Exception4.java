package org.example;

public class Exception4 {
    private int numeros[] = {1, 2, 4, 8, 16, 32, 64};
    private int denomin[] = {1, 4, 6, 0, 10};

    public void exception() {
        for(int i = 0; i < numeros.length; i++) {
            try {
                float n = numeros[i] / denomin[i];
                System.out.println(numeros[i] + " / " + denomin[i] + " = " + n);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
