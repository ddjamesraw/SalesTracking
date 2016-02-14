package by.bsuir.vechorko.dao.entity.array;

import by.bsuir.vechorko.dao.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users {
    
    @XmlElement(name = "user", type = User.class)
    private List<User> users = new ArrayList<>();
    
    public Users(){}
    
    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
