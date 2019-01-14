package fr.joseph.mastermind;


import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;


public class Main {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = 9;

        GetPropertyValues propertyValues= new GetPropertyValues();
        propertyValues.getPropValues();
        int n=propertyValues.getN();
        int nMaxTry= propertyValues.getnMaxTry();

        System.out.println("n= "+n);
        System.out.println("nMaxTry "+nMaxTry);


        char mode = ' ', game = ' ', reponse1 = ' ', reponse2 = '2';
        do {
            if (reponse2 == '2') {
                do {
                    game = ' ';
                    System.out.println("Choisissez le jeu souhaité:");
                    System.out.println("1- Recherche +/-");
                    System.out.println("2- Mastermind");

                    game = sc.nextLine().charAt(0);


                } while (game != '1' && game != '2');


                do {
                    mode = ' ';
                    System.out.println("Choisissez le mode du jeu:");
                    System.out.println("1- Challenger");
                    System.out.println("2- Defender");
                    System.out.println("3- Duel");

                    mode = sc.nextLine().charAt(0);


                } while (mode != '1' && mode != '2' && mode != '3');

                if (game == '1') {
                    LaunchGame launchGame = new LaunchGame(mode);
                    launchGame.startGame1(mode, n, m, nMaxTry);


                } else if (game == '2') {
                    LaunchGame launchGame = new LaunchGame(mode);
                    launchGame.startGame2(mode, n, m, nMaxTry);

                }

            } else if (reponse2 == '1') {


                if (game == '1') {
                    LaunchGame launchGame = new LaunchGame(mode);
                    launchGame.startGame1(mode, n, m, nMaxTry);


                } else if (game == '2') {
                    LaunchGame launchGame = new LaunchGame(mode);
                    launchGame.startGame2(mode, n, m, nMaxTry);

                }
            }

            do {
                System.out.println("Souhaitez-vous  ");
                System.out.println("1-rejouer?  ");
                System.out.println("2-quitter?  ");

                reponse1 = sc.nextLine().charAt(0);

            } while (reponse1 != '1' && reponse1 != '2');

            if (reponse1 == '1') {
                do {
                    System.out.println("Souhaitez-vous  ");
                    System.out.println("1-rejouer au meme jeu?  ");
                    System.out.println("2-choisir le jeu/mode?  ");
                    reponse2 = sc.nextLine().charAt(0);
                } while (reponse2 != '1' && reponse2 != '2');
            }


        } while (reponse1 != '2');
        logger.info("info");

    }

}








