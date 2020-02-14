package AddressBook.controllers;

import AddressBook.models.AddressBookModel;
import AddressBook.models.BuddyInfoModel;
import javax.swing.DefaultListModel;

public class AddressBookController {
	private AddressBookModel addressBookModel;
	private DefaultListModel<BuddyInfoModel> listModel;
	
	public AddressBookController(){
		this.listModel = new DefaultListModel<BuddyInfoModel>();
	}

	public DefaultListModel<BuddyInfoModel> getListModel() {
		return this.listModel;
	}

	public void setAddressBookModel(AddressBookModel addressBookModel) {
		this.addressBookModel = addressBookModel;
	}

	public void addBuddy(String name, String phoneNumber) {
		listModel.addElement(addressBookModel.addBuddy(name, phoneNumber));
	}
	
	public void removeBuddy(BuddyInfoModel buddy) {
		listModel.removeElement(buddy);
		addressBookModel.removeBuddy(buddy);
	}
	
	public String getAddressBookToString() {
		return addressBookModel.toString();
	}
}
