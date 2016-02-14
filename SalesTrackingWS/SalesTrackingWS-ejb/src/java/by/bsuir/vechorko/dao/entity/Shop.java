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
@Table(name = "t_shops")
@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s ORDER BY s.id"),
    @NamedQuery(name = "Shop.findById", query = "SELECT s FROM Shop s WHERE s.id = :id"),
    @NamedQuery(name = "Shop.findByName", query = "SELECT s FROM Shop s WHERE s.name = :name"),
    @NamedQuery(name = "Shop.findByAddress", query = "SELECT s FROM Shop s WHERE s.address = :address")})
public class Shop implements Serializable {
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
    @XmlElement(name = "address", required = true)
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopId", fetch=FetchType.LAZY)
    @XmlTransient
    private List<Sale> sales;

    public Shop() {}

    public Shop(Integer id) {
        this.id = id;
    }

    public Shop(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.vechorko.dao.entity.Shop[ id=" + id + " ]";
    }   
}
