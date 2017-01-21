package roll.hack.iss.hackroll2017.model;

import java.io.Serializable;

/**
 * Created by linby on 21/01/2017.
 */

public class Recipe implements Serializable{

    private int mId;

    private String mName;

    private String mImgPath;

    private int mTimeToCook;

    // Easy, Medium, Hard
    private String mComplexity;

    private int mRating;

    private int mCookingTime;

    private int mServes;

    private int mCalorieCount;

    private String mCuisine;

    private String mDetailedSteps;

    private String mDetailedImagePath;


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImgPath() {
        return mImgPath;
    }

    public void setImgPath(String imgPath) {
        mImgPath = imgPath;
    }

    public int getTimeToCook() {
        return mTimeToCook;
    }

    public void setTimeToCook(int timeToCook) {
        mTimeToCook = timeToCook;
    }

    public String getComplexity() {
        return mComplexity;
    }

    public void setComplexity(String complexity) {
        mComplexity = complexity;
    }

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        mRating = rating;
    }

    public int getCookingTime() {
        return mCookingTime;
    }

    public void setCookingTime(int cookingTime) {
        mCookingTime = cookingTime;
    }

    public int getServes() {
        return mServes;
    }

    public void setServes(int serves) {
        mServes = serves;
    }

    public int getCalorieCount() {
        return mCalorieCount;
    }

    public void setCalorieCount(int calorieCount) {
        mCalorieCount = calorieCount;
    }

    public String getCuisine() {
        return mCuisine;
    }

    public void setCuisine(String cuisine) {
        mCuisine = cuisine;
    }

    public String getDetailedSteps() {
        return mDetailedSteps;
    }

    public void setDetailedSteps(String detailedSteps) {
        mDetailedSteps = detailedSteps;
    }

    public String getDetailedImagePath() {
        return mDetailedImagePath;
    }

    public void setDetailedImagePath(String detailedImagePath) {
        mDetailedImagePath = detailedImagePath;
    }
}
