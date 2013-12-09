package data;

import java.lang.reflect.Field;

import core.Calculatable;

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
    result.bestFitness = Double.parseDouble(tokens[0]);
    result.averageFitness = Double.parseDouble(tokens[1]);
    result.averageUsedGeneLength = Double.parseDouble(tokens[2]);
    result.time = Integer.parseInt(tokens[3]);
    result.invalids = Integer.parseInt(tokens[4]);
    result.varFitness = Double.parseDouble(tokens[5]);
    result.aveLength = Double.parseDouble(tokens[6]);
    result.aveDerivationTreeDepth = Double.parseDouble(tokens[7]);
    result.slopeMutRate = Double.parseDouble(tokens[8]);
    return result;
  }

  @Override
  public Row plus(Row row) {
    Row result = new Row();
    result.bestFitness = bestFitness + row.bestFitness;
    result.averageFitness = averageFitness + row.averageFitness;
    result.averageUsedGeneLength = averageUsedGeneLength + row.averageUsedGeneLength;
    result.time = time + row.time;
    result.invalids = invalids + row.invalids;
    result.varFitness = varFitness + row.varFitness;
    result.aveLength = aveLength + row.aveLength;
    result.aveDerivationTreeDepth = aveDerivationTreeDepth + row.aveDerivationTreeDepth;
    result.slopeMutRate = slopeMutRate + row.slopeMutRate;
    return result;
  }

  @Override
  public Row square() {
    Row result = new Row();
    result.bestFitness = bestFitness * bestFitness;
    result.averageFitness = averageFitness * averageFitness;
    result.averageUsedGeneLength = averageUsedGeneLength * averageUsedGeneLength;
    result.time = time * time;
    result.invalids = invalids * invalids;
    result.varFitness = varFitness * varFitness;
    result.aveLength = aveLength * aveLength;
    result.aveDerivationTreeDepth = aveDerivationTreeDepth * aveDerivationTreeDepth;
    result.slopeMutRate = slopeMutRate * slopeMutRate;
    return result;
  }

  @Override
  public Row divide(double n) {
    Row result = new Row();
    result.bestFitness = bestFitness / n;
    result.averageFitness = averageFitness / n;
    result.averageUsedGeneLength = averageUsedGeneLength / n;
    result.time = time / n;
    result.invalids = invalids / n;
    result.varFitness = varFitness / n;
    result.aveLength = aveLength / n;
    result.aveDerivationTreeDepth = aveDerivationTreeDepth / n;
    result.slopeMutRate = slopeMutRate / n;
    return result;
  }

  @Override
  public Row minus(Row row) {
    Row result = new Row();
    result.bestFitness = bestFitness - row.bestFitness;
    result.averageFitness = averageFitness - row.averageFitness;
    result.averageUsedGeneLength = averageUsedGeneLength - row.averageUsedGeneLength;
    result.time = time - row.time;
    result.invalids = invalids - row.invalids;
    result.varFitness = varFitness - row.varFitness;
    result.aveLength = aveLength - row.aveLength;
    result.aveDerivationTreeDepth = aveDerivationTreeDepth - row.aveDerivationTreeDepth;
    result.slopeMutRate = slopeMutRate - row.slopeMutRate;
    return result;
  }

  @Override
  public String toString() {
    String result = "";
    try {
      for (Field field : getClass().getFields()) {
        result += field.get(this) + " ";
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
