package org.example;

public class InfiniteStopAlgorithm implements StopAlgorithm{
    @Override
    public boolean shouldStop(int counter) {
        return counter >= 100000000;
    }
}
