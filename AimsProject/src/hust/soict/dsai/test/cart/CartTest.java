package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.util.Scanner;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add to cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", 30f); // test sort by title-cost
        cart.addMedia(dvd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 120, 19.95f); // test sort by title-cost-length
        cart.addMedia(dvd5);

        //cart.removeMedia(dvd5);

        // Test print method
        cart.print();
        // Test search method
        System.out.println();
        System.out.println("===DVD BROWSER===");

        System.out.print("Enter ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        cart.searchById(id);

        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        cart.searchByTitle(title);

        // Test equals method
        System.out.println(dvd3.getId());
        System.out.println(dvd4.getId());

    }



}
