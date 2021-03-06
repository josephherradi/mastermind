package fr.joseph.mastermind;


import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;


public class Main {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        GetPropertyValues propertyValues= new GetPropertyValues();
        propertyValues.getPropValues();
        int n=propertyValues.getN();
        int nMaxTry= propertyValues.getnMaxTry();
        int m=propertyValues.getM();

        boolean dev=Utils.isModeDev(args,propertyValues.isDev());


        System.out.println("#########################");
        System.out.println("# MASTERMIND GAMES V1.1 #");
        System.out.println("#########################");
        System.out.println("");
        System.out.println(n+" chiffres de la combinaison");
        System.out.println("Nombre max de coups: "+nMaxTry);
        System.out.println("chiffre max pour les tirages ordinateur= "+m);
        System.out.println("Dev mode= "+dev);
        System.out.println("");
        logger.info("#########################");
        logger.info("# MASTERMIND GAMES V1.1 #");
        logger.info("#########################");
        logger.info("");
        logger.info(n+" chiffres de la combinaison");
        logger.info("Nombre max de coups "+nMaxTry);
        logger.info("chiffre max pour les tirages ordinateur= "+m);
        logger.info("Dev mode= "+dev);




        char mode = ' ', game = ' ', reponse1 = ' ', reponse2 = '2';
        do {
            if (reponse2 == '2') {
                do {
                    game = ' ';
                    System.out.println("Choisissez le jeu souhaité:");
                    System.out.println("1- Recherche +/-");
                    System.out.println("2- Mastermind");
                    logger.info("Choisissez le jeu souhaité:");
                    logger.info("1- Recherche +/-");
                    logger.info("2- Mastermind");


                    try {
                        game = sc.nextLine().charAt(0);

                    }catch (StringIndexOutOfBoundsException e){System.out.println("Saisissez le jeu souhaité 1 ou 2");}
                    logger.info("jeu choisi "+game);


                } while (game != '1' && game != '2');


                do {
                    mode = ' ';
                    System.out.println("Choisissez le mode du jeu:");
                    System.out.println("1- Challenger");
                    System.out.println("2- Defender");
                    System.out.println("3- Duel");
                    logger.info("Choisissez le mode du jeu:");
                    logger.info("1- Challenger");
                    logger.info("2- Defender");
                    logger.info("3- Duel");
                    try {
                        mode = sc.nextLine().charAt(0);
                    }catch (StringIndexOutOfBoundsException e){System.out.println("Sélectionnez le mode de jeu souhaité 1,2 ou 3");}
                    logger.info("Mode de jeu choisi "+mode);


                } while (mode != '1' && mode != '2' && mode != '3');

                if (game == '1') {
                    LaunchGame launchGame = new LaunchGame(mode,dev);
                    launchGame.startGame1(mode, n, m, nMaxTry,dev);


                } else if (game == '2') {
                    LaunchGame launchGame = new LaunchGame(mode,dev);
                    launchGame.startGame2(mode, n, m, nMaxTry,dev);

                }

            } else if (reponse2 == '1') {


                if (game == '1') {
                    LaunchGame launchGame = new LaunchGame(mode,dev);
                    launchGame.startGame1(mode, n, m, nMaxTry,dev);


                } else if (game == '2') {
                    LaunchGame launchGame = new LaunchGame(mode,dev);
                    launchGame.startGame2(mode, n, m, nMaxTry,dev);

                }
            }

            do {
                System.out.println("Souhaitez-vous  ");
                System.out.println("1-rejouer?  ");
                System.out.println("2-quitter?  ");
                logger.info("Souhaitez-vous  ");
                logger.info("1-rejouer?  ");
                logger.info("2-quitter?  ");

                try {
                    reponse1 = sc.nextLine().charAt(0);
                }catch (StringIndexOutOfBoundsException e){System.out.println("Faites le choix 1 ou 2");}
                logger.info("Réponse "+reponse1);

            } while (reponse1 != '1' && reponse1 != '2');

            if (reponse1 == '1') {
                do {
                    System.out.println("Souhaitez-vous  ");
                    System.out.println("1-rejouer au meme jeu?  ");
                    System.out.println("2-choisir le jeu/mode?  ");
                    logger.info("Souhaitez-vous  ");
                    logger.info("1-rejouer au meme jeu?  ");
                    logger.info("2-choisir le jeu/mode?  ");
                    try {
                        reponse2 = sc.nextLine().charAt(0);
                    }catch (StringIndexOutOfBoundsException e){System.out.println("Faites le choix 1 ou 2");}

                    logger.info("Réponse "+reponse2);

                } while (reponse2 != '1' && reponse2 != '2');
            }


        } while (reponse1 != '2');

    }

}








