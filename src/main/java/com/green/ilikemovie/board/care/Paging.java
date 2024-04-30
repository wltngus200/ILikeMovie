package com.green.ilikemovie.board.care;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.ConstructorProperties;


public class Paging {
    //LIMIT n,m
    private int page;
    private int length;
    @JsonIgnore
    private int startIdx;

    @ConstructorProperties({"page", "length"})
    public Paging(Integer page, Integer length){
        this.page=(page!=null?page:1);
        this.length=(length!=null?length:15);
        this.startIdx=(page-1)*length;
    }
}
