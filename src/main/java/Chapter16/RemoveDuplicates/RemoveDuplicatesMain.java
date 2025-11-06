package Chapter16.RemoveDuplicates;

import java.util.*;

public class RemoveDuplicatesMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = new ArrayList<>();
        while (true){
            System.out.println("Enter a name. Type end to exit.");
            String name = scanner.next();
            if (name.toLowerCase().equals("end")){
                break;
            }
            else {
                namesList.add(name);
            }
        }

        Set<String> namesSet = new HashSet<>(namesList);

        for (String name:namesSet){
            System.out.println(name);
        }

        while (true){
            System.out.println("Search for a name. Type end to exit.");
            String name = scanner.next();
            if (name.toLowerCase().equals("end")){
                break;
            }
            else if (namesSet.contains(name)){
                System.out.println("The set contains this name");
            }
            else {
                System.out.println("The set DOES NOT contain this name");
            }
        }
    }
}
