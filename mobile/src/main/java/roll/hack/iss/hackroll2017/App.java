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

    }
}

