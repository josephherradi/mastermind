package gameone;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n=4;
        int m=9;
        NumberGen numberGen= new NumberGen(n,m);
        int [] resultCombi=numberGen.combiGen();
        System.out.println(Arrays.toString(resultCombi));

        AskComb askComb= new AskComb(n);
        int [] resultPropos=askComb.AskN();
        System.out.println(Arrays.toString(resultPropos));

        CompareInfSup compareInfSup= new CompareInfSup(n);
        String [] resultCompare=compareInfSup.compare(resultCombi,resultPropos);
        System.out.println(Arrays.toString(resultCompare));
    }
}