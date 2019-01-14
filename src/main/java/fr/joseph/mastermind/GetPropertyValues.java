package fr.joseph.mastermind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class GetPropertyValues {
    InputStream inputStream;
    int n;
    int nMaxTry;


    public GetPropertyValues(){
        this.inputStream = inputStream;
    }

    public int getN() {
        return n;
    }

    public int getnMaxTry() {
        return nMaxTry;
    }


    public  void getPropValues() throws IOException {



        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }


            String n1 = prop.getProperty("n");
            String nMaxTry1 = prop.getProperty("nMaxTry");
            n = Integer.parseInt(n1);
            nMaxTry = Integer.parseInt(nMaxTry1);


                    } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }
}
