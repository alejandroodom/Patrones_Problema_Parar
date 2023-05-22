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
            System.out.println("Reverser: Se ejecuta");
            haltChecker.checkProgram(program, input);
        }
        if (result.equals("nunca")) {
            System.out.println("Reverser: Termina");
        }
    }
    public void update(String status) {
        if (status.equals("para")) {
            System.out.println("HaltChecker: El programa se ha detenido");
        } else if (status.equals("nunca")) {
            System.out.println("HaltChecker: El programa es infinito");
        }
    }
}
