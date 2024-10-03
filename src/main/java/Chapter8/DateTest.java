package Chapter8;

public class DateTest {
    public static void main(String[] args){
        Date date = new Date(12,1,2024);
        for (int i =0; i<60;i++){
            date.nextDay();
        }


    }
}
