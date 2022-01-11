package localdata;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Localdata {

    public static FileInputStream lowInput;
    public static FileOutputStream lowOut;
    public static DataInputStream highInput;
    public static DataOutputStream highOutput;
    public static File localFile;
    public static String dataLocl;

    public Localdata() {
        try {
            localFile = new File("local.txt");
            if(localFile.createNewFile())
            {
                System.out.println("file created "+ localFile.getName()+ localFile.getPath());
            }
            else
            {
                System.out.println("the file is already existed");
            }
            System.out.println("length: "+ localFile.length());
            //dataLocl = readLocalFile(File localFile);
        } catch (IOException ex) {
            Logger.getLogger(Localdata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
