import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class ServiceDiceGame {
    Random random = new Random();
    LinkedList<Integer> linkedList = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    private int max = random.nextInt(6) + 1;
    private int max2 = random.nextInt(6) + 1;

    public void viewRules() {
        System.out.println("""
                Każdy gracz rzuca kostką (przycisk RZUĆ KOŚCIĄ),
                zdobywając punkty za każdy ruch, dopóki jedna 
                z kostek nie wyrzuci 1 lub gracz zdecyduje się 
                zatrzymać (przycisk WTRZYMAJ).                                         
                Jeśli wypadnie jedynka, gracz nie
                otrzymuje nic za tę rundę. Jeśli gracz zdecyduje
                się zatrzymać przed wyrzuceniem 1, wszystkie
                punkty zdobyte w rundzie są dodawane do jego całkowitego wyniku.                                          
                Następnie tura przechodzi na innego gracza.                                           
                Jeśli gracz wyrzuci 6 na jednej z kostek dwa razy z rzędu,
                traci wszystkie zapisane punkty i wszystkie punkty rundy.                                           
                Zwycięzcą jest ten, kto pierwszy zbierze 100 punktów.
                """);
    }

    public void whoStart() {
        System.out.println("Losowanie Gracza który zaczyna.");
        //  int randomMax1 = randomUser1;
        System.out.println("Rzut kostki przez 1 Gracza:" + max);

        //  int randomMax2 = randomUser2;
        System.out.println("Rzut kostki przez 2 Gracza:" + max2);
        if (max > max2) {
            System.out.println("Gracz 1 zaczyna!");
            max = random.nextInt(6) + 1;
            max2 = random.nextInt(6) + 1;
            player1();
        }
        if (max2 > max) {
            System.out.println("Gracz 2 zaczyna!");
            max2 = random.nextInt(6) + 1;
            max = random.nextInt(6) + 1;

        }
        if (max == max2) {
            System.out.println("Remis!");
            max = random.nextInt(6) + 1;
            max2 = random.nextInt(6) + 1;
            whoStart();
        }
    }

    public void player1() {
        System.out.println("""
                1.Rzucaj kostką
                2.Zakończ turę""");
        int play1Choice = scanner.nextInt();
        switch (play1Choice){
            case 1:
                max = random.nextInt(6) + 1;
                System.out.println("Wyrzuciłeś: " + max);
                linkedList.add(max);
                int sum = 0;
                for (int i = 0; i < linkedList.size() ; i++) {
                    sum += linkedList.get(i);

                }
                System.out.println("Twoja suma punktów: " + sum);
                player1();
            case 2:
                break;
        }

    }

}
