package gameone;

//import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n=4;
        int m=9;
        int nMaxTry=3;

        StartChallengerMode startChallengerMode = new StartChallengerMode(n,m,nMaxTry);
        startChallengerMode.challengeMode(n,m,nMaxTry);

    }
}