package com.example.volumecalculator;

import androidx.core.view.ViewCompat;

public class GridModel {
    String shapeName;
    int imageId;

    public GridModel(String shapeName, int imageId) {
        this.shapeName = shapeName;
        this.imageId = imageId;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
