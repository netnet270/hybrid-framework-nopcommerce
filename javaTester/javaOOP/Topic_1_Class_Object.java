package javaOOP;

public class Topic_1_Class_Object {
	private int studentId;
	private String studentName;
	private Float theoreticalPoint, practicePoint;

	public Topic_1_Class_Object(int studentId, String studentName, Float theoreticalPoint, Float practicePoint) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.theoreticalPoint = theoreticalPoint;
		this.practicePoint = practicePoint;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Float getTheoreticalPoint() {
		return theoreticalPoint;
	}

	public void setTheoreticalPoint(Float theoreticalPoint) {
		this.theoreticalPoint = theoreticalPoint;
	}

	public Float getPracticePoint() {
		return practicePoint;
	}

	public void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	public Float getAveragePoint() {
		return (theoreticalPoint + practicePoint * 2) / 3 ;
	}
	
	public void showStudentInfo() {
		System.out.println("======== INFORMATION STUDENT: " + getStudentName() + " ========");
		System.out.println("ID = " + getStudentId());
		System.out.println("Name = " + getStudentName());
		System.out.println("Theoretical Point = " + getTheoreticalPoint());
		System.out.println("Practice Point = " + getPracticePoint());
		System.out.println("Average Point = " + getAveragePoint());
		System.out.println("===========================================");
	}

	public static void main(String[] args) {
		Topic_1_Class_Object sv1 = new Topic_1_Class_Object(112, "Hoa", 8.5f, 7.0f);
		sv1.showStudentInfo();
		
		Topic_1_Class_Object sv2 = new Topic_1_Class_Object(100, "Mai", 7f, 8f);
		sv2.showStudentInfo();
		
		Topic_1_Class_Object sv3 = new Topic_1_Class_Object(192, "Lan", 6f, 10f);
		sv3.showStudentInfo();
	}

}
