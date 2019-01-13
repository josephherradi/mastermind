package mastermind;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=4;
        int m=9;
        int nMaxTry=4;
        char mode=' ', game=' ', reponse1=' ',reponse2='2';
        do {
               if(reponse2=='2') {
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
                       if (mode == '1') {
                           StartChallengerMode startChallengerMode = new StartChallengerMode(n, m, nMaxTry);
                           startChallengerMode.challengeMode(n, m, nMaxTry);

                       } else if (mode == '2') {
                           StartDefenderMode startDefenderMode = new StartDefenderMode(n, m, nMaxTry);
                           startDefenderMode.defenderMode(n, m, nMaxTry);

                       } else if (mode == '3') {
                           StartDuelMode startDuelMode = new StartDuelMode(n, m, nMaxTry);
                           startDuelMode.duelMode1(n, m, nMaxTry);

                       }


                   } else if (game == '2') {
                       if (mode == '1') {
                           StartChallengerMode2 startChallengerMode2 = new StartChallengerMode2(n, m, nMaxTry);
                           startChallengerMode2.challengeMode2(n, m, nMaxTry);
                       } else if (mode == '2') {
                           StartDefenderMode2 startDefenderMode2 = new StartDefenderMode2(n, m, nMaxTry);
                           startDefenderMode2.defenderMode2(n, m, nMaxTry);

                       } else if (mode == '3') {
                           StartDuelMode startDuelMode = new StartDuelMode(n, m, nMaxTry);
                           startDuelMode.duelMode2(n, m, nMaxTry);

                       }

                   }

               } else if(reponse2=='1') {


                   if (game == '1') {
                       if (mode == '1') {
                           StartChallengerMode startChallengerMode = new StartChallengerMode(n, m, nMaxTry);
                           startChallengerMode.challengeMode(n, m, nMaxTry);

                       } else if (mode == '2') {
                           StartDefenderMode startDefenderMode = new StartDefenderMode(n, m, nMaxTry);
                           startDefenderMode.defenderMode(n, m, nMaxTry);

                       } else if (mode == '3') {
                           StartDuelMode startDuelMode = new StartDuelMode(n, m, nMaxTry);
                           startDuelMode.duelMode1(n, m, nMaxTry);

                       }


                   } else if (game == '2') {
                       if (mode == '1') {
                           StartChallengerMode2 startChallengerMode2 = new StartChallengerMode2(n, m, nMaxTry);
                           startChallengerMode2.challengeMode2(n, m, nMaxTry);
                       } else if (mode == '2') {
                           StartDefenderMode2 startDefenderMode2 = new StartDefenderMode2(n, m, nMaxTry);
                           startDefenderMode2.defenderMode2(n, m, nMaxTry);

                       } else if (mode == '3') {
                           StartDuelMode startDuelMode = new StartDuelMode(n, m, nMaxTry);
                           startDuelMode.duelMode2(n, m, nMaxTry);

                       }

                   }
               }

                do {
                    System.out.println("Souhaitez-vous  ");
                    System.out.println("1-rejouer?  ");
                    System.out.println("2-quitter?  ");

                    reponse1 = sc.nextLine().charAt(0);

                } while (reponse1 != '1' && reponse1 != '2');

                if(reponse1=='1'){
                    do {
                        System.out.println("Souhaitez-vous  ");
                        System.out.println("1-rejouer au meme jeu?  ");
                        System.out.println("2-choisir le jeu/mode?  ");
                        reponse2 = sc.nextLine().charAt(0);
                    }while (reponse2!='1'&& reponse2!='2');
                }






            } while (reponse1 != '2') ;

        }
    }

