public ContactNode(String name, int phoneNumber) {
this.name = name;
this.phoneNumber = phoneNumber;
this.next = null;  

}
newNode.next = head; 
head = newNode;     
if (head == null) {
head = newNode;
 }
else {
ContactNode temp = head;
while (temp.next != null) {
temp = temp.next;
}

 temp.next = newNode;
}



