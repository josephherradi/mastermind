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
        boolean resultModeCh;
        boolean resultModeDef;
        do {
            System.out.println("Mode challenger");
            startChallengerMode.challengeMode(n, m, nMaxTry);
            resultModeCh=startChallengerMode.isEqualNtry();
            System.out.println(resultModeCh);

            System.out.println("Mode Defender");
            startDefenderMode.defenderMode(n, m, nMaxTry);
            resultModeDef=startDefenderMode.isEqualNtry();
            System.out.println(resultModeDef);



        }while(!resultModeCh || !resultModeDef);
    }
}