import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dungeon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        //variabile jucator
        int sanatate = 100;
        int atacJucator = 50;
        int potiuni = 3;
        int valoareRegenerarePotiune = 30;
        int sansaPotiune = 50;//procentaj

        //variabile inamic
        String[]inamici={"ZOMBIE", "SKELETON", "WARRIOR", "ASSASIN"};
        int maxSanatateInamic=75;
        int atacInamic=25;

        boolean running = true;
        System.out.println("Bine ai venit in Temnita!");
        GAME:
        while(running){
            System.out.println("-------------------------------------------");
            int sanatateInamic= rand.nextInt(maxSanatateInamic);
            String inamic = inamici[rand.nextInt(inamici.length)];
            System.out.println("\t# " + inamic + " a aparut! #");
            while(sanatateInamic > 0){
                System.out.println("sanatatea ta este " + sanatate);
                System.out.println("santate inamic " + inamic + " este " + sanatateInamic);
                System.out.println("\t\n Ce ai vrea sa faci?");
                System.out.println("\t1. Ataca ");
                System.out.println("\t2. Potiune ");
                System.out.println("\t3. Fugi! ");
                String input = in.nextLine();
                if(input.equals("1")){
                    //cod pt atac
                    int damageDat = rand.nextInt(atacJucator);
                    int damageLuat = rand.nextInt(atacInamic);
                    sanatateInamic -= damageDat;
                    sanatate -= damageLuat;
                    System.out.println( inamic + " lovit cu " + damageDat);
                    System.out.println("ai luat " + damageLuat + " damage");
                    if(sanatate < 1 ){
                        System.out.println("ai fost invins");
                        break;
                    }
                }else if(input.equals("2")){
                    //cod pt potiune
                    if(potiuni > 0){
                        sanatate += valoareRegenerarePotiune;
                        potiuni--;
                        System.out.println("\tai baut o potiune, te-ai vindecat cu " + valoareRegenerarePotiune +
                    "\t\nacum ai " + sanatate + "sanatate" +
                                "\t\n au ramas " + potiuni + "potiuni");
                    }else{
                        System.out.println("nu mai ai potiuni. invinge un inamic ca sa ai sansa la o potiune");
                    }
                }else if(input.equals("3")){
                    //cod pt fuga
                    System.out.println("Ai fugit de " + inamic);
                    continue GAME;
                }else{
                    //optiune invalida
                    System.out.println("OPTIUNE INVALIDA");
                }
            }
            if(sanatate<1){
                System.out.println("Ti-ai luat bataie!");
                break;
            }
            System.out.println("-------------------------------------------");
            System.out.println("# INAMIC A FOST INVINS! #");
            System.out.println("ai " + sanatate + "ramasa");
            if(rand.nextInt(100)<sansaPotiune){
                potiuni++;
                System.out.println("Ai primit o potiune");
                System.out.println("mai ai " + potiuni + " potiuni");

            }
            System.out.println("ce ai vrea sa faci in continuare?");
            System.out.println("1. Termina lupta");
            System.out.println("2. continua jocul");
            String input = in.nextLine();
            while(!input.equals("1") && !input.equals("2")){
                System.out.println("comanda invalida");
                input = in.next();
            }
            switch(input) {
                case "1": {
                    System.out.println("continui cu aventura!");
                    break;
                }
                case "2": {
                    System.out.println("Ai ales sa iesi din temnita!");
                    break GAME;
                }
            }
        }
        System.out.println("###############################");
        System.out.println("Multumim de joc!");
        System.out.println("###############################");
    }
}