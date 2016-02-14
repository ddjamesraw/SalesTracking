package by.bsuir.vechorko.dao.entity;

import by.bsuir.vechorko.dao.entity.util.DateAdapter;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name = "t_sales")
@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s ORDER BY s.saleDate DESC"),
    @NamedQuery(name = "Sale.findById", query = "SELECT s FROM Sale s WHERE s.id = :id"),
    @NamedQuery(name = "Sale.findByQt", query = "SELECT s FROM Sale s WHERE s.qt = :qt"),
    @NamedQuery(name = "Sale.findBySaleDate", query = "SELECT s FROM Sale s WHERE s.saleDate = :saleDate"),
    @NamedQuery(name = "Sale.findByGoodId", query = "SELECT s FROM Sale s WHERE s.goodId = :goodId"),
    @NamedQuery(name = "Sale.findByShopId", query = "SELECT s FROM Sale s WHERE s.shopId = :shopId")})
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @XmlElement(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @XmlElement(name = "count", required = true)
    private int qt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sale_date")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlElement(name = "date", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date saleDate;
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @XmlElement(name = "shop", required = true)
    private Shop shopId;
    @JoinColumn(name = "good_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @XmlElement(name = "good", required = true)
    private Good goodId;

    public Sale() {}

    public Sale(Integer id) {
        this.id = id;
    }

    public Sale(Integer id, int qt, Date saleDate) {
        this.id = id;
        this.qt = qt;
        this.saleDate = saleDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    public Good getGoodId() {
        return goodId;
    }

    public void setGoodId(Good goodId) {
        this.goodId = goodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.vechorko.dao.entity.Sale[ id=" + id + " ]";
    }
    
}
