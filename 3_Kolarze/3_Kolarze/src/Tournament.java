import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Timer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Tournament implements Observer {
    private static PriorityQueue<Cyclist> cyclistQueue;
    private JLabel[][] cyclistsLabels;
    private Logger logger;

    Tournament(JLabel[][] cyclistsLabels)
    {
        this.cyclistsLabels = cyclistsLabels;
        cyclistQueue = new PriorityQueue<>();
        logger = Logger.getLogger(Tournament.class.getName());
        FileHandler fh;
        try {
            fh = new FileHandler("className.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startTournament() {
        Stack<Cyclist> kolarze = new Stack<>();
        try {
            //Add cyclists
            Scanner namesFile = new Scanner(new URL("http://szgrabowski.kis.p.lodz.pl/zpo17/nazwiska.txt").openStream());
            Set<Cyclist> cyclists = new LinkedHashSet<>();
            while (namesFile.hasNext()) {
                cyclists.add(new Cyclist(namesFile.nextLine()));
            }

            //Randomize cyclists
            ArrayList<Cyclist> randomCyclists = new ArrayList<>(cyclists);
            Collections.shuffle(randomCyclists);

            for (Cyclist cyclist : randomCyclists) {
                kolarze.push(cyclist);
                cyclist.addObserver(this);
                if (kolarze.size() == 15)
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!kolarze.isEmpty())
                {
                    logger.log(Level.INFO, kolarze.peek().getName() + " wystartowal");
                    kolarze.pop().start();
                }
                else
                    cancel();
            }
        }, 0, 60000 / 25);
        logger.log(Level.INFO, "Wystartowano wyscig");
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Cyclist) {
            Cyclist cyclist = (Cyclist)o;
            cyclistQueue.add(cyclist);
            logger.log(Level.INFO, cyclist.getName() + " ukonczyl wyscig z czasem " + cyclist.getTime() + "s.");

            cyclistsLabels[3][0].setText(cyclist.getName());
            cyclistsLabels[3][1].setText(cyclist.getTime() + "s");

            Stack<Cyclist> tmp = new Stack<>();
            for (int i = 0; i < Math.min(3, cyclistQueue.size()); i++) {
                if(cyclistQueue.isEmpty())
                    break;
                tmp.push(cyclistQueue.poll());
                cyclistsLabels[i][0].setText(tmp.peek().getName());
                cyclistsLabels[i][1].setText(tmp.peek().getTime() + "s");
            }
            cyclistQueue.addAll(tmp);
            logger.log(Level.INFO, "Lista zawodnikow, ktorzy ukonczyli wyscig: " + cyclistQueue.toString());
        }
    }
}
