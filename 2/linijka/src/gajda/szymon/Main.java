package gajda.szymon;

public class Main {

    public static void main(String[] args) {
        drawRuler(1, 5);
    }

    private static void drawRuler(int length, int depth) {
        if(depth > 0) {
            int space = (int)Math.pow(2, (depth-1)) - 1;

            System.out.print("|");
            for(int i=0; i<length; i++) {
                for(int j=0; j<space; j++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println("");
            drawRuler(length*2, depth-1);
        }
    }
}
