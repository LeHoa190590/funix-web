package Source;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Stack;

public class OperationToProduct {
	/**

	  * Searching and returning the index of product p in the list. If not found

	  * return -1.

	  *

	  * @param p    Product for searching

	  * @param list The Linked List

	  * @return The index of product p in the list

	  */
	public int index(Product p, MyList<Product> list) {
		Node<Product> target = list.head;
		int a = 0;
		while(target != null) {
			if(target.info.equals(p)) {
				return a;
			}
			a++;
			target = target.next;
		}
		return -1;
	 }

	 

	 /**

	  * Creating and returning a product with info input from keyboard.

	  *

	  * @return The product
	 * @throws IOException 

	  */

	 public Product createProduct() throws IOException {
		 Scanner input = new Scanner(System.in);
		 Logg.log("New ID: ");
		 String newID = input.nextLine();
		 Logg.log("Product Name: ");
		 String newName = input.nextLine();
		 Logg.log("Quantity: ");
		 int quanti = input.nextInt();
		 Logg.log("Price: ");
		 double pri = input.nextDouble();
		 Product newItem = new Product(newID, newName, quanti, pri);

		 
		 return newItem;
	 }

	 

	 /**

	  * Reading all products from the file and insert them to the list at tail.

	  *

	  * @param fileName The file name of the file

	  * @param list     The Linked List contains all products that read from file
	 * @throws ClassNotFoundException 
	 * @throws IOException 

	  */

	 public void getAllItemsFromFile(String fileName, MyList<Product> list) throws ClassNotFoundException, IOException {
		 Product prod = null;
		 FileInputStream fis = null;
		 ObjectInputStream dis = null;
		 try {
			 File file = new File(fileName);
			 fis = new FileInputStream(file);
			 dis = new ObjectInputStream(fis);
			 while(true) {
			 prod = (Product) dis.readObject();
			 list.addToTail(prod);
			 }		 
		 }catch(IOException ex) {
			 System.out.print("");
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }finally { 
			 fis.close();	
			 dis.close();
		 }
	 }

	 

	 /**

	  * Reading all products from the file and insert them to the stack.

	  *

	  * @param fileName The file name of the file

	  * @param stack     The Stack contains all products that read from file
	 * @throws IOException 

	  */

	 public void getAllItemsFromFile(String fileName, MyStack<Product> stack) throws IOException {
		 Product prod = null;
		 FileInputStream fis = null;
		 ObjectInputStream dis = null;
		 try {
			 File file = new File(fileName);
			 fis = new FileInputStream(file);
			 dis = new ObjectInputStream(fis);
			 while(true) {
			 prod = (Product) dis.readObject();	 							 	 
			 Node<Product> newPro = new Node<Product>(prod);
			 	newPro.next = stack.head;	
			 	stack.head = newPro;
			 }		 
		 }catch(IOException ex) {
			 System.out.print("");
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }finally { 
			 fis.close();	
			 dis.close();
		 }
		 if(stack.head==null) {
			 Logg.log("Danh sách rỗng \n");
		 }else {
			 Node<Product> prin = stack.head;
			 while(prin != null) {
				 Logg.log(prin.info+"\n");
				 prin = prin.next;
			 }
		 }
		 
	 }

	 

	 /**

	  * Reading all products from the file and insert them to the queue.

	  *

	  * @param fileName The file name of the file

	  * @param queue     The Queue contains all products that read from file
	 * @throws IOException 

	  */

	 public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws IOException {
		 Product prod = null;
		 FileInputStream fis = null;
		 ObjectInputStream dis = null;
		 try {
			 File file = new File(fileName);
			 fis = new FileInputStream(file);
			 dis = new ObjectInputStream(fis);
			 while(true) {
			 prod = (Product) dis.readObject();	 
			 Node<Product> newPro = new Node<Product>(prod);
				if(queue.head == null) {
					queue.head = queue.tail = newPro;
				}else {
					Node<Product> curr = queue.tail.next;
					while(curr != null) {
						curr = queue.tail.next;
					}
					queue.tail.next = newPro;
					queue.tail = newPro;
				}
			 }		 
		 }catch(IOException ex) {
			 System.out.print("");
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }finally { 
			 fis.close();	
			 dis.close();
		 }
		 if(queue.head==null) {
			 Logg.log("Danh sách rỗng \n");
		 }else {
			 Node<Product> prin = queue.head;
			 while(prin != null) {
				 Logg.log(prin.info+"\n");
				 prin = prin.next;
			 }
		 }
	 }

	 

	 /**

	  * Printing all prodcuts of the list to console screen

	  *

	  * @param list
	 * @throws IOException 

	  */

	 public void displayAll(MyList<Product> list) throws IOException {
		 if(list.head==null) {
			 Logg.log("Danh sách rỗng \n");
		 }else {
			 Node<Product> prin = list.head;
			 while(prin != null) {
				 Logg.log(prin.info+"\n");
				 prin = prin.next;
			 }
		 }
	 }

	 

	 /**

	  * Writing all products from the list to the file

	  *

	  * @param fileName Input file name

	  * @param list     Input Linked list

	  */

	 public void writeAllItemsToFile(String fileName, MyList<Product> list) {
		 try {
			 File file = new File(fileName);
			 if(!file.exists()) {
					file.createNewFile();
				}
			 FileOutputStream fos = new FileOutputStream(file);
			 ObjectOutputStream objout = new ObjectOutputStream(fos);
			 Node<Product> ProSave = list.head;
			 while(ProSave != null) {
				 Product Pro = ProSave.info;
				 objout.writeObject(Pro);
				 ProSave = ProSave.next;
			 }
			 objout.flush();
			 objout.close();
		 }catch(IOException ex){
			 ex.printStackTrace();
		 }
	 }

	 

	 /**

	  * Searching product by ID input from keyboard.

	  *

	  * @param list
	 * @throws IOException 

	  */

	 public void searchByCode(MyList<Product> list) throws IOException {
		 Scanner input = new Scanner(System.in);
		 Logg.log("Input the ID to search: ");
		 String keyID = input.nextLine();
		 Node<Product> Prod = list.head;
		 int check = 0;
		 while(Prod != null) {
			 if(Prod.info.bcode.equals(keyID)) {
				 Logg.log("Result: "+Prod.info+"\n");
				 check++;
				 break;
			 }
			 Prod = Prod.next;
		 }
		 if(check==0) {
			 Logg.log("There is no Product match your key, try again \n");
		 }
	 }

	 

	 /**

	  * Deleting first product that has the ID input from keyboard from the list.

	  *

	  * @param list
	 * @throws IOException 

	  */

	 public void deleteByCode(MyList<Product> list) throws IOException {
		 Scanner input = new Scanner(System.in);
		 Logg.log("Input the ID to delete: ");
		 String keyID = input.nextLine();
		 Node<Product> Prod = list.head;
		 int check = 0;
		 while(Prod != null) {
			 if(Prod.info.bcode.equals(keyID)) {
				 list.deleteElement(Prod.info);
				 check++;
				 break;
			 }
			 Prod = Prod.next;
		 }
		 if(check==0) {
			 Logg.log("There is no Product match your key, try again \n");
		 }else {
			 Logg.log("Product hasbeen delete \n");
		 }
		 

	 }

	 

	 /**

	  * Sorting products in linked list by ID

	  * used Recursion

	  * @param list The Linked list

	  */

	 public void sortByCode(MyList<Product> list, int n) {
		 if(n==0) {
			 return;
		 }else {
			 sortByCode(list, n-1);
			 String a = list.getNode(n).info.bcode;
			 String b = list.getNode(n-1).info.bcode;
			 if(a.compareTo(b)<0) {
				 list.swap(list.getNode(n), list.getNode(n-1));
				 sortByCode(list, n-1);
			 }
		 }			 
	 }
 

	 /**

	  * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010

	  * @param i Input decimal number

	  * @return a integer numbers

	  */

	 public int convertToBinary(int i) {
		 if(i <= 1) {
			 return i;
		 }
		 int remin = i%2;
		 return remin + convertToBinary(i/2)*10;
	 }

}
