package com.ebookfrenzy.carddemo;
import java.util.ArrayList;

public class Data {
    public ArrayList<String> titles = new ArrayList<>();
    public ArrayList<String> details = new ArrayList<>();
    public ArrayList<Integer> images = new ArrayList<>();

    public Data() {

        String[] temp_titles = {"Chapter One",
                "Chapter Two",
                "Chapter Three",
                "Chapter Four",
                "Chapter Five",
                "Chapter Six",
                "Chapter Seven",
                "Chapter Eight"};

        String[] temp_details = {"Item one details",
                "Item two details", "Item three details",
                "Item four details", "Item five details",
                "Item six details", "Item seven details",
                "Item eight details"};

        int[] temp_images = { R.drawable.android_image_1,
                R.drawable.android_image_2,
                R.drawable.android_image_3,
                R.drawable.android_image_4,
                R.drawable.android_image_5,
                R.drawable.android_image_6,
                R.drawable.android_image_7,
                R.drawable.android_image_8 };

        int min = 0;

        int title_max = temp_titles.length - 1;
        int detail_max = temp_details.length - 1;
        int image_max = temp_images.length - 1;

        int random_title;
        int random_details;
        int random_images;

        for (int i = 0; i < 8; i++){
            random_title = (int)(Math.random() * (title_max - min + 1) + min);
            random_details = (int)(Math.random() * (detail_max - min + 1) + min);
            random_images = (int)(Math.random() * (image_max - min + 1) + min);

            titles.add(temp_titles[random_title]);
            details.add(temp_details[random_details]);
            images.add(temp_images[random_images]);
        }
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public ArrayList<String> getDetails() {
        return details;
    }

    public ArrayList<Integer> getImages() {
        return images;
    }
}
