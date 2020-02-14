package AddressBook.controllers;

import AddressBook.models.AddressBookModel;
import AddressBook.models.BuddyInfoModel;
import AddressBook.repositories.AddressBookModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookRestController {

    @Autowired
    private AddressBookModelRepository addressBookModelRepository;

    @PostMapping("/newAddressBook")
    public AddressBookModel addressBook() {
        AddressBookModel addressBook = new AddressBookModel();
        addressBookModelRepository.save(addressBook);
        return addressBook;
    }

    @GetMapping("/getAddressBook")
    public AddressBookModel addressBook(@RequestParam(value="id") long id) {
        AddressBookModel addressBook = addressBookModelRepository.findById(id);
        return addressBook;
    }

    @PostMapping("/addBuddy")
    public AddressBookModel addBuddy(@RequestParam(value="id") long id, @RequestParam(value="name") String name, @RequestParam(value="phonenumber") String phonenumber ) {
        AddressBookModel addressBook = addressBookModelRepository.findById(id);
        addressBook.addBuddy(name, phonenumber);
        addressBookModelRepository.save(addressBook);
        return addressBook;
    }

    @PostMapping("/removeBuddy")
    public AddressBookModel removeBuddy(@RequestParam(value="id") long id, @RequestParam(value="name") String name, @RequestParam(value="phonenumber") String phonenumber ) {
        AddressBookModel addressBook = addressBookModelRepository.findById(id);
        addressBook.removeBuddy(new BuddyInfoModel(name, phonenumber));
        addressBookModelRepository.save(addressBook);
        return addressBook;
    }
}