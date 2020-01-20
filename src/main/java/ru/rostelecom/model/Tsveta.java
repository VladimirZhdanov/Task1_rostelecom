package ru.rostelecom.model;

import java.util.Objects;

/**
 * @author Vladimir Zhdanov (mailto:constHomeSpb@gmail.com)
 * @since 0.1
 */
public class Tsveta {
    private int id;
    private String colorNumber;
    private String name;

    public Tsveta() {
    }

    public Tsveta(int id, String colorNumber, String name) {
        this.id = id;
        this.colorNumber = colorNumber;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorNumber() {
        return colorNumber;
    }

    public void setColorNumber(String colorNumber) {
        this.colorNumber = colorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tsveta{" 
                + "id=" + id 
                + ", colorNumber='" + colorNumber + '\'' 
                + ", name='" + name + '\'' 
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tsveta tsveta = (Tsveta) o;
        return id == tsveta.id 
                && Objects.equals(colorNumber, tsveta.colorNumber) 
                && Objects.equals(name, tsveta.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colorNumber, name);
    }
}
