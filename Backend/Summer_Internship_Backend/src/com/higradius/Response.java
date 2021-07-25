package com.higradius;

public class Response {
	String customerName;
	String customerNo;
	String invoice;
	String invoiceAmount;
	String dueDate;
	String clearDate;
	String PredictedAgingBucket;
	String notes;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getClearDate() {
		return clearDate;
	}
	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPredictedAgingBucket() {
		return PredictedAgingBucket;
	}
	public void setPredictedAgingBucket(String predictedAgingBucket) {
		PredictedAgingBucket = predictedAgingBucket;
	}
}
