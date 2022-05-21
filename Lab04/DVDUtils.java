package aims;

import com.sun.corba.se.impl.transport.DefaultIORToSocketInfoImpl;

public class DVDUtils {
    public static int compareByCost (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        int HIGHER_COST = Float.compare(dvd1.getCost(), dvd2.getCost());

        if (HIGHER_COST > 0) {
            System.out.println(dvd1.getTitle() + " has higher cost than " + dvd2.getTitle());
        } else if (HIGHER_COST < 0) {
            System.out.println(dvd2.getTitle() + " has higher cost than " + dvd1.getTitle());
        } else {
            System.out.println("Two DVDs have the same cost.");
        }
        return HIGHER_COST;
    }

    public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        int HIGHER_ALPHABET = dvd1.getTitle().compareToIgnoreCase(dvd2.getTitle());

        if (HIGHER_ALPHABET > 0) {
            System.out.println(dvd1.getTitle() + " is lexicographically greater than " + dvd2.getTitle());
        } else if (HIGHER_ALPHABET < 0) {
            System.out.println(dvd2.getTitle() + " is lexicographically greater than " + dvd1.getTitle());
        } else {
            System.out.println("Two DVDs have the same title.");
        }
        return HIGHER_ALPHABET;
    }

    public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
        //TODO write sth here
    }

    public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
        //TODO write sth here

    }
}