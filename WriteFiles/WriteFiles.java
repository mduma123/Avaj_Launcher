package WriteFiles;


import java.io.File;
import java.io.FileWriter;
import java.io.*;


public class WriteFiles
{

    static File file;
    static FileWriter fw;

    public static void openFile() {
        try {
            file = new File("simulator.txt");
            if (!file.exists())
            {
                file.createNewFile();
            }
            fw = new FileWriter(file);
        }
        catch (IOException ieo) {

        }
    }

    public static void closeFile() {
        try {
            fw.close();
        }
        catch (IOException ieo) {

        }
    }

    public static void WriteToFile(String letsread)
    {

        try
        {
            fw.write(letsread);
            fw.write("\n");
        }
        catch(IOException ieo)
        {
            ieo.printStackTrace();
        }
    }
}

