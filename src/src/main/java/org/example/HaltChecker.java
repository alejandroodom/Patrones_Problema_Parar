package org.example;

import java.util.ArrayList;
import java.util.List;

public class HaltChecker {
    private static HaltChecker instance;
    private List<HaltObserver> observers;
    private StopAlgorithm stopAlgorithm;

    private HaltChecker() {
        observers = new ArrayList<>();
        stopAlgorithm = new DefaultStopAlgorithm();
    }

    public static HaltChecker getInstance() {
        if (instance == null) {
            instance = new HaltChecker();
        }
        return instance;
    }

    public void setStopAlgorithm(StopAlgorithm algorithm) {
        stopAlgorithm = algorithm;
    }

    public void addObserver(HaltObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(HaltObserver observer) {
        observers.remove(observer);
    }

    public String checkProgram(Program program, Input input) {
        String result = program.run(input);
        if(stopAlgorithm.shouldStop(input.getNumber())) {
            notifyObservers("para");
            return "para";
        }else if(!(stopAlgorithm.shouldStop(input.getNumber()))) {
            notifyObservers("nunca");
            return "nunca";
        }else{
            return "desconocido";
        }
    }

    private void notifyObservers(String status) {
        for (HaltObserver observer : observers) {
            observer.update(status);
        }
    }
}
