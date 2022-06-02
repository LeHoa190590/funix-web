package main;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int pick = input.nextInt();
		
			System.out.println("Vui lòng chọn theo số thứ tự bên dưới!"+pick);
			System.out.println("+------------------Chuong trình sắp xếp dãy số------------------+\n"
					+"|     1.  Nhập dãy số                                           |\n"
					+"|     2.  Hiển thị dãy số                                       |\n"
					+"|     3.  Sắp xếp theo kiểu Bubble Sort                         |\n"
					+"|     4.  Sắp xếp theo kiểu Selection Sort                      |\n"
					+"|     5.  Sắp xếp theo kiểu Insertion Sort                      |\n"
					+"|     6.  Tìm số lớn hơn giá trị cụ thể                         |\n"
					+"|     7.  Tìm số bằng giá trị cụ thể                            |\n"
					+"|     0.  Thoát khỏi chương trình                               |\n"
					+"+---------------------------------------------------------------+\n");
		input.close();
	}

}
