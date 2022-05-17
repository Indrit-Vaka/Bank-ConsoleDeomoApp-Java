import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.CollationElementIterator;
import java.util.Scanner;

/**
 * By Indrit Vaka
 */
public class Hello {

    public static void main(String[] args) {


        //lets get all the account form the FIle
        //Secili entitet ndahet me ,

        String[] data = FileIV.ReadAllLines("accounts.txt");

        for (int i = 0; i < data.length; i++) {

            String[] parts = data[i].split(",");
            try {
                new eBanking(parts[0], parts[1], Double.parseDouble(parts[2]));
            } catch (Exception e) {
                System.out.println("There was an error : " + e.getMessage());
            }
        }
        eBanking.allAccountCreated = true; //kemi shtuar te gjith acc. I shfaqim perd te Menune

        

        var account1 = new eBanking("Indrit");
        var account2 = new eBanking("vaka", "0037", 357890);

        
    }
}