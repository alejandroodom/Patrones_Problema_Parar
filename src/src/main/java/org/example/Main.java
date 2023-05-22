package org.example;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        Input input = new Input(10000); //En esta instacia el programa se detendrá, introduciendo un input menor o igual que 0, se ejecutará infinitamente.
        HaltChecker haltChecker = HaltChecker.getInstance();
        Reverser reverser = new Reverser(haltChecker);

        haltChecker.setStopAlgorithm(new InfiniteStopAlgorithm());
        reverser.reverse(program, input);
    }
}