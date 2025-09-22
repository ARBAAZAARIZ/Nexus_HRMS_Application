package util;

import java.util.List;

public class BbPaginationHelper<T> {
    private List<T> data;
    private int totalRecords;
    private int totalPages;
    private int currentPage;

    public BbPaginationHelper(List<T> data, int totalRecords, int recordsPerPage, int currentPage) {
        this.data = data;
        this.totalRecords = totalRecords;

        
        if (recordsPerPage <= 0) {
            this.totalPages = 0;
            this.currentPage = 0;
            return;
        }

        this.totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

      
        if (currentPage < 1) {
            this.currentPage = 1;
        } else if (currentPage > totalPages) {
            this.currentPage = totalPages;
        } else {
            this.currentPage = currentPage;
        }
    }

    public List<T> getData() {
        return data;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

  
    public boolean hasNextPage() {
        return currentPage < totalPages;
    }

    public boolean hasPreviousPage() {
        return currentPage > 1;
    }

    public int getNextPage() {
        return hasNextPage() ? currentPage + 1 : totalPages;
    }

    public int getPreviousPage() {
        return hasPreviousPage() ? currentPage - 1 : 1;
    }
}
