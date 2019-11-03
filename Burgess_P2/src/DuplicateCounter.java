import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {
    //Sets instance variable
    String wordCounter = "";

    //Count Method
    public void count (String dataFile) {
        //Creates HashMap to store unique words and their counts
        HashMap<String, Integer> uniqueWordCount = new HashMap();


        int counter = 0;

        //Sets up try/catch in case of Exceptions in IO
        try {

            //Read file and set up list of array to separate words in file
            Scanner read = new Scanner(new FileReader(dataFile));
            ArrayList<String> temp = new ArrayList<String>();

            //While loop for reading file
            while (read.hasNext()) {
                String text = read.next();
                text = text.toLowerCase();
                temp.add(text);
            }
            //Closing file
            read.close();

            //Sets word back into another array
            String[] textArray = temp.toArray(new String[0]);

            //For loops and if statements to match duplicates and store count number
            for (int i = 0; i < textArray.length; ++i) {
                counter = 1;
                for (int j = i + 1; j < textArray.length; ++j) {
                    if (textArray[i].equals(textArray[j])) {
                        counter++;
                        textArray[j] = textArray[j].replace(textArray[j], "");
                        uniqueWordCount.put(textArray[i], counter);
                    }
                }
                //Set uniqueWords to correct values to write to file
               if (counter > 1){
                   if (!textArray[i].equals("")) {
                       //System.out.print(textArray[i] + " - ");
                       //System.out.println(uniqueWordCount.get(textArray[i]));
                       wordCounter = wordCounter + textArray[i] + " - " + uniqueWordCount.get(textArray[i]) + "\n";
                   }
               }
            }
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
            output.write(wordCounter);
            output.close();

        }catch (IOException e){
            System.out.println(e);
        }
    }
}

