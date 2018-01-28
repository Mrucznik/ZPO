import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JLabel[][] cyclistLabels = createWindow();

        Tournament tournament = new Tournament(cyclistLabels);
        tournament.startTournament();
    }

    private static JLabel[][] createWindow() {
        JFrame frame = new JFrame("Simple GUI");
        frame.setSize(400, 200);
        JPanel panel = new JPanel();
        panel.setSize(400, 200);
        GridLayout layout = new GridLayout(5, 3);

        JLabel[][] labels = new JLabel[4][2];
        for(int i=0; i<4; i++) {
            for(int j=0; j<2; j++) {
                labels[i][j] = new JLabel();
            }
        }

        panel.add(new JLabel("Miejsce"));
        panel.add(new JLabel("Zawodnik"));
        panel.add(new JLabel("Czas"));

        panel.add(new JLabel("1."));
        panel.add(labels[0][0]);
        panel.add(labels[0][1]);

        panel.add(new JLabel("2."));
        panel.add(labels[1][0]);
        panel.add(labels[1][1]);

        panel.add(new JLabel("3."));
        panel.add(labels[2][0]);
        panel.add(labels[2][1]);

        panel.add(new JLabel("Ostatnio skonczyl"));
        panel.add(labels[3][0]);
        panel.add(labels[3][1]);

        panel.setLayout(layout);
        frame.add(panel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        return labels;
    }


}
