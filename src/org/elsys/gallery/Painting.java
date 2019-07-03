package org.elsys.gallery;

public class Painting extends AbstractPieceOfArt {

    private int width;

    private int height;

    private String technique;

    public Painting(String artist, String title, int year, double price, double weight, int width, int height, String technique) {
        super(artist, title, year, price, weight);
        this.width = width;
        this.height = height;
        this.technique = technique;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTechnique() {
        return technique;
    }

    @Override
    public String toString() {
        return "Painting{" +
                "artist='" + getArtist() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", year=" + getYear() +
                ", weight=" + getWeigth() +
                ", price=" + getPrice() +
                ", width=" + width +
                ", height=" + height +
                ", technique='" + technique + '\'' +
                '}';
    }
}
