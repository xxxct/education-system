package vo;

public class Section {
	Long sec_id;
	Long course_id;
	Long semester;
	Long year ;
	String building; 
	String room_number;
	String t_name;
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public Long getSec_id() {
		return sec_id;
	}
	public void setSec_id(Long sec_id) {
		this.sec_id = sec_id;
	}
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	public Long getSemester() {
		return semester;
	}
	public void setSemester(Long semester) {
		this.semester = semester;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

}
