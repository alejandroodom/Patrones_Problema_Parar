package org.example;

public class DefaultStopAlgorithm implements StopAlgorithm{
    @Override
    public boolean shouldStop(int counter) {
        return counter == 0;
    }
}
