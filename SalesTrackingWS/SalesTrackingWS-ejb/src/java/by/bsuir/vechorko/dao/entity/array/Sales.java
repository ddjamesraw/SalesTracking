package by.bsuir.vechorko.dao.entity.array;

import by.bsuir.vechorko.dao.entity.Sale;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sales")
public class Sales {
    
    @XmlElement(name = "sale", type = Sale.class)
    private List<Sale> sales = new ArrayList<>();
    
    public Sales() {}
    
    public Sales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }}
