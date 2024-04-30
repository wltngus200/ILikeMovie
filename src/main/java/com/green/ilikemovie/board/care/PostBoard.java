package com.green.ilikemovie.board.care;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostBoard {
    private long userIdx;
    private String title;
    private String contents;
}
