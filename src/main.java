import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main
{
    static void modifyFile() throws FileNotFoundException {
        File NumberFile = new File("C:/Users/asger/IdeaProjects/TextFileModificationProgram/NumberFile");
        Scanner fileScanner = new Scanner (NumberFile);

        String oldContent = "";
        Scanner scanner = new Scanner(System.in);

        ArrayList<Object> list = new ArrayList<>();
       while (fileScanner.hasNextLine()) {
            list.add(fileScanner.hasNextLine());
        }

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

    public static void main(String[] args) throws FileNotFoundException {

        modifyFile();

        System.out.println("done");
    }
}