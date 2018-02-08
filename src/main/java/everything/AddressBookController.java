package everything;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    private AddressBookRepository addressBookRepository;
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @RequestMapping("/addbuddy")
    public void addBuddy(
            @RequestParam(value="addressBookId") Long addressBookId,
            @RequestParam(value="buddyInfoId") Long buddyInfoId) {
        AddressBook addressBook = addressBookRepository.findOne(addressBookId);
        addressBook.addBuddy(buddyInfoRepository.findOne(buddyInfoId));
        addressBookRepository.save(addressBook);
    }

    @RequestMapping("/removebuddy")
    public void removeBuddy(
            @RequestParam(value="addressBookId") Long addressBookId,
            @RequestParam(value="buddyInfoId") Long buddyInfoId) {
        AddressBook addressBook = addressBookRepository.findOne(addressBookId);
        addressBook.removeBuddy(buddyInfoId);
        addressBookRepository.save(addressBook);
    }
}
