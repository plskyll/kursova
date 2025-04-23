public class Main {
    public static void main(String[] args) {
        RecipeManager manager = new RecipeManager();

        manager.addRecipe();
        manager.addRecipe();
        manager.showRecipes();


        manager.deleteRecipe();

        manager.showRecipes();

    }
}