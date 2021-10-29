package BookList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Algernon'a Çiçekler",325,"Daniel Keyes","2015");
        Book book2 = new Book("Kuyucaklı Yusuf",240,"Sabahattin Ali","2019");
        Book book3 = new Book("Bye Bye Türkçe",384,"Oktay Sinanoğlu","2019");
        Book book4 = new Book("Bülbülü Öldürmek",296,"Harper Lee","2009");
        Book book5 = new Book("Beyaz Diş",256,"Jack London","2018");
        Book book6 = new Book("Hayvan Çiftliği",152,"George Orwell","2020");
        Book book7 = new Book("Araba Sevdası",294,"Recaizade Mahmut Ekrem","2012");
        Book book8 = new Book("Beyaz Zambaklar Ülkesinde",208,"Grigory Petrov","2017");
        Book book9 = new Book("Satranç",104,"Stefan Zweig","2016");
        Book book10 = new Book("Prens",128,"Niccolo Machiavelli","2014");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        Map<String,String> stringStringMap = new HashMap<>();
        books.stream().forEach(book -> stringStringMap.put(book.getBookName(),book.getAuthorName()));
        System.out.println(stringStringMap);
        List<Book> shortBooksList = new ArrayList<>();
        books.stream().filter(book -> book.getNumberOfPages() > 100).forEach(a -> shortBooksList.add(a));
        System.out.println(shortBooksList);
    }
}
