package fr.joseph.mastermind;

/**
 * Transforme un tableau d'entiers en chaine de caractères
 * utilité pour le logging
 */
public class Utils {
    /**
     * Convertit un tableau d'int en String
     * @param tab tableau d'entiers
     * @return chaine de caractères
     */
    public static String arrayToString(int[] tab){
        String result="";
        for (int i = 0; i <tab.length ; i++) {
            result=result+tab[i];

        }
        return result;
    }

    /**
     * Activation du mode dev par args ou config.properties
     * Si args est dev alors le mode dev est activé
     * sinon on utilise ce qui est indiqué dans config.properties
     * @param args argument de la methode main de la classe principale
     * @param configModeDev mode dev indiqué dans config.properties
     * @return true/false activation mode dev
     */
    public static boolean isModeDev(String[] args, Boolean configModeDev){
        if(args.length==0){
            return configModeDev;
        }
        if(args[0].equals("dev")){
            return  true;
        }
        else{
            return configModeDev;
        }
    }


}
