import java.util.ArrayList;
import java.util.List;

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

    public void showRecipe(){
        System.out.println("ID: " + getId());
        System.out.println("Назва: " + getName());
        System.out.println("Час приготування: " + getTimeCook() + " хв.");
        System.out.println("Інградієнти, необхідні для приготування: " + getIngredients());
        System.out.println();
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
    public int getQuantityIngredients(){
        return ingredients.size();
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

}
