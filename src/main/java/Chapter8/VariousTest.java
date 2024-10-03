package Chapter8;

public class VariousTest {
    public enum Food{
        APPLE("fruit", 100),
        BANANA("fruit", 200),
        CARROT("vegetable", 50);

        final String type;
        final int calories;

        Food(String type, int calories){
            this.type = type;
            this.calories = calories;
        }

        public String getType(){
            return type;
        }

        public int getCalories(){
            return calories;
        }

    }
    public static void main(String[] args){
        for(Food food: Food.values()){
            System.out.printf("%s Type:%s Calories%d \n",food ,food.getType(), food.getCalories());
        }

    }


}
