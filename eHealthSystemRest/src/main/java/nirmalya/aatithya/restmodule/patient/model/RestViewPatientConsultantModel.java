package nirmalya.aatithya.restmodule.patient.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestViewPatientConsultantModel {
	private String date;
	private String time;
	private String status;
	private String doctorName;
	private String speciality;
	private String notes;
	private String drid;
	public RestViewPatientConsultantModel(Object date, Object time,  Object status,Object doctorName, Object speciality,
			Object notes, Object drid) {
		this.date = (String)date;
		this.time = (String)time;
		this.status = (String)status;
		this.doctorName = (String)doctorName;
		this.speciality = (String)speciality;
		this.notes = (String)notes;
		this.drid = (String)drid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getDrid() {
		return drid;
	}
	public void setDrid(String drid) {
		this.drid = drid;
	}
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}

}
