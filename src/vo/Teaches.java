package vo;

public class Teaches {
	Long ID;
	Long course_id;
	Long sec_id;
	Course course=new Course();
	Section section=new Section();
	Takes takes=new Takes();
	public Long getID() {
		return ID;
	}
	public Takes getTakes() {
		return takes;
	}
	public void setTakes(Takes takes) {
		this.takes = takes;
	}
	public void setID(Long iD) {
		ID = iD;
	}
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
	public void setTeaches(Teaches teaches) {
		setID(teaches.getID());
		setCourse_id(teaches.getCourse_id());
		setSec_id(teaches.getSec_id());
		setCourse(teaches.getCourse());
		setSection(teaches.getSection());
		setTakes(teaches.getTakes());
	}


}
