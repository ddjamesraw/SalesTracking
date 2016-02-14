package by.bsuir.vechorko.dao.entity.array;

import by.bsuir.vechorko.dao.entity.Good;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "goods")
public class Goods {
    
    @XmlElement(name = "good", type = Good.class)
    private List<Good> goods = new ArrayList<>();
    
    public Goods() {}
    
    public Goods(List<Good> goods) {
        this.goods = goods;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }
}
