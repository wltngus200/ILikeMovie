package com.green.ilikemovie.board.care;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostBoard {
    private long userIdx;
    private String nickname;
    private String title;
    private String contents;
    private int cntClick;
}
