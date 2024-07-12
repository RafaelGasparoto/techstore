package br.com.rafael.techstore.dto;

import java.io.Serializable;
import java.util.List;

public class PageResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<?> content;
    private Integer totalPages;
    private boolean firstPage;
    private boolean lastPage;
    
    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public PageResponseDto(List<?> content, Integer totalPages, boolean firstPage, boolean lastPage) {
        this.content = content;
        this.totalPages = totalPages;
        this.firstPage = firstPage;
        this.lastPage = lastPage;
    }

}
