package Source;

import java.io.IOException;
import java.util.Scanner;

public class AS2_Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		OperationToProduct Choise = new OperationToProduct();
		MyList<Product> ListPro = new MyList<Product>();
		MyStack<Product> ListStack = new MyStack<Product>();
		MyQueue<Product> ListQueue = new MyQueue<Product>();
		String fileName = "Data.txt";
		int a = 10;
		int pick = 11;
		do {
			Logg.log("+---------------------Chương trình quản lý xuất nhập sản phẩm----------------------+\n"
					+"|     1.  Đọc dữ liệu từ file và hiển thị                                          |\n"
					+"|     2.  Thêm sản phẩm mới                                                        |\n"
					+"|     3.  Hiển thị sản phẩm đang có                                                |\n"
					+"|     4.  Lưu vào file                                                             |\n"
					+"|     5.  Tìm kiếm theo ID                                                         |\n"
					+"|     6.  Xóa theo ID                                                              |\n"
					+"|     7.  Sắp xếp theo ID                                                          |\n"
					+"|     8.  Biểu diễn số lượng sản phẩm của phần tử đầu tiên sang nhị phân           |\n"
					+"|     9.  Tải dữ liệu ngăn xếp và hiển thị                                         |\n"
					+"|     10. Tải dữ liệu hàng đợi và hiện thị                                         |\n"
					+"|     0.  Thoát khỏi chương trình và lưu các output vào file \"console_output.txt\"  |\n"
					+"+----------------------------------------------------------------------------------+\n");
			Logg.log("Vui lòng chọn theo số thứ tự bên trên! \n");
			pick = input.nextInt();
		switch(pick) {
			case 1:
				Logg.log("Đọc dữ liệu \n");				
				Choise.getAllItemsFromFile(fileName, ListPro);
				Logg.log("ID |  Title   | Quantity | price \n");
				Logg.log("-------------------------------- \n");
				Choise.displayAll(ListPro);
				break;
			case 2:
				Logg.log("Them san pham moi \n");
				Product newItem = Choise.createProduct();
				Node<Product> newP = new Node<Product>(newItem);
				ListPro.addToTail(newItem);
				break;
			case 3:
				Logg.log("Hiển thị sản phẩm đang có \n");
				Choise.displayAll(ListPro);
				break;
			case 4:
				String fileSave = "Data.txt";
				Choise.writeAllItemsToFile(fileSave, ListPro);
				break;
			case 5:
				Choise.searchByCode(ListPro);
				break;
			case 6:				
				Choise.deleteByCode(ListPro);
				break;
			case 7:				
				int listLength = ListPro.length();
				Choise.sortByCode(ListPro, listLength);
				Logg.log("Sort done \n");
				break;
			case 8:
				String result = ""+Choise.convertToBinary(ListPro.head.info.quanlity);
				Logg.log("Quality = "+ListPro.head.info.quanlity+" => ("+result+") \n");
				break;
			case 9:
				Logg.log("Đọc dữ liệu từ file vào ngăn xếp và hiển thị \n");
				Logg.log("ID |  Title   | Quantity | price \n");
				Logg.log("-------------------------------- \n");
				Choise.getAllItemsFromFile(fileName, ListStack);	
				break;
			case 10:
				Logg.log("Đọc dữ liệu từ file vào hàng đợi và hiển thị \n");
				Logg.log("ID |  Title   | Quantity | price \n");
				Logg.log("-------------------------------- \n");
				Choise.getAllItemsFromFile(fileName, ListQueue);			
				break;
		}
		}while(pick!=0);
		Logg.log("thanks");
		
	}
	
}

	


