package com.random.strings.dtos;

public class RandomDto {

    private Integer rowSize;

    public RandomDto() {
    }

    public RandomDto(Integer rowSize) {
        this.rowSize = rowSize;
    }

    public Integer getRowSize() {
        return rowSize;
    }

    public void setRowSize(Integer rowSize) {
        this.rowSize = rowSize;
    }
}
