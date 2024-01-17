package com.example.FeesDetails.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feesdetails")
public class Fees {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private double amountPaid;
	    private double amountPending;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public double getAmountPaid() {
			return amountPaid;
		}
		public void setAmountPaid(double amountPaid) {
			this.amountPaid = amountPaid;
		}
		public double getAmountPending() {
			return amountPending;
		}
		public void setAmountPending(double amountPending) {
			this.amountPending = amountPending;
		}
		public Fees(Long id, double amountPaid, double amountPending) {
			super();
			this.id = id;
			this.amountPaid = amountPaid;
			this.amountPending = amountPending;
		}
		public Fees() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
