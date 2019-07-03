package org.elsys.gallery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] sculpturesStrings = line.split("; ");
        List<Sculpture> sculptures = new ArrayList<>();
        ModernGallery gallery = new ModernGallery(5000);

        for (String str : sculpturesStrings) {
            String[] sculptureArguments = str.split(", ");
            String artist = sculptureArguments[0];
            String title = sculptureArguments[1];
            int year = Integer.parseInt(sculptureArguments[2]);
            double weight = Double.parseDouble(sculptureArguments[3]);
            double price = Double.parseDouble(sculptureArguments[4]);

            if (year >= 1000) {
                sculptures.add(new Sculpture(artist, title, year, weight, price));
            }
        }

        try {
            gallery.monthlyPurchase((Collection)sculptures);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
        // System.out.println("Hello");
        List<PieceOfArt> pieceOfArts = gallery.getWorksOf("Artist1");

        for (PieceOfArt pieceOfArt : pieceOfArts) {
            System.out.println(pieceOfArt);
        }
    }
}
