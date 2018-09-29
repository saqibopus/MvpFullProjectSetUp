package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model;

/**
 * Created by emxcel on 29/9/18.
 */

public class CategoryModel {

    private int categoryId;
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryModel(int categoryId, String categoryName) {

        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
