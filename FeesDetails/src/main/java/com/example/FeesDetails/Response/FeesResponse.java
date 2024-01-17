package com.example.FeesDetails.Response;

public class FeesResponse {

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
		public FeesResponse(Long id, double amountPaid, double amountPending) {
			super();
			this.id = id;
			this.amountPaid = amountPaid;
			this.amountPending = amountPending;
		}
		public FeesResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
		
}
