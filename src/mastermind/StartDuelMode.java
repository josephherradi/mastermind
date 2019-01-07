package mastermind;

public class StartDuelMode {
    int n;
    int m;
    int nMaxTry;

    public StartDuelMode(int n, int m, int nMaxTry) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
    }


    public void duelMode1(int n, int m, int nMaxTry) {

        StartChallengerMode startChallengerMode = new StartChallengerMode(n, m, nMaxTry);
        StartDefenderMode startDefenderMode = new StartDefenderMode(n, m, nMaxTry);
        boolean resultModeCh=false;
        boolean resultModeDef=false;

        do {
            System.out.println("Mode challenger");
            startChallengerMode.challengeMode(n, m, nMaxTry);
            resultModeCh = startChallengerMode.isEqualNtry();
            System.out.println("Mode Defender");
            startDefenderMode.defenderMode(n, m, nMaxTry);
            resultModeDef = startDefenderMode.isEqualNtry();
            this.resultGame(resultModeCh,resultModeDef);
        } while (!(resultModeCh ^ resultModeDef) );


    }

    public void duelMode2(int n, int m, int nMaxTry) {

        StartChallengerMode2 startChallengerMode2 = new StartChallengerMode2(n, m, nMaxTry);
        StartDefenderMode2 startDefenderMode2 = new StartDefenderMode2(n, m, nMaxTry);
        boolean resultModeCh=false;
        boolean resultModeDef=false;

        do {
            System.out.println("Mode challenger");
            startChallengerMode2.challengeMode2(n, m, nMaxTry);
            resultModeCh = startChallengerMode2.isEqualNtry();
            System.out.println("Mode Defender");
            startDefenderMode2.defenderMode2(n, m, nMaxTry);
            resultModeDef = startDefenderMode2.isEqualNtry();
            this.resultGame(resultModeCh,resultModeDef);
        } while (!(resultModeCh ^ resultModeDef));


    }



public void resultGame(boolean resultModeCh, boolean resultModeDef) {
    if (resultModeCh&&!resultModeDef) {
        System.out.println("Bravo vous avez gagné!");
    }
        else if (resultModeDef&&!resultModeCh) {
        System.out.println( "L'ordinateur a gagné :(");
    }
}

}





