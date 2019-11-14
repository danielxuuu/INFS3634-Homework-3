package com.example.cat;

public class Cat {

    private String id;
    private String name;
    private String temperament;
    private String life_span;
    private String description;
    private String weight_imperial;
    private String origin;
    private String wikipedia_url;
    private int dog_friendly;


    public Cat(String id, String name, String temperament, String life_span, String description, String weight_imperial, String origin, String wikipedia_url, int dog_friendly) {
        this.id = id;
        this.name = name;
        this.temperament = temperament;
        this.life_span = life_span;
        this.description = description;
        this.weight_imperial = weight_imperial;
        this.origin = origin;
        this.wikipedia_url = wikipedia_url;
        this.dog_friendly = dog_friendly;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getLife_span() {
        return life_span;
    }

    public String getDescription() {
        return description;
    }

    public String getWeight_imperial() {
        return weight_imperial;
    }

    public String getOrigin() {
        return origin;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }
}
