public class Application {
        public static void main(String[] args) {
            //Sets file name to take input from
            String dataFile = "problem2.txt";

            //Creates object then calls count method
            DuplicateCounter duplicateCounter = new DuplicateCounter();
            duplicateCounter.count(dataFile);

            //Sets name for output file
            String output = "unique_word_count.txt";
            duplicateCounter.write(output);

        }
}
