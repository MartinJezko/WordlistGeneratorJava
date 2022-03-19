import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Random;


class wordlistgen {
    
    static int combs_amt; // THE COMBINATIONS AMMOUNT

    public static void main(String[] args) {
        
        try {
            clearTerminal();

            Scanner ask_combs_amt = new Scanner(System.in); // We declare the ammount of combinations trough Scanner input
            System.out.println("Enter ammount of combinations (1,2,3,... [3 is max])");
            combs_amt = Integer.parseInt(ask_combs_amt.nextLine());
            
            getWords(); // We enter the words for our wordlist
            generateCombinations(); // We generate combinations of the previous words
            writefile(); // We print the wordlist output into our worlist.txt file
            
            ask_combs_amt.close(); // We close the first Scanner
        }

        catch (Exception e) {
            System.out.println("Some error idk");
        }
    }
    

    static ArrayList<String> words_list = new ArrayList<String>(); // Zoznam slov
    static ArrayList<String> combinations_list = new ArrayList<String>(); // Zoznam vytorenych kombinacii

    static void getWords() {
        
        clearTerminal();

        int x = 0;
        while (x == 0) {

            Scanner ask_word = new Scanner(System.in);
            System.out.println("Enter word, write END if finished: ");
            String word_temp = ask_word.nextLine(); // ERROR

            if (word_temp.equals("END")) {
                x = 1;

                clearTerminal();
                ask_word.close();

                System.out.println(words_list);
            }
            else {
                words_list.add(word_temp);
                clearTerminal();
            }

        }


    }

    
    static void generateCombinations() {
        
        for (int i = 0; i < words_list.size(); i++) {
            if (combs_amt == 1) {
                String temp_str = words_list.get(i);
                System.out.println(temp_str);
                combinations_list.add(temp_str);
            }

            else {
                for (int j = 0; j < words_list.size(); j++) {
                    if (combs_amt == 2) {
                        String temp_str = words_list.get(i) + words_list.get(j);
                        System.out.println(temp_str);
                        combinations_list.add(temp_str);
                    }
                    else {
                        for (int k = 0; k < words_list.size(); k++) {
                            String temp_str = words_list.get(i) + words_list.get(j) + words_list.get(k);
                            System.out.println(temp_str);
                            combinations_list.add(temp_str);
                        }
                    }
                }
            }
        }

    }

    static void writefile() {

        try {
            String filename = "wordlist.txt";
            FileWriter fw = new FileWriter(filename, true);

            for (int i = 0; i < combinations_list.size(); i++) {
                
                fw.write(combinations_list.get(i) + "\n");

            }
            fw.close();
        }
        catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
        }

    }

    static void clearTerminal() {

        System.out.print("\033[H\033[2J");  
        System.out.flush(); 

    }


}