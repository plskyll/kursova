import java.util.*;

public class RecipeManager {
    private List<Recipe> recipes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addRecipe() {
        System.out.println("\nДодайте рецепт");
        System.out.println("Назва: ");
        String name = scanner.nextLine();
        System.out.println("Інгредієнти (через кому): ");
        List<String> ingredients = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
        System.out.println("Час приготування: ");
        int timeCook = scanner.nextInt();
        scanner.nextLine();
        recipes.add(new Recipe(name, timeCook, ingredients));
        System.out.println("Рецепт " + name + " успішно додано\n");
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
        System.out.println("Рецепт оновлено.\n");
    }

    public void deleteRecipe(){
        showRecipes();
        System.out.print("ID рецепта для видалення: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 1 || index > recipes.size()) {
            System.out.println("Невірний номер.");
            return;
        }
        String name = recipes.get(index - 1).getName();
        System.out.println("Рецепт " + name + " з ID " + index + " видалено.\n");
        recipes.remove(index - 1);

    }

    public void filterRecipe() {
        System.out.println("Введіть час для фільтрації: ");
        int time = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        int counter = 0;
        for (int i = 0; i < recipes.size() ; i++) {
            if (recipes.get(i).getTimeCook() == time){
                recipes.get(i).showRecipe();
                counter++;
            }
        }

        if (counter == 0){
            System.out.println("\nЗа цим фільтром рецептів не знайдено.\n");
        }
    }

    public void sortRecipes(){
        System.out.println("Оберіть метод сортування:");
        System.out.println("a. За назвою");
        System.out.println("b. За часом приготування");
        System.out.println("c. За кількістю інгредієнтів");
        System.out.print("Ваш вибір: ");

        String choiceStr = scanner.nextLine();

        if (choiceStr.equalsIgnoreCase("a")) {
            recipes.sort(Comparator.comparing(Recipe::getName));
            showRecipes();
        } else if (choiceStr.equalsIgnoreCase("b")) {
            recipes.sort(Comparator.comparing(Recipe::getTimeCook));
            showRecipes();
        } else if (choiceStr.equalsIgnoreCase("c")) {
            recipes.sort(Comparator.comparing(Recipe::getQuantityIngredients));
            showRecipes();
        } else {
            System.out.println("Невірний вибір.");
        }

        recipes.sort(Comparator.comparing(Recipe::getId)); //вертаю в початковий стан
    }


    public void showRecipes(){
        System.out.println("\nВсі рецепти: ");
        for (int i = 0; i < recipes.size(); i++) {
            recipes.get(i).showRecipe();
        }
    }
}
