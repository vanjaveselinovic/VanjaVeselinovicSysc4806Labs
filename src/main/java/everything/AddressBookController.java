package everything;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {
    private AddressBookRepository addressBookRepository;
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public AddressBookController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    /*
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
    */

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        model.addAttribute("buddyInfo", new BuddyInfo());
        model.addAttribute("addressBooks", addressBookRepository.findAll());
        model.addAttribute("buddies", buddyInfoRepository.findAll());
        model.addAttribute("addressBookId", new Long(1));
        model.addAttribute("buddyInfoId", new Long(1));
        return "main";
    }

    @PostMapping("/create-address-book")
    public String createAddressBook(@ModelAttribute AddressBook addressBook) {
        addressBookRepository.save(addressBook);
        return "redirect";
    }

    @PostMapping("/create-buddy-info")
    public String createBuddyInfo(@ModelAttribute BuddyInfo buddyInfo) {
        buddyInfoRepository.save(buddyInfo);
        return "redirect";
    }

    @PostMapping("/add-buddy")
    public String addBuddy(
            @RequestParam(value="addressBookId") Long addressBookId,
            @RequestParam(value="buddyInfoId") Long buddyInfoId) {
        AddressBook addressBook = addressBookRepository.findOne(addressBookId);
        addressBook.addBuddy(buddyInfoRepository.findOne(buddyInfoId));
        addressBookRepository.save(addressBook);
        return "redirect";
    }
}
