import java.util.Scanner;

public class MenuDiceGame {
    Scanner scanner = new Scanner(System.in);

    ServiceDiceGame serviceDiceGame = new ServiceDiceGame();
    public void startGame(){
        System.out.println("""
                           Wybierz opcję:
                           1.Wyświetl zasady gry
                           2.Graj
                           3.Wyjdź""");
        int choiceNum = scanner.nextInt();
        switch (choiceNum){
            case 1:
                serviceDiceGame.viewRules();
                startGame();
            case 2:
                serviceDiceGame.whoStart();
                startGame();
            case 3:
                System.exit(0);
        }
    }
}
