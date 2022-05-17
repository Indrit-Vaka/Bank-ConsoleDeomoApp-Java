import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIV {

    /**
     * Read a Text in file
     * 
     * @param path The path of the file
     * @return Return the content of the File
     */
    public static String ReadAllText(String path) {

        File data = new File(path);
        Scanner sc;
        String text = "";
        try {
            sc = new Scanner(data);
            while (sc.hasNextLine())
                text += sc.nextLine();
        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
        }
        return text;
    }

    /**
     * Reads line in text file
     * 
     * @param path The path of the file
     * @return A arrey of String. Each line of file has one position on arrey
     */
    public static String[] ReadAllLines(String path) {

        File data = new File(path);
        Scanner sc;

        List<String> text = new ArrayList<String>();
        try {
            sc = new Scanner(data);
            while (sc.hasNextLine()) {
                text.add(sc.nextLine());
            }

        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
        }

        return text.toArray(String[]::new);
    }

    /**
     * Writes a file, If file doesnt exist it creates if it exist it overides
     * 
     * @param path    Path of the file
     * @param Content Content you what to wite to the file
     */
    public static void WriteAllText(String path, String Content, boolean append) {
        FileWriter writer;
        try {
            if (append)
            writer = new FileWriter(new File(path), true);
        else
            writer = new FileWriter(new File(path));

            writer.write(Content);
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
        }
    }

    /**
     * Writes a arrey in a file, If file doesnt exist it creates if it exist it
     * overides
     * 
     * @param path    Path of the file
     * @param Content Content you what to wite to the file
     * @param append True if you whant to keep the existing content
     */
    private static void WriteAllLines(String path, String[] Content) {
        FileWriter writer;
        try {
            writer = new FileWriter(new File(path));

            for (int i = 0; i < Content.length; i++) {
                writer.write(Content[i]);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
        }
    }

    public static void WriteAllText(String path, String Content){
        WriteAllText(path, Content, false);
    }
    public static void Append(String path, String Content){
        WriteAllText(path, Content, true);
    }


    /**
     * Writes a arrey in a file, If file doesnt exist it creates if it exist it
     * overides
     * 
     * @param path    Path of the file
     * @param Content Content you what to wite to the file
     */
    public static void WriteAllLines(String path, List<String> Content) {
        FileWriter writer;
        try {
            writer = new FileWriter(new File(path));
            for (String string : Content) {
                writer.write(string);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
        }
    }

}
