package org.example;

public class Program {
    public Program() {
    }

    public String run(Input input) {
        int contador = input.getNumber();
        while (true) {
            if (contador >= 100000000) {
                // Si el contador alcanza un límite máximo de iteraciones, en este caso 100000000, se considera que el bucle es infinito y se devuelve "nunca".
                return "nunca";
            }

            if (contador == 0) {
                // Si se cumple alguna condición de parada basada en el estado del cálculo y el input (que sea igual a 0 en este caso), se devuelve "para" para indicar que el bucle se detiene.
                return "para";
            }
            contador++;
        }
    }

}
