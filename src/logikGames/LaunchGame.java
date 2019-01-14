package logikGames;

public class LaunchGame {

    char mode;

    public LaunchGame(char mode) {
        this.mode = mode;

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

    public void startGame1(char mode,int n, int m, int nMaxTry){

             if (mode == '1') {
                StartChallengerMode startChallengerMode = new StartChallengerMode(n, m, nMaxTry);
                startChallengerMode.challengeMode(n, m, nMaxTry);

            } else if (mode == '2') {
                StartDefenderMode startDefenderMode = new StartDefenderMode(n, m, nMaxTry);
                startDefenderMode.defenderMode(n, m, nMaxTry);

            } else if (mode == '3') {
                StartDuelMode startDuelMode = new StartDuelMode(n, m, nMaxTry);
                startDuelMode.duelMode1(n, m);

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

    public void startGame2(char mode,int n, int m, int nMaxTry){


            if (mode == '1') {
                StartChallengerMode2 startChallengerMode2 = new StartChallengerMode2(n, m, nMaxTry);
                startChallengerMode2.challengeMode2(n, m, nMaxTry);
            } else if (mode == '2') {
                StartDefenderMode2 startDefenderMode2 = new StartDefenderMode2(n, m, nMaxTry);
                startDefenderMode2.defenderMode2(n, m, nMaxTry);

            } else if (mode == '3') {
                StartDuelMode startDuelMode = new StartDuelMode(n, m, nMaxTry);
                startDuelMode.duelMode2(n, m);

            }
    }


}
