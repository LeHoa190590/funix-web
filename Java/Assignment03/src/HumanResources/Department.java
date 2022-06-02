package HumanResources;

public class Department {
	// cac thuoc tinh
	public int DeptId;
	public String deptName;
	public int numberStaff;
	//phuong thuc hien thi
	public String toString() {
		return "Mã bộ phận: "+DeptId+"\n"+"Tên bộ phận: "+deptName+"\n"+"Số lượng nhân viên: "+numberStaff+"\n";
	}

}
