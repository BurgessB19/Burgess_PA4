public class Application {
    public static void main(String[] args) {
        //Sets file name to take input from
        String dataFile = "problem1.txt";

        //Creates object then calls remove method
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        duplicateRemover.remove(dataFile);

        //Sets name for output file
        String output = "unique_words.txt";
        duplicateRemover.write(output);

    }
}
