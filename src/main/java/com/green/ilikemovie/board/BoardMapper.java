package com.green.ilikemovie.board;

import com.green.ilikemovie.board.care.GetAllBoard;
import com.green.ilikemovie.board.care.GetOneBoard;
import com.green.ilikemovie.board.care.Paging;
import com.green.ilikemovie.board.care.PostBoard;
import com.green.ilikemovie.usermem.UserInfor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int newPost(PostBoard p);
    List<GetAllBoard> allPost(Paging p);
    GetOneBoard onePost(long boardNum);
    int hitsUp(long boardNum);
}
