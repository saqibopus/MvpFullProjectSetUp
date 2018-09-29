package saqib.com.mvpfullprojectsetup.Modules.FamousPersonalities.Fragment.Model;

/**
 * Created by data on 26/9/18.
 */

public class FamousPersonModel {

    private long id;
    private String name;
    private String category;
    private String image;

    public FamousPersonModel(long id, String name, String category, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
