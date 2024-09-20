package org.example;

public class Exception6 {
    private int numeros[] = {2, 22, 5, 8, 9, 32, 64};
    private int denomin[] = {2, 8, 10, 6, 0, 12};

    public void exception() {
        for(int i = 0; i < numeros.length; i++) {
            try {
                if(numeros[i] % 2 != 0) {
                    // Criar Exception
                    throw new DivisaoNaoExata(numeros[i], denomin[i]);
                }
                float n = numeros[i] / denomin[i];
                System.out.println(numeros[i] + " / " + denomin[i] + " = " + n);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
