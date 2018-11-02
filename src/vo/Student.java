package vo;

public class Student {
	Long ID;
	String name ;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Long getTot_cret() {
		return tot_cret;
	}
	public void setTot_cret(Long tot_cret) {
		this.tot_cret = tot_cret;
	}
	String dept_name;
	Long tot_cret;

}
