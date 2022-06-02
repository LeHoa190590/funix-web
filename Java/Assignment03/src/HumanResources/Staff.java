package HumanResources;


public abstract class Staff {
	//Các thông tin cơ bản của nhân viên
	public int ID;
	public String name;
	public int age;
	public int salary;
	public String dateBegin;
	public String dept;
	public int vacationDay;
	public int FinalSalary;
	// Hàm hiển thị thông tin là hàm abstract
	public abstract String displayInformation();
	// Hàm tao
	public Staff(int ID, String name, int age, int salary, String dateBegin, String dept, int vacationDay) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.dateBegin = dateBegin;
		this.dept = dept;
		this.vacationDay = vacationDay;
	}
	
}

