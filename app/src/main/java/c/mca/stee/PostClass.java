package c.mca.stee;

public class PostClass {
    public String postTitle;
    private String postdesp, uri;

    public PostClass(String postdesp, String uri,String postTitle) {
        this.postdesp = postdesp;
        this.uri = uri;
        this.postTitle = postTitle;
    }

    public String getPostdesp() {
        return postdesp;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getUri() {
        return uri;
    }
    public PostClass(){

    }


}

