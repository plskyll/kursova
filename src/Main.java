import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecipeManager manager = new RecipeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Виберіть дію: ");
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                manager.addRecipe();
            } else if (choice == 2) {
                manager.showRecipes();
            } else if (choice == 3) {
                manager.editRecipe();
            } else if (choice == 4) {
                manager.deleteRecipe();
            } else if (choice == 5) {
                manager.filterRecipe();
            } else if (choice == 6) {
                manager.sortRecipes();
            } else if (choice == 7) {
                break;
            } else {
                System.out.println("Невірний вибір.");
            }

        }
    }

    public static void menu() {
        System.out.println("\n=== Меню управління рецептами ===");
        System.out.println("1. Додати новий рецепт");
        System.out.println("2. Переглянути всі рецепти");
        System.out.println("3. Редагувати рецепт");
        System.out.println("4. Видалити рецепт");
        System.out.println("5. Фільтрувати за часом приготування");
        System.out.println("6. Сортувати рецепти");
        System.out.println("7. Вийти");
        System.out.print("Ваш вибір: ");
    }
}
