package org.example;

public class Reverser implements HaltObserver{
    private HaltChecker haltChecker;

    public Reverser(HaltChecker haltChecker) {
        this.haltChecker = haltChecker;
        haltChecker.addObserver(this);
    }

    public void reverse(Program program, Input input) {
        String result = haltChecker.checkProgram(program, input);

        while (result.equals ("para")) {
            System.out.println("Se ejecuta");
            //reverse(program, input);
            result = haltChecker.checkProgram(program, input);
        }
        if (result.equals("nunca")) {
            System.out.println("Termina");
        }
    }
    public void update(String status) {
        if (status.equals("para")) {
            System.out.println("El programa se ha detenido");
        } else if (status.equals("nunca")) {
            System.out.println("El programa es infinito");
        }
    }
}
