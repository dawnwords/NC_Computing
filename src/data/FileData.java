package data;

import core.Calculatable;

import java.util.ArrayList;
import java.util.List;

public class FileData implements Calculatable<FileData> {
    private List<Row> rows;

    public FileData(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public FileData plus(FileData filedata) {
        ArrayList<Row> result = new ArrayList<Row>();
        for (int i = 0; i < rows.size(); i++) {
            result.add(rows.get(i).plus(filedata.rows.get(i)));
        }
        return new FileData(result);
    }

    @Override
    public FileData square() {
        ArrayList<Row> result = new ArrayList<Row>();
        for (Row row : rows) {
            result.add(row.square());
        }
        return new FileData(result);
    }

    @Override
    public FileData divide(double n) {
        ArrayList<Row> result = new ArrayList<Row>();
        for (Row row : rows) {
            result.add(row.divide(n));
        }
        return new FileData(result);
    }

    @Override
    public FileData minus(FileData data) {
        ArrayList<Row> result = new ArrayList<Row>();
        for (int i = 0; i < rows.size(); i++) {
            result.add(rows.get(i).minus(data.rows.get(i)));
        }
        return new FileData(result);
    }

    @Override
    public FileData squareRoot() {
        ArrayList<Row> result = new ArrayList<Row>();
        for (Row row : rows) {
            result.add(row.squareRoot());
        }
        return new FileData(result);
    }

    public List<Row> getRows() {
        return rows;
    }
}
