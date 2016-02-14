package by.bsuir.vechorko.dao.entity.array;

import by.bsuir.vechorko.dao.entity.Shop;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shops")
public class Shops {
    
    @XmlElement(name = "shop", type = Shop.class)
    private List<Shop> shops = new ArrayList<>();
    
    public Shops() {}
    
    public Shops(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
