package com.green.ilikemovie.board.care;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetOneBoard {
    private long boardNum;
    private long userIdx;
    private String title;
    private String contents;
    private int cntClick;
    private String postDate;
}
