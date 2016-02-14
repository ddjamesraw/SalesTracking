package by.bsuir.vechorko.dao.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "t_goods")
@XmlRootElement(name = "good")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Good.findAll", query = "SELECT g FROM Good g ORDER BY g.id"),
    @NamedQuery(name = "Good.findById", query = "SELECT g FROM Good g WHERE g.id = :id"),
    @NamedQuery(name = "Good.findByName", query = "SELECT g FROM Good g WHERE g.name = :name"),
    @NamedQuery(name = "Good.findByDescription", query = "SELECT g FROM Good g WHERE g.description = :description"),
    @NamedQuery(name = "Good.findByPrice", query = "SELECT g FROM Good g WHERE g.price = :price"),
    @NamedQuery(name = "Good.findByCategoryId", query = "SELECT g FROM Good g WHERE g.categoryId = :categoryId")})
public class Good implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @XmlElement(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @XmlElement(name = "name", required = true)
    private String name;
    @Size(max = 2147483647)
    @XmlElement(name="description",required = true)
    private String description;
    @Basic(optional = false)
    @NotNull
    @XmlElement(name = "price",required = true)
    private int price;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @XmlElement(name="category",required = true)
    private Category categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodId", fetch=FetchType.LAZY)
    @XmlTransient
    private List<Sale> sales;

    public Good() {}

    public Good(Integer id) {
        this.id = id;
    }

    public Good(Integer id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSaleCollection(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Good)) {
            return false;
        }
        Good other = (Good) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.vechorko.dao.entity.Good[ id=" + id + " ]";
    }    
}
