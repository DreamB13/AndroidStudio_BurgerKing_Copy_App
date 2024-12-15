package com.dreamb.burgerking_copy;

import java.util.List;

public class ParentItem {
    private String parentText;
    private List<String> childTexts;

    public ParentItem(String parentText, List<String> childTexts) {
        this.parentText = parentText;
        this.childTexts = childTexts;
    }

    public String getParentText() {
        return parentText;
    }

    public List<String> getChildTexts() {
        return childTexts;
    }
}
