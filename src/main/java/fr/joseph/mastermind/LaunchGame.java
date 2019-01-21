package fr.joseph.mastermind;

public class LaunchGame {

    char mode;
    boolean dev;


    public LaunchGame(char mode,boolean dev) {
        this.mode = mode;
        this.dev=dev;

    }

    /**
     * Jeu n°1 Recherche +/-
     * @param mode
     *          Challenger, defender ou duel
     * @param n
     *          nombre de chiffres de la combinaison
     * @param m
     *          chiffre max pour le tirage
     * @param nMaxTry
     *          nombre de coups
     */

    public void startGame1(char mode,int n, int m, int nMaxTry,boolean dev){

             if (mode == '1') {
                StartChallengerModeGame1 startChallengerModeGame1 = new StartChallengerModeGame1(n, m, nMaxTry,dev);
                startChallengerModeGame1.challengeMode(n, m, nMaxTry,dev);

            } else if (mode == '2') {
                StartDefenderModeGame1 startDefenderModeGame1 = new StartDefenderModeGame1(n, m, nMaxTry);
                startDefenderModeGame1.defenderMode(n, m, nMaxTry);

            } else if (mode == '3') {
                StartDuelMode2Games startDuelMode2Games = new StartDuelMode2Games(n, m, nMaxTry,dev);
                startDuelMode2Games.duelMode1(n, m,dev);

            }

    };
    /**
     * Jeu n°2 Mastermind
     * @param mode
     *          Challenger, defender ou duel
     * @param n
     *          nombre de chiffres de la combinaison
     * @param m
     *          chiffre max pour le tirage
     * @param nMaxTry
     *          nombre de coups
     */

    public void startGame2(char mode,int n, int m, int nMaxTry, boolean dev){


            if (mode == '1') {
                StartChallengerModeGame2 startChallengerModeGame2 = new StartChallengerModeGame2(n, m, nMaxTry,dev);
                startChallengerModeGame2.challengeMode2(n, m, nMaxTry,dev);
            } else if (mode == '2') {
                StartDefenderModeGame2 startDefenderModeGame2 = new StartDefenderModeGame2(n, m, nMaxTry);
                startDefenderModeGame2.defenderMode2(n, m, nMaxTry);

            } else if (mode == '3') {
                StartDuelMode2Games startDuelMode2Games = new StartDuelMode2Games(n, m, nMaxTry,dev);
                startDuelMode2Games.duelMode2(n, m,dev);

            }
    }


}
