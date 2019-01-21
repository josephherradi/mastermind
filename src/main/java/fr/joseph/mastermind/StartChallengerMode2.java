package fr.joseph.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Challenger mode du mastermind
 * Le joueur devine la combinaison de l'IA en nMaxTry coups
 * L'IA indique le nombre de chiffres présents et bien placés
 * et le nombre de chiffres présents et pas bien placés
 */

public class StartChallengerMode2 {
    static final Logger logger = LogManager.getLogger(Logger.class.getName());

    int n;
    int m;
    int nMaxTry;
    boolean equalNtry=true;
    boolean dev=true;



    public StartChallengerMode2(int n, int m, int nMaxTry, boolean dev) {
        this.n = n;
        this.m = m;
        this.nMaxTry = nMaxTry;
        this.dev=dev;

    }


    public void challengeMode2(int n, int m, int nMaxTry, boolean dev) {
        int nTry = 0;

        NumberGen numberGen = new NumberGen(n, m);
        int[] resultCombi = numberGen.combiGen();
        String resultFcombi= IntStream.of(resultCombi).mapToObj(String::valueOf).collect(Collectors.joining(""));

        if(dev){
        System.out.println("Combinaison de l'IA "+resultFcombi);
        logger.info("Combinaison de l'IA "+resultFcombi);
        }



        AskComb askComb = new AskComb(n);

        CompareVtwo compareVtwo= new CompareVtwo(n);



        do {
            nTry++;
            System.out.println("");
            System.out.print("Entrez les "+n);
            System.out.print(" chiffres de votre proposition ");
            logger.info("Entrez les "+n);
            logger.info("chiffres de votre proposition ");
            int[] resultPropos = askComb.AskN();
            String resultFpropos= IntStream.of(resultPropos).mapToObj(String::valueOf).collect(Collectors.joining(""));

            logger.info("Proposition "+nTry+": "+resultFpropos);
            int[] resultCompare = compareVtwo.compareVtwo(resultCombi, resultPropos);
            boolean resultTry = compareVtwo.resGame2(resultCompare);
            System.out.println("");
            compareVtwo.showResult(resultCompare);

            equalNtry = resultTry;

        }while (!equalNtry && (nTry < nMaxTry));

        if (equalNtry) {
            System.out.print("Success ! Vous avez trouvé la combinaison en ");
            System.out.print(nTry);
            System.out.println(" essais");
            logger.info("Success ! Vous avez trouvé la combinaison en ");
            logger.info(nTry+" essais");

        } else {
            System.out.println("Fail :( ");
            System.out.println("La combinaison était");
            System.out.println(resultFcombi);
            logger.info("Fail :(");
            logger.info("La combinaison était "+resultFcombi);
        }

    }

    }
