package com.example.praktikum3;

import static com.example.praktikum3.Adapter.StoryAdapter.ADD_STORY_TYPE;
import static com.example.praktikum3.Adapter.StoryAdapter.ALL_STORY_TYPE;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Post> posts = generateDummyPosts();
    public static ArrayList<StoryModel> storyModeles = generateDummyStory();

    private static ArrayList<Post> generateDummyPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.fpm_profile, "fahdellp", R.drawable.fpm_post, "fahdellp", "Ini postingan pertama" , "15" , "10" , "Ini Bio:)"));
        posts.add(new Post(R.drawable.fpm_profile, "fahdellp", R.drawable.fpm_post, "fahdellp", "Ini postingan kedua" , "27" , "27" , "Ini Bio:)"));
        posts.add(new Post(R.drawable.fpm_profile, "fahdellp", R.drawable.fpm_post, "fahdellp", "Ini postingan Ketiga", "1.223" , "788" , "Ini Bio:)"));
        posts.add(new Post(R.drawable.fpm_profile, "fahdellp", R.drawable.fpm_post, "fahdellp", "Ini postingan Keempat" , "1.465" , "800" , "Ini Bio:)"));
        posts.add(new Post(R.drawable.fpm_profile, "fahdellp", R.drawable.fpm_post, "fahdellp", "Ini postingan Kelima" , "500" , "678" , "Ini Bio:)"));
        posts.add(new Post(R.drawable.fpm_profile, "fahdellp", R.drawable.fpm_post, "fahdellp", "Ini postingan Ketujuh" , "275" , "122" , "Ini Bio:)"));
        posts.add(new Post(R.drawable.fpm_profile, "fahdellp", R.drawable.fpm_post, "fahdellp", "Ini postingan Kedelapan" , "1JT" , "100" , "Ini Bio:)"));
        posts.add(new Post(R.drawable.fpm_profile, "fahdellp", R.drawable.fpm_post, "fahdellp", "Ini postingan Ksembilan" , "110" , "90" , "Ini Bio:)"));
        return posts;
    }

    private static ArrayList<StoryModel> generateDummyStory() {
        ArrayList<StoryModel> storyModeles = new ArrayList<>();

        storyModeles.add(new StoryModel(ADD_STORY_TYPE, "0" , R.drawable.fpm_profile , R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "1" ,"11","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "5" ,"14","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "3" ,"12","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "6" ,"15","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "8" ,"17","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "10" ,"19","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "9" ,"18","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "4" ,"13","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "11" ,"20","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));
        storyModeles.add(new StoryModel(ALL_STORY_TYPE, "7" ,"16","fahdellp", R.drawable.fpm_profile, R.drawable.fpm_story));

        return storyModeles;
    }
}