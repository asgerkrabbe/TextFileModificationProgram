import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main
{
    static void modifyFile()
    {
        File NumberFile = new File("D:/Programs/IdeaProjects/TextFileModificationProgram/NumberFile");

        String oldContent = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type what to replace: ");
        String oldString = scanner.next();

        System.out.println("Type what to replace with: ");
        String newString = scanner.next();


        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(NumberFile));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(NumberFile);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //No matter what the code will be executed
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {

        modifyFile();

        System.out.println("done");
    }
}