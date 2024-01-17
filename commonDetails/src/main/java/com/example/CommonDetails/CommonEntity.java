package com.example.CommonDetails;

public class CommonEntity<StudentEntity, FeesEntity> {

	  private StudentEntity student;
	    private FeesEntity feesDetails;
	    
		public StudentEntity getStudent() {
			return student;
		}
		public void setStudent(StudentEntity student) {
			this.student = student;
		}
		public FeesEntity getFeesDetails() {
			return feesDetails;
		}
		public void setFeesDetails(FeesEntity feesDetails) {
			this.feesDetails = feesDetails;
		}
		public CommonEntity(StudentEntity student, FeesEntity feesDetails) {
			super();
			this.student = student;
			this.feesDetails = feesDetails;
		}
		public CommonEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
}
