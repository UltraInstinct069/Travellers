package shahriar.travellers;

/**
 * Created by Hasan Shahriar on 06-Apr-16.
 */
public class Model {
    private String name;
    private int iconID;
    private String size;

    public Model(String name, int iconID,String size) {
        this.name = name;
        this.iconID = iconID;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getIconID() {
        return iconID;
    }

    public String getSize() {
        return size;
    }


}

