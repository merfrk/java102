package PatikaStore;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PatikaStore patikaStore = new PatikaStore("PatikaStore");
        patikaStore.printMenu();

        int option = scanner.nextInt();
        while (true) {
            System.out.println();
            if (option == 0) {
                System.out.println("Cikis yapiliyor...");
                break;
            } else if (option == 1) {
                System.out.println("1 - Notebooklari Listele");
                System.out.println("2 - Notebook ekle");
                System.out.println("3 - Notebook sil");
                System.out.println("0 - Ana Menuye Geri Gel");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Ana menuye geri donuluyor...");
                        break;
                    case 1:
                        patikaStore.notebooklariListele();
                        break;
                    case 2:
                        boolean added = patikaStore.urunEkle("Notebook");
                        if (added) {
                            System.out.println("Urun basariyla eklendi.");
                        }
                        break;
                    case 3:
                        patikaStore.notebooklariListele();
                        System.out.print("Silmek istediginiz urunun id'sini giriniz : ");
                        int urunId = scanner.nextInt();
                        boolean deleted = patikaStore.urunSil("Notebook", urunId);
                        if (deleted) {
                            System.out.println("Urun basariyla silindi.");
                        }
                        break;
                    default:
                        System.out.println("Gecersiz bir secenek!");
                }
            } else if (option == 2) {
                System.out.println("1 - Cep Telefonlarini Listele");
                System.out.println("2 - Cep Telefonu ekle");
                System.out.println("3 - Cep Telefonu sil");
                System.out.println("0 - Ana Menuye Geri Gel");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Ana menuye geri donuluyor...");
                        break;
                    case 1:
                        patikaStore.cepTelefonlariniListele();
                        break;
                    case 2:
                        boolean added = patikaStore.urunEkle("CepTelefonu");
                        if (added) {
                            System.out.println("Urun basariyla eklendi.");
                        }
                        break;
                    case 3:
                        patikaStore.cepTelefonlariniListele();
                        System.out.print("Silmek istediginiz urunun id'sini giriniz : ");
                        int urunId = scanner.nextInt();
                        boolean deleted = patikaStore.urunSil("CepTelefonu", urunId);
                        if (deleted) {
                            System.out.println("Urun basariyla silindi.");
                        }
                        break;
                    default:
                        System.out.println("Gecersiz bir secenek!");
                }
            } else if (option == 3) {
                patikaStore.markaListele();
            } else if (option == 4) {
                patikaStore.urunleriListele();
            } else {
                System.out.println("Gecersiz bir secenek girdiniz!");
            }

            System.out.println();
            patikaStore.printMenu();
            option = scanner.nextInt();
        }
    }
}

