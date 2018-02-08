package everything;

import javax.persistence.*;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int number;

    protected BuddyInfo() {
        this("no name specified", 0);
    }

    public BuddyInfo(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Long getId() { return  id; }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        return "Name: "+name+", number: "+number;
    }
}
