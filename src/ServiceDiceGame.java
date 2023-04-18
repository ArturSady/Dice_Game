public class ServiceDiceGame {
    private int max = 6;
    private int randomUser1 = (int) Math.floor(Math.random() * max);
    private int randomUser2 = (int) Math.floor(Math.random() * max);
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
    public void whoStart(){
        System.out.println("Losowanie Gracza który zaczyna.");
        int randomMax1 = randomUser1;
        System.out.println("Rzut kostki przez 1 Gracza:" + randomMax1);
        int randomMax2 = randomUser2;
        System.out.println("Rzut kostki przez 2 Gracza:" + randomMax2);
        if(randomMax1 > randomMax2){
            System.out.println("Gracz 1 zaczyna!");
        }if(randomMax2 > randomMax1){
            System.out.println("Gracz 2 zaczyna!");
        }
    }

}
