package com.example.newssphere;

public class CategoryRvModal {
    private  String category, categoryImageUrl;

    public CategoryRvModal(String category, String categoryImageUrl) {
        this.category = category;
        this.categoryImageUrl = CategoryRvModal.this.categoryImageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = CategoryRvModal.this.category;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }
}
