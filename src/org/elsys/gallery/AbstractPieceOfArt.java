package org.elsys.gallery;

import java.util.Objects;

public abstract class AbstractPieceOfArt implements PieceOfArt {

    private String artist;

    private String title;

    private int year;

    private double price;

    private double weight;

    public AbstractPieceOfArt(String artist, String title, int year, double price, double weight) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getWeigth() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPieceOfArt that = (AbstractPieceOfArt) o;
        return year == that.year &&
                Objects.equals(artist, that.artist) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, title, year);
    }
}
