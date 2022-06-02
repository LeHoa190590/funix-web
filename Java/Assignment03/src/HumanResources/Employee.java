package HumanResources;

public class Employee extends Staff implements ICalculator{
	//các thuộc tính
	public int extraTime;
	//public int FinalSalary;
	//Hàm tạo
	public Employee(int ID, String name, int age, int salary, String dateBegin, String dept, int vacationDay, int extraTime) {
		super(ID, name, age, salary, dateBegin, dept, vacationDay);
		// TODO Auto-generated constructor stub
		this.extraTime = extraTime;
		this.FinalSalary = isalary();
	}
	
	//Hàm hiển thị thông tin
	@Override
	public String displayInformation() {
		// TODO Auto-generated method stub
		return ("Mã nhân viên: "+ID
		+"| Tên nhân viên: "+name
		+"| Tuổi: "+age
		+"| Số giờ làm thêm: "+extraTime
		+"| Ngày bắt đầu làm việc: "+dateBegin
		+"| Bộ phận: "+dept
		+"| Số ngày nghỉ phép: "+vacationDay+"\n");
	}

	//hàm tính lương
	@Override
	public int isalary() {
		// TODO Auto-generated method stub
		int sala = salary*3000000 + extraTime*200000;
		return sala;
	}
	
}
