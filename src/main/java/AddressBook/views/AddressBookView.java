package AddressBook.views;

import AddressBook.models.BuddyInfoModel;
import AddressBook.controllers.AddressBookController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class AddressBookView extends JFrame implements ActionListener {
		private AddressBookController addressBookController;
		private List <JMenuItem> menuItems = new ArrayList<JMenuItem>();
		private JList<BuddyInfoModel> jList;
		
	public AddressBookView(){
		this.init();
	}

	public void init(){
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		//Default size
		this.setSize(400, 800);

		//Create and add menus to  menuBar
		menuBar.add(createAddressBookMenu());
		menuBar.add(createBuddyMenu());

		//Default behavior on close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void setAddressBookController(AddressBookController addressBookController){
		this.addressBookController = addressBookController;

		//Set List Model for this Views JList object, initially hidden, add to content pane
		this.jList = new JList<BuddyInfoModel>(addressBookController.getListModel());
		this.jList.setVisible(true);

		this.getContentPane().add(jList);
	}
	
	private JMenu createAddressBookMenu() {
		JMenu menu_addressBook = new JMenu("Address Book");

		JMenuItem display = new JMenuItem("Display");
		display.addActionListener(e -> jList.setVisible(true));
		display.setEnabled(true);
		menuItems.add(display);
				
		//Add all menuItems to it's menu
		menu_addressBook.add(display);
		
		return menu_addressBook;
	}
	
	private JMenu createBuddyMenu() {
		JMenu menu_buddyInfo = new JMenu("Buddy Info");
		
		//Create Menu items
		JMenuItem add = new JMenuItem("Add");
		add.addActionListener(e -> {
			String name = JOptionPane.showInputDialog("Name");
			String phoneNumber = JOptionPane.showInputDialog("Phone Number");
			addressBookController.addBuddy(name, phoneNumber);
		});
		add.setEnabled(true);
		menuItems.add(add);
		
		JMenuItem remove = new JMenuItem("Remove");
		remove.addActionListener(e -> addressBookController.removeBuddy(jList.getSelectedValue()));
		remove.setEnabled(true);
		menuItems.add(remove);

		//Add menu items to menu
		menu_buddyInfo.add(add);
		menu_buddyInfo.add(remove);

		return menu_buddyInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
