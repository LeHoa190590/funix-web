package HumanResources;

public class Manager extends Staff implements ICalculator{
	//các thuộc tính
	public String position;
	//public int FinalSalary;
	
	public Manager(int ID, String name, int age, int salary, String dateBegin, String dept, int vacationDay, String position) {
		super(ID, name, age, salary, dateBegin, dept, vacationDay);
		// TODO Auto-generated constructor stub
		this.position = position;
		this.FinalSalary = isalary();
	}

	@Override
	public String displayInformation() {
		// TODO Auto-generated method stub
		String posi="";
		switch(position) {
			case "BL":
				posi = "Business Leader";
				break;
			case "PL":
				posi = "Project Leader";
				break;
			case "TL":
				posi = "Technical Leader";
				break;
		}
		return ("Mã nhân viên: "+ID
		+"| Tên nhân viên: "+name
		+"| Tuổi: "+age
		+"| Chức vụ: "+posi
		+"| Ngày bắt đầu làm việc: "+dateBegin
		+"| Bộ phận: "+dept
		+"| Số ngày nghỉ phép: "+vacationDay+"\n");
	}

	@Override
	public int isalary() {
		// TODO Auto-generated method stub
		int respon = 0;
		switch(position){
			case "BL":
				respon = 8000000;
				break;
			case "PL":
				respon = 5000000;
				break;
			case "TL":
				respon = 6000000;
				break;
		}
		int Sal = salary*5000000 + respon;
		return Sal;
	}

}
