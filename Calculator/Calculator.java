package Calculator;

public class Calculator {
    static double toplama(int a, int b) {
        return a + b;
    }

    static double cikarma(int a, int b) {
        return a - b;
    }

    static double carpma(int a, int b) {
        return a * b;
    }

    static double bolme(int a, int b) {
        if (b != 0) return a / b;
        return -1;
    }

    static double usAlma(int a, int b) {
        double sonuc = 1;
        if (b == 0) return sonuc;
        else if (b > 0) {
            for (int i = 0; i < b; i++) {
                sonuc *= a;
            }
            return sonuc;
        } else {
            for (int i = 0; i < (b * -1); i++) {
                sonuc /= a;
            }
            return sonuc;
        }
    }

    static double faktoriyelAlma(int a, int b) {
        int sonuc = 1;
        if (b == 0) return sonuc;
        else if (b > 0) {
            for (int i = 1; i <= b; i++) {
                sonuc *= i;
            }
            return sonuc;
        } else {
            return -1;
        }
    }

    static double modAlma(int a, int b) {
        return (a % b);
    }

    static double mutlakDegerHesaplama(int a) {
        if(a < 0) return a * -1;
        return a;
    }

    public static void main(String[] args) {

    }
}
