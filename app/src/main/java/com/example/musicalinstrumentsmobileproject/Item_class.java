package com.example.musicalinstrumentsmobileproject;

public class Item_class {
    private String name;
    private String fact;
    private String link;
    private int image;
    private int sound;

    public Item_class(String name, String fact, String link, int image, int sound) {
        this.name = name;
        this.fact = fact;
        this.link = link;
        this.image = image;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
