package api.payload;

public class user {

int id;
String username;
String firstName;
String lastName;
String email;
String password;
String phone;
int userStatus=0;
int petid;

int quantity;
String shipDate;
String status;
Boolean complete=true;


public int getPetid() {
	return petid;
}
public void setPetid(int petid) {
	this.petid = petid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getShipDate() {
	return shipDate;
}
public void setShipDate(String shipDate) {
	this.shipDate = shipDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Boolean getComplete() {
	return complete;
}
public void setComplete(Boolean complete) {
	this.complete = complete;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getUserStatus() {
	return userStatus;
}
public void setUserStatus(int userStatus) {
	this.userStatus = userStatus;
}



}
