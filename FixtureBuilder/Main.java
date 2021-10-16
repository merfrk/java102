package FixtureBuilder;

public class Main {
    public static void main(String[] args) {
        FixtureBuilder fb = new FixtureBuilder();
        fb.add("Galatasaray");
        fb.add("Bursaspor");
        fb.add("Fenerbahçe");
        fb.add("Beşiktaş");
        fb.add("Başakşehir");
        fb.add("Trabzonspor");
        fb.generateMatches();
    }
}
