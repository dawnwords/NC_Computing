package core;

import java.util.List;

public class Calculator<T extends Calculatable<T>> {
    public T average(List<T> ts) {
        T sum = ts.get(0);
        for (int i = 1; i < ts.size(); i++) {
            sum = sum.plus(ts.get(i));
        }
        return sum.divide(ts.size());
    }

    public T sd(List<T> ts) {
        T squareAverage = average(ts).square();
        T squareSum = ts.get(0).square();

        for (int i = 1; i < ts.size(); i++) {
            squareSum = squareSum.plus(ts.get(i).square());
        }
        return squareSum.divide(ts.size()).minus(squareAverage);
    }
}
