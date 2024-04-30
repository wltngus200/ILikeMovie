package com.green.ilikemovie.board.care;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter

public class GetAllBoard {
    private long boardNum;
    private long userIdx;
    private String title;
    private String contents;
    private int cntClick;
    private String postDate;
}
