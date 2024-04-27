package com.green.ilikemovie.board;

import com.green.ilikemovie.board.care.PostBoard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int postBoard(PostBoard p);
}
