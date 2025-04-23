import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Recipe {
    private int id;
    private static int generateId = 1;
    private String name;
    private List<String> ingredients;
    private int timeCook;




    public Recipe(String name, int timeCook, List<String>ingredients) {
        this.name = name;
        this.timeCook = timeCook;
        this.ingredients = new ArrayList<>(ingredients);
        this.id = generateId++;
    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
    public int getTimeCook() {
        return timeCook;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    public void setTimeCook(int timeCook) {
        this.timeCook = timeCook;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nНазва: " + name +
                "\nЧас приготування: " + timeCook + " хв" +
                "\nІнгредієнти: " + String.join(", ", ingredients);
    }
}
