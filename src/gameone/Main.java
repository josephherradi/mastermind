package gameone;


public class Main {

    public static void main(String[] args) {
        int n=4;
        int m=9;
        int nMaxTry=15;

        /*StartChallengerMode startChallengerMode = new StartChallengerMode(n,m,nMaxTry);
        startChallengerMode.challengeMode(n,m,nMaxTry);*/

          StartDefenderMode startDefenderMode= new StartDefenderMode(n,m,nMaxTry);
          startDefenderMode.defenderMode(n,m,nMaxTry);
    }
}