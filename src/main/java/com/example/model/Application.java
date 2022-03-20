package com.example.model;

import org.springframework.data.annotation.Id;

public class Application {

    @Id
    private Long appId;
    private String status;
    private String offerLetter;
    private String faculty_id;
    private long startDate;
    private long endDate;
    private String term;
    private int year;
    private int crn;
    private int section;
    private int creditHour;
    private String courseTitle;
    private boolean paid;
    private boolean unpaid;
    
    private EmployerModel employer;

    public Application(Long appId, String status, String offerLetter, String faculty_id, long startDate, long endDate,
            String term, int year, int crn, int section, int creditHour, String courseTitle, boolean paid,
            boolean unpaid, EmployerModel employer) {
        this.appId = appId;
        this.status = status;
        this.offerLetter = offerLetter;
        this.faculty_id = faculty_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.term = term;
        this.year = year;
        this.crn = crn;
        this.section = section;
        this.creditHour = creditHour;
        this.courseTitle = courseTitle;
        this.paid = paid;
        this.unpaid = unpaid;
        this.employer = employer;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOfferLetter() {
        return offerLetter;
    }

    public void setOfferLetter(String offerLetter) {
        this.offerLetter = offerLetter;
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isUnpaid() {
        return unpaid;
    }

    public void setUnpaid(boolean unpaid) {
        this.unpaid = unpaid;
    }

    public EmployerModel getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerModel employer) {
        this.employer = employer;
    }

    
    
}
