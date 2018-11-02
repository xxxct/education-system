package vo;

public class Takes {
	Long ID;
	Long course_id;
	Long sec_id;
	Long grade ;
	Course course=new Course();
	Section section=new Section();
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	public Long getSec_id() {
		return sec_id;
	}
	public void setSec_id(Long sec_id) {
		this.sec_id = sec_id;
	}
	public Long getGrade() {
		return grade;
	}
	public void setGrade(Long grade) {
		this.grade = grade;
	}



}
