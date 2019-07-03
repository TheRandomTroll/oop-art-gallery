package org.elsys.gallery;

public class Sculpture extends AbstractPieceOfArt {

	public Sculpture(String artist, String title, int year, double weight, double price) {
		super(artist, title, year, price, weight);

		if(year < -1000 || year > 2018) {
			throw new RuntimeException();
		}
		if(weight <= 0) {
			throw new RuntimeException();
		}
		if(price <= 0) {
			throw new RuntimeException();
		}
	}

	@Override
	public String toString() {
		return "Sculpture{" +
				"artist='" + getArtist() + '\'' +
				", title='" + getTitle() + '\'' +
				", year=" + getYear() +
				", weight=" + getWeigth() +
				", price=" + getPrice() +
				'}';
	}
}

