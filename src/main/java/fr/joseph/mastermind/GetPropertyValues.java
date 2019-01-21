package fr.joseph.mastermind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Permet de récupérer les paramètres du jeu du fichier de configuration
 */
public class GetPropertyValues {
    InputStream inputStream;
    int n;
    int nMaxTry;
    int m;
    boolean dev;


    public GetPropertyValues(){
        this.inputStream = inputStream;
    }

    public int getN() {
        return n;
    }

    public int getnMaxTry() {
        return nMaxTry;
    }

    public int getM() {
        return m;
    }

    public boolean isDev() {
        return dev;
    }

    /**
     * permet de lire config.properties dans src/main/resources et de récupérer les paramètres:
     * int n, int n, int Maxtry, int m et booléen dev
     * @throws IOException
     */

    public  void getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("Fichier de configuration '" + propFileName + "' introuvable dans le chemin spécifié");
            }


            String n1 = prop.getProperty("n");
            String nMaxTry1 = prop.getProperty("nMaxTry");
            String m1 = prop.getProperty("m");
            String dev1 = prop.getProperty("dev");


            n = Integer.parseInt(n1);
            nMaxTry = Integer.parseInt(nMaxTry1);
            m=Integer.parseInt(m1);
            dev=Boolean.parseBoolean(dev1);

                    } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
