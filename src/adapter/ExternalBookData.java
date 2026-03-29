package adapter;

public class ExternalBookData {
    private String csvData; 

    public ExternalBookData(String csvData) {
        this.csvData = csvData;
    }

    public String getCsvData() { return csvData; }
}
