package BookSorter;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Kürk Mantolu Madonna",163,"Sabahattin Ali","2019");
        Book book2 = new Book("Olasılıksız",494,"Adam Fawer","2019");
        Book book3 = new Book("Prens",128,"Niccolo Machiavelli","2014");
        Book book4 = new Book("Satranç",104,"Stefan Zweig","2016");
        Book book5 = new Book("Algernon'a Çiçekler",325,"Daniel Keyes","2015");

        Set<Book> books = new TreeSet<>();

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (Book b : books) {
            System.out.println(b.getBookName() + "\t" + b.getPageNumber() + "\t" + b.getWriterName() + "\t" + b.getPublishDate());
        }
        System.out.println("*****************************************");

        Set<Book> books2 = new TreeSet<>((o1, o2) -> o1.getPageNumber() - o2.getPageNumber());
        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        books2.add(book5);

        for (Book b : books2) {
            System.out.println(b.getBookName() + "\t" + b.getPageNumber() + "\t" + b.getWriterName() + "\t" + b.getPublishDate());
        }
    }
}
