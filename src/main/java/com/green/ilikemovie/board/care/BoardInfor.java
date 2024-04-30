package com.green.ilikemovie.board.care;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardInfor {
    private long boardNum;
    private long userIdx;
    private String title;
    private String contents;
    private int cntClick;
    private String postDate;
}
