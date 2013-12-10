package core;

public interface Calculatable<T> {
    T plus(T t);

    T square();

    T divide(double n);

    T minus(T t);

    T squareRoot();
}
