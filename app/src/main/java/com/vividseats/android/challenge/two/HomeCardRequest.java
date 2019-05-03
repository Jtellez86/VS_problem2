package com.vividseats.android.challenge.two;

public class HomeCardRequest {
    private String startDate = "2019-05-18";
    private String endDate = "2019-05-18";
    private boolean includeSuggested = true;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isIncludeSuggested() {
        return includeSuggested;
    }

    public void setIncludeSuggested(boolean includeSuggested) {
        this.includeSuggested = includeSuggested;
    }
}
