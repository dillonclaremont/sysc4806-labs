package AddressBook.controllers;

import AddressBook.models.AddressBookModel;
import AddressBook.repositories.AddressBookModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookWebController {

    @Autowired
    private AddressBookModelRepository addressBookModelRepository;

    @GetMapping("/viewAddressBook")
    public String viewAddressBook(@RequestParam(value="id") long id, Model model) {
        AddressBookModel addressBook = addressBookModelRepository.findById(id);
        model.addAttribute("addressBook", addressBook);
        return "viewAddressBook";
    }
}
