package data;

import core.Calculatable;

import java.lang.reflect.Field;

public class Row implements Calculatable<Row> {
    public double bestFitness;
    public double averageFitness;
    public double averageUsedGeneLength;
    public double time;
    public double invalids;
    public double varFitness;
    public double aveLength;
    public double aveDerivationTreeDepth;
    public double slopeMutRate;

    public static Row parse(String line) {
        Row result = new Row();
        String[] tokens = line.split(" ");
        int i = 0;
        try {
            for (Field field : Row.class.getFields()) {
                field.set(result, Double.parseDouble(tokens[i++]));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Row plus(Row row) {
        Row result = new Row();
        try {
            for (Field field : getClass().getFields()) {
                double value1 = (Double) field.get(this);
                double value2 = (Double) field.get(row);
                field.set(result, value1 + value2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Row square() {
        Row result = new Row();
        try {
            for (Field field : getClass().getFields()) {
                double value = (Double) field.get(this);
                field.set(result, value * value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Row divide(double n) {
        Row result = new Row();
        try {
            for (Field field : getClass().getFields()) {
                double value = (Double) field.get(this);
                field.set(result, value / n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Row minus(Row row) {
        Row result = new Row();
        try {
            for (Field field : getClass().getFields()) {
                double value1 = (Double) field.get(this);
                double value2 = (Double) field.get(row);
                field.set(result, value1 - value2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Row squareRoot() {
        Row result = new Row();
        try {
            for (Field field : getClass().getFields()) {
                double value = (Double) field.get(this);
                field.set(result, Math.sqrt(value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        try {
            for (Field field : getClass().getFields()) {
                result += field.get(this) + "\t";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
