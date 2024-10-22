package org.help.stackhelp.service;

import java.util.List;

public class VinylArchiveData {
    private List<VinylRecord> records;

    public VinylArchiveData(List<VinylRecord> records) {
        this.records = records;
    }

    // Getters and Setters
    public List<VinylRecord> getAllVinylRecords() {
        return records;
    }

    public void setRecords(List<VinylRecord> records) {
        this.records = records;
    }
}
