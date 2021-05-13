package tabian.com.example.igtest.shop.category;

public class CategoryModel {

    // 20210415 categoryname
    private String CategoryIconLink;
    private String CategoryName;

    public CategoryModel(String categoryIconLink, String categoryName){
        CategoryIconLink = categoryIconLink;
        this.CategoryName = categoryName;
    }

    public String getCategoryIconLink()
    {
        return CategoryIconLink;
    }

    public void setCategoryIconLink(String categoryIconLink) {
        CategoryIconLink = categoryIconLink;
    }

    public String getCategoryName()
    {
        // return CategoryIconLink;
        return CategoryName;
    }


    public void setCategoryName(String categoryName) {
        this.CategoryName = categoryName;
    }
}


//20210415 categoryname