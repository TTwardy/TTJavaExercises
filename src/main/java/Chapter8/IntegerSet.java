package Chapter8;

import java.lang.reflect.Array;

public class IntegerSet {
    boolean [] set = new boolean[100];

    public IntegerSet (){
    }

    public void addToSet (int number){
        set[number]=true;
    }

    public void printSet(){
        for (int i = 0; i<100; i++){
            if (set[i]){
                System.out.printf("%d\n", i);
            }
        }
    }
    public static void printSet(boolean[] set){
        for (int i = 0; i<100; i++){
            if (set[i]){
                System.out.printf("%d\n", i);
            }
        }
    }
    public static void union(IntegerSet set1, IntegerSet set2){
        boolean [] unionSet = new boolean[100];
        for (int i = 0; i<set1.set.length; i++){
            if (set1.set[i]||set2.set[i]){
                unionSet[i]=true;
            }
        }
        printSet(unionSet);
    }
    public static void intersection(IntegerSet set1, IntegerSet set2){
        boolean [] unionSet = new boolean[100];
        for (int i = 0; i<set1.set.length; i++){
            if (set1.set[i]&&set2.set[i]){
                unionSet[i]=true;
            }
        }
        printSet(unionSet);
    }
    public void deleteElement(int number){
        set[number]=false;
    }

    public String toString(){
        StringBuilder setString= new StringBuilder();
        boolean allEmpty = true;
        for (int i = 0; i< set.length; i++){
            if (set[i]){
                allEmpty=false;
                setString.append(i).append(" ");
            }
        }
        if (allEmpty){
            return "---";
        }
        else {return setString.toString();
        }
    }

    public void isEqual(IntegerSet set1){
        boolean setsEqual = true;
        for (int i = 0; i< set.length;i++){
            if (set[i] != set1.set[i]) {
                setsEqual = false;
                break;
            }
        }
        if (setsEqual){
            System.out.println("Sets are equal");
        }
        else {
            System.out.println("Sets are not equal");
        }

    }

    public static void main(String[] args){
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        IntegerSet set3 = new IntegerSet();
        set1.addToSet(55);
        set1.addToSet(99);
        set1.addToSet(0);
        set2.addToSet(55);
        set2.addToSet(99);
        set2.addToSet(90);
        set2.addToSet(1);
        set2.deleteElement(99);
        //IntegerSet.intersection(set1, set2);
        set2.isEqual(set1);
    }


}
