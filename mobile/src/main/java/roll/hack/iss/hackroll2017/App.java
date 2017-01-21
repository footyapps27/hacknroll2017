package roll.hack.iss.hackroll2017;

import android.app.Application;
import android.os.Build;
import android.speech.tts.TextToSpeech;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Locale;

import roll.hack.iss.hackroll2017.model.Recipe;

/**
 * Created by Suba Raj on 1/21/2017.
 */

public class App extends Application{
    public RequestQueue queue;//only create one queue during the volley life

    //application Context scope parameter

    /****************************/
    // Properties
    /****************************/

    private static App mInstance;

    public TextToSpeech mTextToSpeech;

    public ArrayList<Recipe> mMockRecipes;

    public boolean blAlreadyExecuted;

    /****************************/
    // App Lifecycle
    /****************************/

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
       // mTextToSpeech = new TextToSpeech(mInstance, this);
        initVolleySetting();
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    /**
     * init volley request queue setting
     * configure some volley spec setting
     */
    private void initVolleySetting() {
        queue = Volley.newRequestQueue(this);
    }

    /****************************/
    // Interface Implementation
    /****************************/
    public void onInit(int initStatus) {
        if (initStatus == TextToSpeech.SUCCESS) {
            /*mTextToSpeech.setLanguage(Locale.US);
            mTextToSpeech.setSpeechRate(0.8f);*/
        }
    }

    /****************************/
    // Public Methods
    /****************************/
   /* public void speak(String textToSpeak) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTextToSpeech.speak(textToSpeak, TextToSpeech.QUEUE_ADD, null, null);
        }
        else {
            mTextToSpeech.speak(textToSpeak, TextToSpeech.QUEUE_ADD, null);
        }
    }*/

    public ArrayList<Recipe> getMockData() {
        updateMockData();
        return mMockRecipes;
    }

    public void updateMockData() {

        mMockRecipes = new ArrayList<>();

        Recipe recipe1 = new Recipe();
        recipe1.setId(226705);
        recipe1.setName("Scramble Eggs with Tomato and Scallions");
        recipe1.setImgPath("https://spoonacular.com/recipeImages/Scramble-Eggs-with-Tomato-and-Scallions-(Huevos-Revueltos-con-Tomate-y-Cebolla)-226705.jpg");
        recipe1.setRating(4);
        recipe1.setTimeToCook(10);
        recipe1.setCalorieCount(250);
        recipe1.setComplexity("Easy");
        recipe1.setDetailedSteps("Step 1: In a medium non-stick skillet heat the oil over medium heat. " +
                "Step 2: Add the tomatoes and scallions and cook about 5 minutes, stirring occasionally.Meanwhile, in a small bowl beat the eggs and salt." +
                "Step 3: Pour the eggs in the skillet with the tomato mixture and cook over medium heat, without stirring, until mixture begins to set.Stir twice or until the eggs mix with the tomato and scallions and cook about 2 minutes or until the eggs are the consistency you like." +
                "Step 4: Transfer to a serving plate and serve with arepa or toast."
        );


        Recipe recipe2 = new Recipe();
        recipe2.setId(245354);
        recipe2.setName("Tuscan Scrambled Eggs");
        recipe2.setImgPath("https://spoonacular.com/recipeImages/Tuscan-Scrambled-Eggs-245354.jpg");
        recipe2.setRating(4);
        recipe2.setTimeToCook(60);
        recipe2.setCalorieCount(244);
        recipe2.setComplexity("Medium");
        recipe2.setDetailedSteps("Step 1: Heat olive oil on medium heat in a nonstick skillet." +
                "Step 2: Add the onions and cook until translucent, just starting to turn golden in color, about 6 minutes." +
                "Step 3: Add the tomatoes and cook over low heat until the liquid evaporates, about 40 minutes." +
                "Step 4: Whisk the eggs in a bowl until well blended.  Season with a little salt and pepper." +
                "Step 5: Add the eggs to the tomato and cook over medium heat, stirring constantly, and scraping from the bottom with a wooden spoon." +
                "Step 6: Remove from heat as soon as the eggs begin to set, but are still moist, about 3 minutes.  Turn out onto a serving plate." +
                "Step 7: Serve immediately."
        );


        Recipe recipe3 = new Recipe();
        recipe3.setId(110920);
        recipe3.setName("Spanish Tortilla with Broccoli, Chorizo, and Onion");
        recipe3.setImgPath("https://spoonacular.com/recipeImages/spanish-tortilla-with-broccoli-chorizo-and-onion-2-110920.png");
        recipe3.setRating(2);
        recipe3.setTimeToCook(30);
        recipe3.setCalorieCount(481);
        recipe3.setComplexity("Difficult");
        recipe3.setDetailedSteps("Step 1: In a large bowl, whisk eggs together with 1 teaspoon salt and 1/2 teaspoon black pepper. Set aside." +
                "Step 2: Heat half of olive oil in a 10-inch non-stick or cast iron skillet over high heat until simmering." +
                "Step 3: Add broccoli and cook without moving until well charred on one side, about 2 minutes. Reduce heat to medium and continue to cook, stirring occasionally, until broccoli is very tender, about 5 minutes longer." +
                "Step 4: Add onions and chorizo, season to taste with salt and pepper, reduce heat to medium, and continue to cook, stirring frequently, until onions and broccoli are completely softened, about 5 minutes longer." +
                "Step 5: Add broccoli/onion mixture to bowl with eggs and stir immediately to combine. Return skillet to heat and add remaining 1/4 cup olive oil." +
                "Step 6: Heat until shimmering." +
                "Step 7: Add egg mixture and cook, stirring gently with a wooden spoon or rubber spatula until eggs are about 1/3 set, about 1 minute. Continue to cook, swirling pan gently until eggs are set about 2/3 of the way through and base of tortilla is deep golden brown, about 5 minute longer." +
                "Step 8: Place a large plate over the skillet and using both hands and two kitchen towels, invert skillet and plate so that tortilla flips out onto the plate with the cooked-side up. Carefully slide back into skillet. Continue to cook, gently swirling pan until tortilla is golden brown on second side, about 4 minutes longer. For a perfect shape, invert onto plate and slide back into skillet 4 to 5 more times." +
                "Step 9: Transfer to a cutting board and let rest at least 5 minutes and up to 3 hours before slicing and serving with allioli."

        );


        Recipe recipe4 = new Recipe();
        recipe4.setId(172369);
        recipe4.setName("Chicken Salad-Stuffed Tomato Appetizers");
        recipe4.setImgPath("https://spoonacular.com/recipeImages/chicken-salad-stuffed-tomato-appetizers-172369.jpg");
        recipe4.setRating(5);
        recipe4.setTimeToCook(35);
        recipe4.setCalorieCount(60);
        recipe4.setComplexity("Easy");
        recipe4.setDetailedSteps("Step 1: With sharp knife, cut 1/4-inch off stem side of each tomato and 1/8-inch off bottoms. Using melon baller or small spoon, remove insides of tomatoes; discard." +
                "Step 2: Make cuts in ends of each green onion piece; place in bowl of ice water until curly." +
                "Step 3: In small bowl, mix chicken salad and horseradish." +
                "Step 4: Place 1 teaspoon chicken salad in each tomato." +
                "Step 5: Place 1 green onion brush in top center of each tomato for stem."
        );


        Recipe recipe5 = new Recipe();
        recipe5.setId(577610);
        recipe5.setName("Brussels Sprouts and Egg Skillet");
        recipe5.setImgPath("https://spoonacular.com/recipeImages/Brussels-Sprouts-and-Egg-Skillet-577610.jpg");
        recipe5.setRating(4);
        recipe5.setTimeToCook(25);
        recipe5.setCalorieCount(296);
        recipe5.setComplexity("Easy");
        recipe5.setDetailedSteps("Step 1: In an 8 inch cast iron skillet, heat olive oil over medium heat." +
                "Step 2: Add in onions and saute for 3-4 minutes. Stir in shredded Brussels Sprouts, salt, and pepper." +
                "Step 3: Let cook for two minutes, add in tablespoons of water, cover, and cook until Brussels Sprouts are tender." +
                "Step 4: Remove lid, make well in center, and crack eggs. Cover and let cook until egg whites have set and egg yolk is desired consistency." +
                "Step 5: Place 1 green onion brush in top center of each tomato for stem."
        );


        Recipe recipe6 = new Recipe();
        recipe6.setId(584018);
        recipe6.setName("Baked Tomato & Egg Breakfast");
        recipe6.setImgPath("https://spoonacular.com/recipeImages/Baked-Tomato---Egg-Breakfast-584018.jpg");
        recipe6.setRating(5);
        recipe6.setTimeToCook(35);
        recipe6.setCalorieCount(340);
        recipe6.setComplexity("Easy");
        recipe6.setDetailedSteps("Step 1: Preheat oven to 350 F.Line a baking sheet with aluminum foil." +
                "Step 2: Cut the tops of the tomatoes off.With a spoon (I like to use a serrated grapefruit spoon), spoon out all the tomato innards.Crack an egg in each hallowed-out tomato." +
                "Step 3: Bake at 350 F for 30 minutes." +
                "Step 4: Let cool for a few minutes.Dust with minced parsley, salt & pepper then enjoy!"
        );


        Recipe recipe7 = new Recipe();
        recipe7.setId(600265);
            recipe7.setName("Chinese Imperial Palace Egg Drop Soup");
        recipe7.setImgPath("https://spoonacular.com/recipeImages/Chinese-Imperial-Palace-Egg-Drop-Soup-600265.jpg");
        recipe7.setRating(4);
        recipe7.setTimeToCook(15);
        recipe7.setCalorieCount(61);
        recipe7.setComplexity("Easy");
        recipe7.setDetailedSteps("Step 1: Bring the broth to a simmer over low medium heat. Very slowly stream in the egg, use a fork to pull strands of the egg gently. Do not stir vigorously; you will have a mess if you do." +
                "Step 2: Add white pepper and salt. Continue to cook until egg is done." +
                "Step 3: Serve promptly."
        );


        Recipe recipe8 = new Recipe();
        recipe8.setId(589973);
        recipe8.setName("Pizza alla Bismark- with eggs");
        recipe8.setImgPath("https://spoonacular.com/recipeImages/Pizza-alla-Bismark--with-eggs-589973.jpg");
        recipe8.setRating(4);
        recipe8.setTimeToCook(20);
        recipe8.setCalorieCount(885);
        recipe8.setComplexity("Medium");
        recipe8.setDetailedSteps("Step 1: Preheat oven to 450º." +
                "Step 2: Heat saute pan on cooktop over medium-high heat." +
                "Step 3: Add olive oil and onions, then saute until onions start to soften & color on edges." +
                "Step 4: Place pizza crust on a sheet of heavy aluminum foil." +
                "Step 5: Spread sauteed onions and oil over crust, making sure to spread the oil to coat all of the top side of the pizza crust. Crack eggs directly over crust." +
                "Step 6: Place in pizza, foil & all into preheated oven." +
                "Step 7: Bake for approximately 10 minutes, or until crust turns golden and eggs start to set." +
                "Step 8: Remove from oven, season with a touch of sea salt & fresh cracked pepper. Slice & enjoy."
        );


        Recipe recipe9 = new Recipe();
        recipe9.setId(630080);
        recipe9.setName("Tortilla de Patatas");
        recipe9.setImgPath("https://spoonacular.com/recipeImages/Tortilla-de-Patatas-630080.jpg");
        recipe9.setRating(5);
        recipe9.setTimeToCook(45);
        recipe9.setCalorieCount(570);
        recipe9.setComplexity("Difficult");
        recipe9.setDetailedSteps("Step 1: Place potatoes in a large colander, sprinkle with 2 tsp. salt, and toss to coat." +
                "Step 2: Let stand for 30 minutes. Pat dry with paper towels." +
                "Step 3: Heat oil in a large nonstick skillet over medium-high heat." +
                "Step 4: Add potatoes and cook, turning occasionally, until crisp-tender, 1015 minutes." +
                "Step 5: Add onion to potatoes in skillet; cook until onion and potatoes are soft, 58 minutes. Using a slotted spoon, transfer mixture to a large bowl; let cool slightly. Strain oil into a heatproof bowl; set aside." +
                "Step 6: Add eggs to potato mixture; season with salt. Wipe out skillet." +
                "Step 7: Heat  cup reserved oil over medium-high heat (chill remaining oil for another use)." +
                "Step 8: Add egg mixture, arranging potatoes to submerge.Reduce heat to medium; cook tortilla until almost set (it will be slightly runny on top), 2530 minutes. Invert onto a large plate. Slide into skillet browned side up. Cook until golden on bottom and cooked through, about 4 minutes more." +
                "Step 9: Serve warm or at room temperature."
        );

        Recipe recipe10 = new Recipe();
        recipe10.setId(490800);
        recipe10.setName("Broccoli and Cheese Egg Casserole");
        recipe10.setImgPath("https://spoonacular.com/recipeImages/Broccoli-and-Cheese-Egg-Casserole-490800.jpg");
        recipe10.setRating(5);
        recipe10.setTimeToCook(50);
        recipe10.setCalorieCount(138);
        recipe10.setComplexity("Medium");
        recipe10.setDetailedSteps("Step 1: Crack the eggs into a large bowl." +
                "Step 2: Whisk. Stir in all the chopped vegetables, tomatoes, salt, pepper, and cheese." +
                "Step 3: Pour into a greased 9 across 13 dish." +
                "Step 4: Bake at 350* for 45 minutes.Cool on a wire rack. Refrigerate."
        );

        mMockRecipes.add(recipe1);
        mMockRecipes.add(recipe2);
        mMockRecipes.add(recipe3);
        mMockRecipes.add(recipe4);
        mMockRecipes.add(recipe5);
        mMockRecipes.add(recipe6);
        mMockRecipes.add(recipe7);
        mMockRecipes.add(recipe8);
        mMockRecipes.add(recipe9);
        mMockRecipes.add(recipe10);
    }
}

