package HumanResources;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HumanResources {
	//khoi tao list
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Staff> ListEmployee = new ArrayList<Staff>();
		ArrayList<Staff> ListManager = new ArrayList<Staff>();
		Scanner input = new Scanner(System.in);
		int pick = 0;
		do {
			System.out.println("--------------");
			System.out.println("Vui lòng pick");
			System.out.println(
					"1. Hiển thị danh sách nhân viên hiện có trong công ty \n"
					+"2. Hiển thị các bộ phận trong công ty \n"
					+"3. Hiển thị các nhân viên theo từng bộ phận \n"
					+"4. Thêm nhân viên mới vào công ty \n"
					+"5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên \n"
					+"6. Hiển thị bảng lương của nhân viên toàn công ty \n"
					+"7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần \n"
					+"8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần \n"
					+"0. Thoat chuong trinh");
			pick= input.nextInt();
			input.nextLine();
			//pick 1
			if(pick==1) {
				inAllEmploy(ListEmployee, ListManager);
			}
			//pick 2
			else if(pick==2) {
				ArrayList<String> ListDept = inAllDept(ListEmployee, ListManager);
				System.out.println("Các bộ phận trong công ty gồm: ");
				for(String var: ListDept) {
					System.out.println("Bộ phận: "+var);
				}
			}
			//pick 3
			else if(pick==3) {
				inAllEmpInDept(ListEmployee, ListManager);
			}
			//pick 4
			else if(pick==4) {
				System.out.print("Bạn muốn thêm nhân viên hay quản lý <1>= Nhân viên; <2>= Quản lý: ");
				int chose = input.nextInt();
				if(chose==1) {
					Staff newEmp = addEmploy();
					ListEmployee.add(newEmp); //them vao danh sach
				}else {
					Staff newMan = addMana();
					ListManager.add(newMan); // them vao danh sach
				}
			}
			//pick 5
			else if(pick==5) {
				System.out.print("Bạn muốn tìm theo tên nhân viên hay mã nhân viên <1>= Tên; <2>= Mã: ");
				int chose = input.nextInt();
				input.nextLine();
				if(chose==1) {
					System.out.print("Vui lòng cho biết tên bạn muốn tìm: ");
					String nameE = input.nextLine();
					searchEmp(nameE, ListEmployee, ListManager); //Tìm theo tên
				}else {
					System.out.print("Vui lòng cho biết ID bạn muốn tìm: ");
					int idEmp = input.nextInt();
					searchEmp(idEmp, ListEmployee, ListManager); // Tìm theo ID
				}
			}
			//pick 6
			else if(pick==6) {
				inAllSalary(ListEmployee, ListManager);
			}
			//pick 7
			else if(pick==7) {
				SalaryHightToLow(ListEmployee, ListManager);
			}
			//pick 8
			else if(pick==8) {
				SalaryLowToHight(ListEmployee, ListManager);
			}else if(pick == 9){
				System.out.print("Chỉ chọn số từ 1-8 hoặc 0 để thoát chương trình, xin chọn lại: ");
				pick = input.nextInt();
				input.nextLine();
			}
		}while(pick!=0);
		System.out.print("Xin cảm ơn và hẹn gặp lại!");
		
		
	}
	//Ham hien thi danh sach nhan vien
	public static void inAllEmploy(ArrayList<Staff> a, ArrayList<Staff> b) {
		for(int i=0; i< a.size();i++) {
			System.out.print(a.get(i).displayInformation());
		}
		for(int i=0; i< b.size();i++) {
			System.out.print(b.get(i).displayInformation());
		}
	}
	
	//Hàm hiển thị bộ phận trong công ty
	public static ArrayList<String> inAllDept(ArrayList<Staff> a, ArrayList<Staff> b) {
		ArrayList<String> ListDept = new ArrayList<>();
		String dept = "";
		String check = "";
		//Tạo danh sách bộ phận
		for(int i=0; i< a.size();i++) {
			dept = a.get(i).dept;
			ListDept.add(dept);
		}
		for(int i=0; i< b.size();i++) {
			ListDept.add(b.get(i).dept);
		}
		
		//loại bỏ những tên bị trùng
		for(int i=0; i<ListDept.size()-1; i++){
			dept = ListDept.get(i);
			for(int j=i+1; j<ListDept.size(); j++){
				check = ListDept.get(j);
				if(check.equals(dept)){
					ListDept.remove(j);
					j=i;
				}
			}
		}
		return ListDept;
	}
	
	//Hàm hiển thị nhân viên theo bộ phận
	public static void inAllEmpInDept(ArrayList<Staff> a, ArrayList<Staff> b) {
		ArrayList<String> ListDep = inAllDept(a, b);
		for(String dep : ListDep) {
			System.out.println("Các nhân viên thuộc bộ phận "+dep+" gồm có: ");
			for(Staff Mnp : b) {
				if(Mnp.dept.equals(dep)) {
					System.out.println("Quản lý: "+Mnp.name);
				}
			}
			for(Staff Emp : a) {
				if(Emp.dept.equals(dep)) {
					System.out.println("Nhân viên: "+Emp.name);
				}
			}
		}
	}
	//Hàm thêm nhân viên mới
	public static Staff addEmploy() {
		Scanner input = new Scanner(System.in);
		System.out.println("ĐÂY LÀ TRANG THÊM MỚI NHÂN VIÊN VÀO CÔNG TY");
		System.out.print("Mã nhân viên: ");
		int id = Integer.parseInt(input.nextLine());
		System.out.print("Tên nhân viên: ");
		String name = input.nextLine();
		System.out.print("Tuổi nhân viên: ");
		int age = input.nextInt();
		System.out.print("Hệ số lương: ");
		int salary = input.nextInt();
		input.nextLine();
		System.out.print("Ngày vào làm: ");
		String dateBegin = input.nextLine();
		System.out.print("Bộ phận: ");
		String dept = input.nextLine();
		System.out.print("Số ngày nghỉ: ");
		int vacation = input.nextInt();
		System.out.print("Số giờ làm thêm: ");
		int extra = input.nextInt();
		Staff emp1 = new Employee(id, name, age, salary, dateBegin, dept, vacation, extra);
		
		return emp1;
	}
	//Hàm thêm quản lý mới
	public static Staff addMana() {
		Scanner input = new Scanner(System.in);
		System.out.println("ĐÂY LÀ TRANG THÊM MỚI QUẢN LÝ VÀO CÔNG TY");
		System.out.print("Mã quản lý: ");
		int id = input.nextInt();
		input.nextLine();
		System.out.print("Tên quản lý: ");
		String name = input.nextLine();
		System.out.print("Tuổi quản lý: ");
		int age = input.nextInt();
		System.out.print("Hệ số lương: ");
		int salary = input.nextInt();
		input.nextLine();
		System.out.print("Ngày vào làm: ");
		String dateBegin = input.nextLine();
		System.out.print("Bộ phận: ");
		String dept = input.nextLine();
		System.out.print("Số ngày nghỉ: ");
		int vacation = input.nextInt();
		input.nextLine();
		System.out.print("Chức vụ: <BL>=Business Leader; <PL>=Project Leader; <TL>=Technical Leader");
		String posi = input.nextLine();
		Staff emp1 = new Manager(id, name, age, salary, dateBegin, dept, vacation, posi);
		
		return emp1;
	}
	
	// Ham tim kiem 
	public static void searchEmp(String c, ArrayList<Staff> a, ArrayList<Staff> b) {
		System.out.println("Kết quả tìm kiếm theo tên: "+c);
		int i = 0;
		for(Staff Emp : a) {
			if(Emp.name.indexOf(c) >= 0) {
				System.out.println("Nhân viên "+Emp.name+" Thuộc bộ phận: "+Emp.dept+" Có mã nhân viên là: "+Emp.ID);
				i++;
			}
		}
		for(Staff Mnp : b) {
			if(Mnp.name.indexOf(c) >= 0) {
				System.out.println("Quản lý "+Mnp.name+" Thuộc bộ phận: "+Mnp.dept);
				i++;
			}
		}
		if(i==0) {
			System.out.println("Rất tiếc, không có ai trong công ty có tên gần giống với tên bạn tìm kiếm");
		}
	}
	
	public static void searchEmp(int c, ArrayList<Staff> a, ArrayList<Staff> b) {
		System.out.println("Kết quả tìm kiếm theo ID: "+c);
		int i = 0;
		for(Staff Emp : a) {
			if(Emp.ID==c) {
				System.out.println("Nhân viên "+Emp.name+" Thuộc bộ phận: "+Emp.dept+" Có mã nhân viên là: "+Emp.ID);
				i++;
			}
		}
		for(Staff Mnp : b) {
			if(Mnp.ID==c) {
				System.out.println("Quản lý "+Mnp.name+" Thuộc bộ phận: "+Mnp.dept+" Có mã nhân viên là: "+Mnp.ID);
				i++;
			}
		}
		if(i==0) {
			System.out.println("Rất tiếc, không có ai trong công ty có ID giống với ID bạn tìm kiếm");
		}
	}
	
	//Ham hien bang luong
	public static void inAllSalary(ArrayList<Staff> a, ArrayList<Staff> b) {
		if(a.size()==0 && b.size()==0) {
			System.out.println("Công ty không có ai, không tính được bảng lương: ");
		}else {
			System.out.println("Dưới đây là bảng lương của toàn bộ nhân viên công ty: ");
			for(Staff Emp: a) {
				System.out.println("Nhân viên: "+Emp.name+" Có mức lương thực nhận là: "+Emp.FinalSalary);	
			}
			for(Staff Mnp: b) {
				System.out.println("Nhân viên: "+Mnp.name+" Có mức lương thực nhận là: "+Mnp.FinalSalary);
			}
		}
	}
	// Ham xap xep luong
	public static void SalaryHightToLow(ArrayList<Staff> a, ArrayList<Staff> b) {
		ArrayList<Staff> list = new ArrayList<>();
		for(var c : a) {
			list.add(c);
		}
		for(var d: b) {
			list.add(d);
		}
		Collections.sort(list , new Comparator<Staff>(){
			@Override
			public int compare(Staff o1, Staff o2) {
				// TODO Auto-generated method stub
				if(o1.FinalSalary < o2.FinalSalary) {
					return 1;
				}else if(o1.FinalSalary == o2.FinalSalary) {
					return 0;
				}else {
					return -1;
				}
			}
		});
		
		System.out.println("Danh sách Nhân viên có mức lương từ cao tới thấp là: ");
		for(int i=0; i< list.size();i++) {
			System.out.println("Nhân viên: "+list.get(i).name+" Với mức lương thực nhận là: "+list.get(i).FinalSalary);
		}
		
	}
	
	public static void SalaryLowToHight(ArrayList<Staff> a, ArrayList<Staff> b) {
		ArrayList<Staff> list = new ArrayList<>();
		for(var c : a) {
			list.add(c);
		}
		for(var d: b) {
			list.add(d);
		}
		Collections.sort(list , new Comparator<Staff>(){
			@Override
			public int compare(Staff o1, Staff o2) {
				// TODO Auto-generated method stub
				if(o1.FinalSalary < o2.FinalSalary) {
					return -1;
				}else if(o1.FinalSalary == o2.FinalSalary) {
					return 0;
				}else {
					return 1;
				}
			}
		});
		
		System.out.println("Danh sách Nhân viên có mức lương từ Thấp tới Cao là: ");
		for(int i=0; i< list.size();i++) {
			System.out.println("Nhân viên: "+list.get(i).name+" Với mức lương thực nhận là: "+list.get(i).FinalSalary);
		}
	}
	
}
