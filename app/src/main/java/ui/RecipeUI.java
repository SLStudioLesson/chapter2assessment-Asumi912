package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {

        ArrayList<String> recipeList = fileHandler.readRecipes();

        // レシピリストがnullのとき
        // レシピリストが0だったとき
        if (recipeList == null || recipeList.size() == 0) {
            System.out.println("No recipes available");
        }
        // System.out.println(recipeList);
        for(String recipe : recipeList) {
            String[] str = recipe.split(",", 2);
            System.out.println("Recipe Name: " + str[0]);
            System.out.println("Main Ingredients: " + str[1]);
            System.out.println("=================");
        }

    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * //@throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {
        
            reader = new BufferedReader(new InputStreamReader(System.in));
            String inputRecipeName = "";
            String inputIngredients = "";
        try {
            System.out.println("Enter recipe name: ");
            inputRecipeName = reader.readLine();
            System.out.print("Enter main ingredients (comma separated): ");
            inputIngredients = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    
        fileHandler = new RecipeFileHandler();
        fileHandler.addRecipe(inputRecipeName,  inputIngredients);

        System.out.println("Recipe added successfully");

    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}

// 解答
