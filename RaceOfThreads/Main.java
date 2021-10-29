package RaceOfThreads;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(10_000);
        for (int i = 0; i < 10_000; i++) {
            numbers.add(i + 1);
        }
        ArrayList<Integer> list1 = new ArrayList<>(numbers.subList(0, 2500));
        ArrayList<Integer> list2 = new ArrayList<>(numbers.subList(2500, 5000));
        ArrayList<Integer> list3 = new ArrayList<>(numbers.subList(5000, 7500));
        ArrayList<Integer> list4 = new ArrayList<>(numbers.subList(7500, 10_000));
        ArrayList<Integer> oddList = new ArrayList<>(2500);
        ArrayList<Integer> evenList = new ArrayList<>(2500);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Main m1 = new Main();
                m1.searchNumbers(list1, oddList, evenList);
            }
        }, "Thread_1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Main m2 = new Main();
                m2.searchNumbers(list2, oddList, evenList);
            }
        }, "Thread_2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Main m3 = new Main();
                m3.searchNumbers(list3, oddList, evenList);
            }
        }, "Thread_3");

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                Main m4 = new Main();
                m4.searchNumbers(list4, oddList, evenList);
            }
        }, "Thread_4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < oddList.size(); i++) {
            System.out.println(oddList.get(i) + ","+evenList.get(i));
        }

    }

    private void searchNumbers(List<Integer> list, List oddList, List evenList) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                synchronized (evenList) {
                    evenList.add(list.get(i));
                }
            } else {
                synchronized (oddList) {
                    oddList.add(list.get(i));
                }
            }

        }
    }
}
