package PatikaStore;

import java.util.ArrayList;
import java.util.Scanner;

public class PatikaStore {
    private String name;
    private static ArrayList<Marka> markalar;
    private static ArrayList<Urun> urunler;
    private static Scanner sc = new Scanner(System.in);

    public PatikaStore(String name) {
        this.name = name;
    }

    static {
        markalar = new ArrayList<>();
        markalar.add(new Marka(1, "Samsung"));
        markalar.add(new Marka(2, "Lenovo"));
        markalar.add(new Marka(3, "Apple"));
        markalar.add(new Marka(4, "Huawei"));
        markalar.add(new Marka(5, "Casper"));
        markalar.add(new Marka(6, "Asus"));
        markalar.add(new Marka(7, "HP"));
        markalar.add(new Marka(8, "Xiaomi"));
        markalar.add(new Marka(9, "Monster"));

        urunler = new ArrayList<>();

        urunler.add(new CepTelefonu(1, 3119.0, 0, 1, "SAMSUNG GALAXY A51", markalar.get(0).getName(), 128, 6.5, 6, 4000, "Siyah",32));
        urunler.add(new CepTelefonu(2, 7379.0, 0, 1, "IPHONE 11 64 GB", markalar.get(2).getName(), 64, 6.1, 5, 3046, "Mavi",5));
        urunler.add(new CepTelefonu(3, 4012.0, 0, 1, "Redmi Note 10 Pro 8GB", markalar.get(7).getName(), 128, 6.5, 12, 4000, "Beyaz",35));

        urunler.add(new NoteBook(1, 7000.0, 0, 1, "HUAWEI Matebook 14", markalar.get(3).getName(), 512, 14.0, 16));
        urunler.add(new NoteBook(2, 3699.0, 0, 1, "LENOVO V14 IGL", markalar.get(1).getName(), 1024, 14.0, 8));
        urunler.add(new NoteBook(3, 8199.0, 0, 1, "ASUS Tuf Gaming", markalar.get(5).getName(), 2048, 15.6, 32));
    }

    public void printMenu() {
        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonları İşlemleri");
        System.out.println("3 - Marka Listele");
        System.out.println("4 - Ürünleri Hesapla");
        System.out.println("0 - Çıkış Yap");
        System.out.print("Tercihiniz : ");
    }

    public void markaListele() {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (int i = 0; i < markalar.size(); i++) {
            System.out.println("- " + markalar.get(i).getName());
        }
        System.out.println();

    }

    public void urunleriListele() {
        System.out.println("Notebook Listesi\n");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
        System.out.print("----------------------------------------------------------------------------------------------------\n|");
        boolean check = false;
        for (int i = 0; i < urunler.size(); i++) {
            if(urunler.get(i) instanceof NoteBook) {
                NoteBook n = (NoteBook) urunler.get(i);
                if(check) System.out.println("|");
                String temp = "";
                temp += " " + String.format("%-" + 3 + "s" ,n.getID());
                temp += "|";
                temp += " " + String.format("%-" + 30 + "s" ,n.getUrunAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,n.getFiyat());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,n.getMarkaAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,n.getDepolama());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,n.getEkranBoyutu());
                temp += "|";
                temp += " " + String.format("%-" + 12 + "s" ,n.getRam());
                temp += "|";
                System.out.println(temp);
                if(!check) check = true;
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");

        System.out.println("\nCep Telefonu Listesi\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.print("--------------------------------------------------------------------------------------------------------------------------------------\n|");
        check = false;
        for(int i = 0; i < urunler.size(); i++) {
            if(urunler.get(i) instanceof CepTelefonu) {
                CepTelefonu c = (CepTelefonu) urunler.get(i);
                if(check) System.out.print("|");
                String temp = "";
                temp += " " + String.format("%-" + 3 + "s" ,c.getID());
                temp += "|";
                temp += " " + String.format("%-" + 30 + "s" ,c.getUrunAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getFiyat());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getMarkaAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getDepolama());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getEkranBoyutu());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getKamera());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getPilGucu());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getRam());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getRenk());
                temp += "|";
                System.out.println(temp);
                if(!check) check = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\nCep Telefonu Listesi\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.print("--------------------------------------------------------------------------------------------------------------------------------------\n|");
        check = false;
        for(int i = 0; i < urunler.size(); i++) {
            if(urunler.get(i) instanceof CepTelefonu) {
                CepTelefonu c = (CepTelefonu) urunler.get(i);
                if(check) System.out.print("|");
                String temp = "";
                temp += " " + String.format("%-" + 3 + "s" ,c.getID());
                temp += "|";
                temp += " " + String.format("%-" + 30 + "s" ,c.getUrunAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getFiyat());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getMarkaAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getDepolama());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getEkranBoyutu());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getKamera());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getPilGucu());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getRam());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getRenk());
                temp += "|";
                System.out.println(temp);
                if(!check) check = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void cepTelefonlariniListele() {
        System.out.println("\nCep Telefonu Listesi\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.print("--------------------------------------------------------------------------------------------------------------------------------------\n|");
        boolean check = false;
        for(int i = 0; i < urunler.size(); i++) {
            if(urunler.get(i) instanceof CepTelefonu) {
                CepTelefonu c = (CepTelefonu) urunler.get(i);
                if(check) System.out.print("|");
                String temp = "";
                temp += " " + String.format("%-" + 3 + "s" ,c.getID());
                temp += "|";
                temp += " " + String.format("%-" + 30 + "s" ,c.getUrunAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getFiyat());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getMarkaAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getDepolama());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getEkranBoyutu());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getKamera());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getPilGucu());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getRam());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,c.getRenk());
                temp += "|";
                System.out.println(temp);
                if(!check) check = true;
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void notebooklariListele() {
        System.out.println("Notebook Listesi\n");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
        System.out.print("----------------------------------------------------------------------------------------------------\n|");
        boolean check = false;
        for(int i = 0; i < urunler.size(); i++) {
            if(urunler.get(i) instanceof NoteBook) {
                NoteBook n = (NoteBook) urunler.get(i);
                if(check) System.out.print("|");
                String temp = "";
                temp += " " + String.format("%-" + 3 + "s" ,n.getID());
                temp += "|";
                temp += " " + String.format("%-" + 30 + "s" ,n.getUrunAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,n.getFiyat());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,n.getMarkaAdi());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,n.getDepolama());
                temp += "|";
                temp += " " + String.format("%-" + 10 + "s" ,n.getEkranBoyutu());
                temp += "|";
                temp += " " + String.format("%-" + 12 + "s" ,n.getRam());
                temp += "|";
                System.out.println(temp);
                if(!check) check = true;
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }
    public boolean urunEkle(String urunClassName) {
        if(urunClassName.equals("CepTelefonu")) {
            System.out.print("Urunun id'sini giriniz: ");
            int id = sc.nextInt();

            System.out.print("Urunun birim fiyatini giriniz: ");
            double birimFiyati = sc.nextDouble();

            System.out.print("Urunun indirim oranini giriniz: ");
            double indirimOrani = sc.nextDouble();

            System.out.print("Urunun stok miktarini giriniz: ");
            int stokMiktari = sc.nextInt();

            System.out.print("Urunun adini giriniz: ");
            String urunAdi = sc.nextLine();

            for(int i = 0; i < markalar.size(); i++) {
                System.out.println(i + ") " + markalar.get(i).getName());
            }
            System.out.println();
            System.out.print("Urunun markasini seciniz: ");
            int markaIndex = sc.nextInt();
            String marka = markalar.get(markaIndex - 1).getName();

            System.out.print("Urunun hafizasini giriniz: ");
            int hafiza = sc.nextInt();

            System.out.print("Urunun ekran boyutunu giriniz: ");
            double ekranBoyutu = sc.nextDouble();

            System.out.print("Urunun kamerasini giriniz: ");
            int kamera = sc.nextInt();

            System.out.print("Urunun pil gucunu giriniz: ");
            int pilGucu = sc.nextInt();

            System.out.print("Urunun ram'ini giriniz: ");
            int ram = sc.nextInt();

            System.out.print("Urunun rengini giriniz: ");
            String renk = sc.nextLine();

            Urun yeniUrun = new CepTelefonu(id, birimFiyati, indirimOrani, stokMiktari, urunAdi, marka, hafiza, ekranBoyutu,
                    ram, pilGucu, renk,kamera);
            urunler.add(yeniUrun);
            return true;
        } else if(urunClassName.equals("Notebook")) {
            System.out.print("Urunun id'sini giriniz: ");
            int id = sc.nextInt();

            System.out.print("Urunun birim fiyatini giriniz: ");
            double birimFiyati = sc.nextDouble();

            System.out.print("Urunun indirim oranini giriniz: ");
            double indirimOrani = sc.nextDouble();

            System.out.print("Urunun stok miktarini giriniz: ");
            int stokMiktari = sc.nextInt();

            System.out.print("Urunun adini giriniz: ");
            String urunAdi = sc.nextLine();

            for(int i = 0; i < markalar.size(); i++) {
                System.out.println(i + ") " + markalar.get(i).getName());
            }
            System.out.println();
            System.out.print("Urunun markasini seciniz: ");
            int markaIndex = sc.nextInt();
            String marka = markalar.get(markaIndex - 1).getName();

            System.out.print("Urunun ram'ini giriniz: ");
            int ram = sc.nextInt();

            System.out.print("Urunun depolama alanini giriniz: ");
            int depolama = sc.nextInt();

            System.out.print("Urunun ekran boyutunu giriniz: ");
            double ekranBoyutu = sc.nextDouble();

            Urun yeniUrun = new NoteBook(id, birimFiyati, indirimOrani, stokMiktari, urunAdi, marka, depolama, ekranBoyutu, ram);
            urunler.add(yeniUrun);
            return true;
        } else {
            System.out.println("Yanlis urun grubu sectiniz. Boyle bir urun grubu bulunmamakta.");
            return false;
        }
    }
    public boolean urunSil(String className, int id) {
        for(int i = 0; i < urunler.size(); i++) {
            try {
                if(urunler.get(i).getID() == id && Class.forName(className).isInstance(urunler.get(i))) {
                    urunler.remove(i);
                    return true;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public Urun filterUrunById(int id) {
        for(int i = 0; i < urunler.size(); i++) {
            if(urunler.get(i).getID() == id) return urunler.get(i);
        }
        return null;
    }

    public ArrayList<Urun> filterUrunByMarka(Marka marka) {
        ArrayList<Urun> filteredUrunler = new ArrayList<>();
        for(int i = 0; i < urunler.size(); i++) {
            if(urunler.get(i).getMarkaAdi().equals(marka.getName())) {
                filteredUrunler.add(urunler.get(i));
            }
        }
        return filteredUrunler;
    }

    public String getName() {
        return name;
    }
    public static ArrayList<Marka> getMarkalar() {
        return markalar;
    }

}
