package org.help.stackhelp.service;

import java.util.List;

public class CdArchiveData {
    private List<CdRecord> records;

    public CdArchiveData(List<CdRecord> records) {
        this.records = records;
    }

    // Getters and Setters
    public List<CdRecord> getAllCDs() {
        return records;
    }

    public void setRecords(List<CdRecord> records) {
        this.records = records;
    }
}
