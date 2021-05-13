package tabian.com.example.igtest.shop;

public class SliderModel {

    private int banner;
    private String backgroundColor;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public SliderModel(int banner){
        this.banner = banner;
    }

    public int getBanner(){
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }
}
