import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemover {

    //Sets instance variable
    String uniqueWords;

    //Remove method
    public void remove(String dataFile) {

        //Probably and extra string I didn't need to use
        String newString = "";

        //Sets up try/catch in case of Exceptions in IO
        try {

            Scanner read = new Scanner(new FileReader(dataFile));
            ArrayList<String> temp = new ArrayList<String>();

            //While loop for reading file
            while (read.hasNext()) {
                String text = read.next();
                text = text.toLowerCase();
                temp.add(text);
            }

            //Closing File
            read.close();

            //Sets word back into another array
            String[] textArray = temp.toArray(new String[0]);

            //For loops and if statements to find duplicates and remove them
            for (int i = 0; i < textArray.length; ++i) {
                for (int j = i + 1; j < textArray.length; ++j) {
                    if (textArray[i].equals(textArray[j])) {
                        textArray[j] = textArray[j].replace(textArray[j], "");
                    }
                }
            }

            //Sets textArray to a string
            for (String str : textArray) {
                newString = newString + " " + str;

            }

            //Gets rid of extra spaces and adds a comma between the unique words
            newString = newString.trim().replaceAll(" +", ", ");

            //Sets uniqueWords to final string value
            uniqueWords = newString;
        }
        catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    //Write method
    public void write(String outputFile){

        //Sets up try/catch in case of Exceptions in IO
        try {

            //Creates FileWriter to output file and closes it
            FileWriter output = new FileWriter(outputFile);
            output.write(uniqueWords);
            output.close();

        }catch (IOException e){
            System.out.println(e);
        }
    }
}

