package com.ubuy;

public class Constants {
	private static Constants instance=null;
	public static Constants GetInstance() {
		if(instance == null)
		{
			instance = new Constants();
		}
		return instance;
	}	
	public String company_name = "UBUY";
	public String company_message = "UBUY, we are a company located in Delhi. We provide goods at home in very small cities.";
	public String admin_mobileno = "8130274916";
	public String currency_name = "₹";
	//index page 
	public String ip_title_message="घर पर ऑर्डर करे";
	public String ip_caption_loginbutton="आपका स्वागत है।";
	public String ip_caption_signup="कृपया अपने बारे में सुचित करे।";
	
	//login page
	public String login_caption_title = "प्रवेश";
	public String login_caption_enter_mobileno = "* 10 अंकों का मोबाइल नंबर दर्ज करें।";
	public String login_caption_know_password= "* पासवर्ड जानने के लिए +91"+admin_mobileno+" से संपर्क करें।";
	public String login_caption_loginbtn= "पधारिए";
	
	// add items page constants
	public String packet = "PACKET(S)";
	public String kg = "KG";
	public String litters = "LITTER(S)";
	
	// signup page constants
	public String uname = "uname";
	public String name = "name";
	public String mobileno = "mobileno";
	public String customer = "Customer";
	public String servletResult = "servletResult";
	public String admin = "admin";
	public String senior_admin = "senior_admin";
	public String junior_admin = "junior_admin";
	public String purchaser = "Purchaser";
	public String delivery_person= "DeliveryPerson";
	public String male = "Male";
	public String female = "Female";
	public String pass = "pass";
	public String customertype = "customertype";
	public String email = "email";
	public String malefemale = "malefemale";
	public String country = "country";
	public String state = "state";
	public String city = "city";
	public String colonyname = "colonyname";
	public String streetname = "streetname";
	public String pin = "pin";
	public String phone = "phone";
	
	public String india = "india";
	public String nepal = "nepal";
	public String srilanka = "srilanka";
	public String bangladesh = "bangladesh";
	
	// signup form messages
	public String name_required_message="नाम आवश्यक है।";
	public String mobileno_required_message="एक वैध मोबाइल नंबर आवश्यक है।";
	public String malefemale_required_message="पुरुष या महिला?";
	public String password_required_message="एक पासवर्ड आवश्यक है।";
	public String confirm_password_required_message="फिर से पासवर्ड दर्ज करें।";
	public String confirm_password_wrong_message="फिर से गलत पासवर्ड दर्ज किया।";
	
	// server response messages
	public String server_error_message="आप गलत जानकारी सबमिट कर रहे हैं या सर्वर त्रुटि हो सकती है।";
	public String server_success_message="Saved successfully";
	public String server_youcan_login_message="Now you can login";
	public String server_error_duplicate_entry_message="Error - Duplicate entry";
	public String server_error_customer_not_found_message="Error - Customer not found";
	public String server_error_empty_quantity_message="Error - Quantity not entered";
	public String server_error_packet_not_numeric_message="Error - Packet should not be in decimal value";
	public String server_error_item_not_found_message="Error - No items found";
	public String server_success_customer_purchase_message="You have successfully placed your order. The goods will be delivered as soon as possible at your destination address.";
	
	// signup caption 
	public String signup_submit="सूचना जमा करिए।";
	public String signup_caption_title="कृपया फॉर्म भरें";
	public String signup_caption_title_goods_delivery_person="कृपया सामान पहुंचाने वाले व्यक्ति का विवरण भरें";
	public String signup_caption_name="* नाम: ";
	public String signup_caption_mobileno="* मोबाइल नंबर: ";
	public String signup_caption_password="* पासवर्ड: ";
	public String signup_caption_confirm_password="* फिर से पासवर्ड दर्ज करें: ";
	public String signup_caption_customertype="* आप कौन हैं:";
	public String signup_caption_purchaser="खरीदार ";
	public String signup_caption_deliveryman="चीज़ें पहुंचाने वाला आदमी  ";
	public String signup_caption_email="ईमेल: ";
	public String signup_caption_malefemale="* पुरुष या महिला:";
	public String signup_caption_male="पुरुष ";
	public String signup_caption_female="महिला ";
	public String signup_caption_address="पता:";
	public String signup_caption_country="देश: ";
	public String signup_caption_state="राज्य: ";
	public String signup_caption_city="शहर: ";
	public String signup_caption_colony="कॉलोनी का नाम: ";
	public String signup_caption_street="सड़क का नाम: ";
	public String signup_caption_pincode="पिन कोड: ";
	public String signup_caption_submit_button="सूचना जमा करिए।";
	public String signup_caption_india="भारत";
	public String signup_caption_nepal="नेपाल";
	public String signup_caption_srilanka="श्री लंका";
	public String signup_caption_bangladesh="बांग्लादेश";	
	
	// add item messages
	public String additem_itemname_required_msg="Enter item name";
	public String additem_rate_required_msg="Enter rate";
	public String additem_packet_msg="Packet should be in integer value";
	// add item parameters 
	public String itemno="itemno";
	public String itemname="itemname";
	public String rate="rate";
	public String unit="unit";
	public String quantity="quantity";
	// add item page caption 
	public String additem_caption_title="Add Items";
	public String additem_caption_itemname="* Item Name: ";
	public String additem_caption_rate="* Rate (Rs/Item): ";
	public String additem_caption_unit="* Unit: ";
	public String additem_caption_save="Save";
	public String additem_caption_viewitems="View";
	//View Items
	public String viewitems_caption_title="Items";
	public String viewitems_caption_name="Name";
	public String viewitems_caption_rate="Rate (Rs per unit)";
	public String viewitems_caption_unit="Unit";
		
	//customer page
	public String customer_caption_profile = "प्रोफ़ाइल";
	public String customer_caption_changepwd = "पासवर्ड बदलें।";
	public String customer_caption_ordergoods= "सामान ऑर्डर करे।";
	public String customer_caption_vieworder= "ऑर्डर किया हुआ सामान देखें।";
	public String caption_logout= "लॉग आउट।";
	
	//admin page
	public String admin_caption_profile = "प्रोफ़ाइल";
	public String admin_caption_viewitems = "View Items";
	public String admin_caption_viewcustomers= "View Customers";
	public String admin_caption_managecustomerpwd= "Manage customer's password";
	public String admin_caption_viewcustomerorders= "View customers's orders";
	public String admin_caption_addDeliveryPerson= "Add detail of goods delivery person";
	
	//view customer page
	public String viewcustomer_caption_title="Customers";
	public String viewcustomer_caption_name="Name";
	public String viewcustomer_caption_mobileno="Mobile No(s)";
	public String viewcustomer_caption_email="Email";
	public String viewcustomer_caption_malefemale="Male or Female";
	public String viewcustomer_caption_type="Type";
	public String viewcustomer_caption_address="Address";
	public String viewcustomer_caption_loginstatus="Login Status";
	public String viewcustomer_caption_search="Search";
	
	//customer places order page
	public String placecustomerorder_caption_title="Purchase";
	public String placecustomerorder_caption_itemno="Item No";
	public String placecustomerorder_caption_itemname="Item Name";
	public String placecustomerorder_caption_itemquantity="Quantity";
	public String placecustomerorder_caption_itemrate="Rate";
	public String placecustomerorder_caption_itemunit="Unit";
	public String placecustomerorder_caption_itemselection="Select/Unselect";
	public String placecustomerorder_caption_selecteditems="Selected items to purchase";
	public String placecustomerorder_caption_totalprice="Price";
	public String servletResultListOfItems= "servletResultListOfItems";
	public String servletResultSelectedListOfItems= "servletResultSelectedListOfItems";
	
	public String purchase_customerorder_caption_destinationAddress= "Enter your destination address";
	public String purchase_customerorder_country_required_message="Select country";
	public String purchase_customerorder_state_required_message="Enter state";
	public String purchase_customerorder_city_required_message="Enter city";
	public String purchase_customerorder_colonyname_required_message="Enter colony name";
	public String purchase_customerorder_streetname_required_message="Enter street name";
	public String purchase_customerorder_pin_required_message="Enter pin";
	public String purchase_customerorder_phone_required_message="Enter phone number of contact person";
	public String purchase_customerorder_caption_title="Purchased order";
	
	//View customer order
	public String purchase_customerorder_table_col1="Items";
	public String purchase_customerorder_table_col2="Order Date";
	public String purchase_customerorder_table_col3="Status";
	public String purchase_customerorder_table_col4="Destination";
		
}
