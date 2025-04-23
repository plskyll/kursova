import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RecipeManager {
    private List<Recipe> recipes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addRecipe() {
        System.out.println("Додайте рецепт");
        System.out.println("\nНазва: ");
        String name = scanner.nextLine();
        System.out.println("Інгредієнти: ");
        List<String> ingredients = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
        System.out.println("Час приготування: ");
        int timeCook = scanner.nextInt();
        scanner.nextLine();
        recipes.add(new Recipe(name, timeCook, ingredients));
    }

    public void editRecipe() {
        showRecipes();
        System.out.print("ID рецепта для редагування: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 1 || index > recipes.size()) {
            System.out.println("Невірний номер.");
            return;
        }

        System.out.print("Нова назва: ");
        String name = scanner.nextLine();
        System.out.print("Нові інгредієнти (через кому): ");
        List<String> ingredients = Arrays.asList(scanner.nextLine().split(","));
        System.out.print("Новий час приготування: ");
        int cookTime = Integer.parseInt(scanner.nextLine());


        Recipe recipe = recipes.get(index - 1); // ID починається з 1

        recipe.setName(name);
        recipe.setIngredients(new ArrayList<>(ingredients));
        recipe.setTimeCook(cookTime);
        System.out.println("Рецепт оновлено.");
    }

    public void deleteRecipe(){
        showRecipes();
        System.out.print("ID рецепта для видалення: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 1 || index > recipes.size()) {
            System.out.println("Невірний номер.");
            return;
        }

        System.out.println("Рецепт з ID " + index + " видалено.");
        recipes.remove(index - 1);

    }
    public void showRecipes(){
        System.out.println("Всі рецепти: ");
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println(recipes.get(i).getId());
            System.out.println(recipes.get(i).getName());
            System.out.println(recipes.get(i).getTimeCook());
            System.out.println(recipes.get(i).getIngredients());

            System.out.println();
        }
    }
}
