package com.example.harshith.multiscreens;

public class Words {

    private String lang;
    private String english;
    private int image=NOIMAGEFOUND;
    private int music;

    public static final int NOIMAGEFOUND=-1;

    public Words(String eng,String lang,int music){
        this.lang = lang;
        this.music = music;
        this.english = eng;
    }

    public Words(String eng,String lang,int image,int music){
        this.lang = lang;
        this.english = eng;
        this.image = image;
        this.music = music;
    }

    public String getLang(){
        return lang;
    }

    public String getEnglish(){
        return english;
    }

    public int getImage() { return image;  }

    public boolean hasImage(){
       if(image!=-1){
           return true;
       }
       return false;
    }

    public int getmusic() {
        return music;
    }
}

