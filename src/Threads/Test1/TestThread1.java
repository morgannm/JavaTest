package Threads.Test1;

public class TestThread1 {
    public static void main(String[] args) {
        ThreadTest1 t = new ThreadTest1("A");
        ThreadTest1 t2 = new ThreadTest1("B");
        t.start();
        t2.start();
    }
}
