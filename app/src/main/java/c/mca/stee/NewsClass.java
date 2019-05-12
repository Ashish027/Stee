package c.mca.stee;

public class NewsClass {
    private String headline,description, image;

    public NewsClass(String headline, String description, String image) {
        headline = headline;
        description = description;
        image = image;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
    public NewsClass(){

    }

}
