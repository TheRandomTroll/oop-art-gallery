package org.elsys.gallery;

import com.sun.deploy.pings.Pings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Gallery extends AbstractGallery {
	private int budget;
	private List<PieceOfArt> piecesOfArt;

	public Gallery(int budget) {
		this.budget = budget;
		this.piecesOfArt = new ArrayList<>();
	}

	/**
	 *
	 * @return gallery budget.
	 */
	public int getBudget() {
		return this.budget;
	}

	/**
	 * Montly cost for running the gallery - 10% of the total price of all
	 * art works.
	 * 
	 * @return
	 */
	public double getMonthlyCost() {
		return this.getTotalPrice() * 0.1;
	}

	private double getTotalPrice() {
		double result = 0.0;
		for(PieceOfArt pieceOfArt : piecesOfArt) {
			result += pieceOfArt.getPrice();
		}

		// Alternative way:
//		for(int i = 0; i < piecesOfArt.size(); i++) {
//			result += piecesOfArt.get(i).getPrice();
//		}

		return result;
	}

	/**
	 * Calculates the monthly budget that could be spend on buying new art works.
	 * 
	 * @return
	 */
	public double getRemainingMonthlyBudget() {
		return this.budget - this.getMonthlyCost();
	}

	/**
	 * Add art works to the gallery collection.
	 * 
	 * If there is a piece of art in gallery collection with the same author, name and
	 * year of creation,
	 * throws RuntimeException because of forgery suspected.
	 * 
	 * @param artWork
	 *            - piece of art to be added
	 * @return true if p was successfully added, false otherwise.
	 */
	public boolean add(PieceOfArt artWork) {
		if(this.piecesOfArt.contains(artWork)) {
			throw new RuntimeException();
		}

		return this.piecesOfArt.add(artWork);
	}

	public boolean addAll(Collection<PieceOfArt> artWorks) {
		for(PieceOfArt pieceOfArt : artWorks) {
			if(this.piecesOfArt.contains(pieceOfArt)) {
				throw new RuntimeException();
			}
		}

		return this.piecesOfArt.addAll(artWorks);
	}

	public boolean monthlyPurchase(Collection<PieceOfArt> artWorks) {
		double result = 0.0;
		for(PieceOfArt pieceOfArt : artWorks) {
			result += pieceOfArt.getPrice();
		}

		if(result > this.getRemainingMonthlyBudget()) {
			throw new RuntimeException();
		}

		return this.addAll(artWorks);
	}
	
	public int size() {
		return this.piecesOfArt.size();
	}
	
	/**
	 * If there is a painting in gallery collection with the same artist and title,
	 * returns true. Otherwise returns false
	 * 
	 * @param painting
	 * @return
	 */
	public boolean contains(PieceOfArt painting) {
		return this.piecesOfArt.contains(painting);
	}
	/**
	 * Returns collection of works from the gallery, which weight is between
	 * minWeight and maxWeight.
	 * 
	 * @param minWeight
	 * @param maxWeight
	 * @return
	 */
	public Collection<PieceOfArt> getWorksByWeight(double minWeight, double maxWeight) {
		return this.piecesOfArt.stream()
				.filter((pieceOfArt) ->
						pieceOfArt.getWeigth() >= minWeight &&
						pieceOfArt.getWeigth() <= maxWeight)
				.sorted((x1, x2) -> (int)(x1.getWeigth() - x2.getWeigth()))
				.collect(Collectors.toList());
	}

	public double getAverageWorkPrice() {
		return this.piecesOfArt.stream()
				.mapToDouble(pieceOfArt -> pieceOfArt.getPrice())
				.sum() / this.size();
	}

	public List<PieceOfArt> getPiecesOfArt() {
		return piecesOfArt;
	}

	public List<Painting> getPaintings() {
		return piecesOfArt.stream()
				.filter(pieceOfArt -> pieceOfArt instanceof Painting)
                .map(pieceOfArt -> (Painting) pieceOfArt)
				.collect(Collectors.toList());
	}

	public List<Sculpture> getSculptures() {
		return piecesOfArt.stream()
				.filter(pieceOfArt -> pieceOfArt instanceof Sculpture)
				.map(pieceOfArt -> (Sculpture) pieceOfArt)
				.collect(Collectors.toList());
	}

	public List<Painting> getPaintingsByTechnique(String technique) {
		return getPaintings().stream()
				.filter(painting -> painting.getTechnique().equals(technique))
				.collect(Collectors.toList());
	}

	public List<Painting> getPaintingsBySizes(int width, int height) {
		return getPaintings().stream()
			.filter(painting -> painting.getHeight()==height && painting.getWidth()==width)
			.collect(Collectors.toList());
	}
}
