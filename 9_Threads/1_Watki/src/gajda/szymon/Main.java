package gajda.szymon;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.*;

public class Main {
    private static String[] strings = {"aaaa", "bb", "ccccccccccccc", "dddddd"};

    public static void main(String[] args) {
        Watki w = new Watki();
        //System.out.println("Synchronizowane:");
        //w.func_a();

        System.out.println("Niesynchronizowane:");
        w.func_b();
    }

    //synchronized
    public static void func_a() {
        int length = strings.length;
        Thread[] threads = new Thread[length];
        for (int i = 0; i < length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < strings[finalI].length(); j++) {
                    System.out.print(strings[finalI].charAt(j));
                }
            });
            threads[i].start();
        }
    }

    static class Watki{
        final Queue<Thread> activeThreads = new LinkedBlockingQueue<>();
        volatile boolean start = false;

        //unsynchronized
        public class MyThread extends Thread {
            String str;

            MyThread(String str)
            {
                this.str = str;
            }

            @Override
            public synchronized void run() {
                super.run();

                while(!start) { }

                for(int j = 0; j<str.length(); j++)
                {
                    while(activeThreads.peek() != this) { }
                    synchronized (activeThreads)
                    {
                        Thread t = activeThreads.poll();
                        if(t == null)
                            return;
                        System.out.print(str.charAt(j));
                        if(j+1 < str.length())
                            activeThreads.add(t);
                    }
                }
                activeThreads.remove(this);
            }
        }

        public void func_b() {
            int length = strings.length;

            for(int i=0; i<length; i++)
            {
                Thread t = new MyThread(strings[i]);
                activeThreads.add(t);
                t.start();
            }
            start = true;
        }
    }
}
