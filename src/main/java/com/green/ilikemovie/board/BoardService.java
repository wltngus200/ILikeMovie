package com.green.ilikemovie.board;

import com.green.ilikemovie.board.care.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardMapper mapper;

    int newPost(PostBoard p){
        return mapper.newPost(p);
    }
    List<GetAllBoard> allPost(Paging p){
        return mapper.allPost(p);
    }
    GetOneBoard onePost(long boardNum){
        GetOneBoard result=mapper.onePost(boardNum);
        System.out.println(result);
        if(result!=null){
            mapper.hitsUp(boardNum);
        }
        return mapper.onePost(boardNum);
    }
}
