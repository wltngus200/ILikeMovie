package com.green.ilikemovie.board;

import com.green.ilikemovie.board.care.PostBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardMapper mapper;

    int postBoard(PostBoard p){
        return mapper.postBoard(p);
    }
}
