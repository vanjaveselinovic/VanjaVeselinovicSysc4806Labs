package everything;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        buddies = new LinkedList<BuddyInfo>();
    }

    public Long getId() { return  id; }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public void removeBuddy(Long id) {
        BuddyInfo buddyToRemove = null;

        for (BuddyInfo buddyInfo : buddies) {
            if (buddyInfo.getId().equals(id)) buddyToRemove = buddyInfo;
        }

        removeBuddy(buddyToRemove);
    }

    public void printBuddy(BuddyInfo buddy) {
        System.out.println("Name: "+buddy.getName());
        System.out.println("Number: "+buddy.getNumber());
    }

    public void printBuddy(int i) {
        printBuddy(buddies.get(i));
    }

    public void printBuddies() {
        for (int i = 0; i < buddies.size(); i++) {
            System.out.println("Buddy "+i);
            printBuddy(i);
            System.out.println("----------");
        }
    }

    @ModelAttribute(value = "addressBook")
    public AddressBook newAddressBook() {
        return new AddressBook();
    }
}
