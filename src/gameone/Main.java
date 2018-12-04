package gameone;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        NumberGen numberGen= new NumberGen(4,9);
        int [] resultCombi=numberGen.combiGen();
        System.out.println(Arrays.toString(resultCombi));
    }
}