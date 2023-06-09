import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class ServiceDiceGame {
    Random random = new Random();
    LinkedList<Integer> pointsPlayer1 = new LinkedList<>();
    LinkedList<Integer> pointsPlayer2 = new LinkedList<>();
    LinkedList<Integer> pointsPlayer1_OnRound = new LinkedList<>();
    LinkedList<Integer> pointsPlayer2_OnRound = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);

    private int dice1Player1;// = random.nextInt(6) + 1;
    private int dice2Player1; // = random.nextInt(6) + 1;
    private int dice1Player2; // = random.nextInt(6) + 1;
    private int dice2Player2;// = random.nextInt(6) + 1;

    public void viewRules() {
        System.out.println("""
                Na początku gracze rzucają 1 kostką. Gracz który wyrzuci
                więcej oczek zaczyna.
                Każdy gracz rzuca 2 kostkami ,
                zdobywając punkty równowartości sumy oczek z 2 kostek za każdy ruch, dopóki jedna 
                z kostek nie wyrzuci 1 lub gracz zdecyduje się 
                zatrzymać.                                         
                Jeśli wypadnie jedynka, gracz nie
                otrzymuje nic za tę rundę i traci dotychczasowe punkty.
                Jeśli gracz zdecyduje się zatrzymać przed wyrzuceniem 1, wszystkie               
                punkty zdobyte w rundzie są dodawane do jego całkowitego wyniku.                                          
                Następnie tura przechodzi na innego gracza.                                                           
                """);
    }

    public void whoStart() {
        System.out.println("Losowanie Gracza który zaczyna.");
        dice1Player1 = random.nextInt(6) + 1;
        dice1Player2 = random.nextInt(6) + 1;
        //  int randomMax1 = randomUser1;
        System.out.println("Rzut kostki przez 1 Gracza:" + dice1Player1);

        //  int randomMax2 = randomUser2;
        System.out.println("Rzut kostki przez 2 Gracza:" + dice1Player2);
        if (dice1Player1 > dice1Player2) {
            System.out.println("Gracz 1 zaczyna!");
            // dice1Player1 = random.nextInt(6) + 1;
            // dice1Player2 = random.nextInt(6) + 1;
            player1();
        }
        if (dice1Player2 > dice1Player1) {
            System.out.println("Gracz 2 zaczyna!");
            // dice1Player2 = random.nextInt(6) + 1;
            // dice1Player1 = random.nextInt(6) + 1;
            player2();

        }
        if (dice1Player1 == dice1Player2) {
            System.out.println("Remis!");
            dice1Player1 = random.nextInt(6) + 1;
            dice1Player2 = random.nextInt(6) + 1;
            whoStart();
        }
    }

    public void player1() {
        System.out.println("""
                Gracz 1:
                1.Rzucaj kostką
                2.Zakończ turę
                3.Sprawdż swoje punkty""");
        int play1Choice = scanner.nextInt();
        switch (play1Choice) {
            case 1:
                dice2Player1 = random.nextInt(6) + 1;
                dice1Player1 = random.nextInt(6) + 1;
                System.out.println("Wyrzuciłeś kostka 1: " + dice1Player1);
                System.out.println("Wyrzuciłeś kostka 2: " + dice2Player1);
                if (dice1Player1 != 1 && dice2Player1 != 1) {

                    pointsPlayer1_OnRound.add(dice1Player1);
                    pointsPlayer1_OnRound.add(dice2Player1);
                    int sum = 0;
                    for (int i = 0; i < pointsPlayer1_OnRound.size(); i++) {
                        sum += pointsPlayer1_OnRound.get(i);

                    }
                    System.out.println("Twoja suma punktów w tej turze: " + sum);
                    player1();
//                    if (sum >= 100) {
//                        System.out.println("Wygrałeś!");
//                        System.exit(0);
//                    } else {
//                        player1();
//                    }
                } else {
                    pointsPlayer1_OnRound.clear();
                    player2();
                }
            case 2:
                pointsPlayer1.addAll(pointsPlayer1_OnRound);
                int sum2 = 0;
                for (int i = 0; i < pointsPlayer1.size(); i++) {
                    sum2 += pointsPlayer1.get(i);
                }
                if (sum2 >= 100){
                    System.out.println("Gracz nr.1 Wygrywa!!!");
                    System.exit(0);
        }
                pointsPlayer1_OnRound.clear();
                player2();
                //   break;
            case 3:
                int sum1 = 0;
                for (int i = 0; i < pointsPlayer1.size(); i++) {
                    sum1 += pointsPlayer1.get(i);
                }
                System.out.println("Twoja suma punktów: " + sum1);
                player1();
        }

    }

    public void player2() {
        System.out.println("""
                Gracz 2:
                1.Rzucaj kostką.
                2.Zakończ turę.
                3.Sprawdź swoje punkty.""");
        int play1Choice = scanner.nextInt();
        switch (play1Choice) {
            case 1:
                dice2Player2 = random.nextInt(6) + 1;
                dice1Player2 = random.nextInt(6) + 1;
                System.out.println("Wyrzuciłeś kostka 1: " + dice1Player2);
                System.out.println("Wyrzuciłeś kostka 2: " + dice2Player2);
                if (dice1Player2 != 1 && dice2Player2 != 1) {

                    pointsPlayer2_OnRound.add(dice1Player2);
                    pointsPlayer2_OnRound.add(dice2Player2);
                    int sum = 0;
                    for (int i = 0; i < pointsPlayer2_OnRound.size(); i++) {
                        sum += pointsPlayer2_OnRound.get(i);

                    }
                    System.out.println("Twoja suma punktów w turze: " + sum);
                    player2();

                }else {
                    pointsPlayer2_OnRound.clear();
                    player1();
                }
            case 2:
                pointsPlayer2.addAll(pointsPlayer2_OnRound);
                int sum2 = 0;
                for (int i = 0; i < pointsPlayer2.size(); i++) {
                    sum2 += pointsPlayer2.get(i);
                }
                if (sum2 >= 100){
                    System.out.println("Gracz nr.2 Wygrywa!!!");
                    System.exit(0);
                }
                pointsPlayer2_OnRound.clear();
                player1();
            case 3:
                int sum1 = 0;
                for (int i = 0; i < pointsPlayer2.size(); i++) {
                    sum1 += pointsPlayer2.get(i);
                }
                System.out.println("Twoja suma punktów: " + sum1);
                player2();
        }

    }
}
