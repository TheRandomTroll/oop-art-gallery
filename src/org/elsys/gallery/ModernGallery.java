package org.elsys.gallery;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ModernGallery extends Gallery {
	public ModernGallery(int budget) {
		super(budget);
	}

	@Override
	public boolean add(PieceOfArt artWork) {
		if (artWork.getYear() < 1800) {
			throw new RuntimeException();
		}
		return super.add(artWork);
	}
	
	/**
	 * Montly cost for running the gallery - 8% of the total price of all paintings.
	 * 
	 * @return
	 */
	//живота ми е парти...         :)
	public double getMonthlyCost() {
		return super.getMonthlyCost() * 0.8;
	}

	@Override
	public boolean monthlyPurchase(Collection<PieceOfArt> paintings) {
		paintings.stream()
				.forEach((pieceOfArt -> {
					if (pieceOfArt.getYear() < 1800) {
						throw new RuntimeException();
					}
				}));
	    /*
	    for (PieceOfArt pieceOfArt : paintings) {
			if (pieceOfArt.getYear() < 1800) {
				throw new RuntimeException();
			}
		}
	     */
		return super.monthlyPurchase(paintings);
	}

	/**
	 * Returns all art works of the given artist sorted from the most expensive to
	 * the less expensive painting.
	 * @param artist
	 * @return
	 */
	public List<PieceOfArt> getWorksOf(String artist) {
		return getPiecesOfArt().stream()
				.filter(pieceOfArt -> pieceOfArt.getArtist().equals(artist))
				.sorted((piece1, piece2) -> (int)(piece2.getPrice() - piece1.getPrice()))
				.collect(Collectors.toList());
	}
}
