package by.bsuir.vechorko.dao.entity.array;

import by.bsuir.vechorko.dao.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "categories")
public class Categories {

    @XmlElement(name = "category", type = Category.class)
    private List<Category> categories = new ArrayList<>();

    public Categories() {}
    
    public Categories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
