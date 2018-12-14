package com.example.qis_rnd.neoly.model;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class MedicineResponse {
    @SerializedName("Status")
    private String page;
    @SerializedName("Data")
    private List<Medicine> results;
    @SerializedName("Remarks")
    private String totalResults;
//    @SerializedName("total_pages")
//    private int totalPages;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Medicine> getResults() {
        return results;
    }

    public void setResults(List<Medicine> results) {
        this.results = results;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

//    public int getTotalPages() {
//        return totalPages;
//    }
//
//    public void setTotalPages(int totalPages) {
//        this.totalPages = totalPages;
//    }
}
