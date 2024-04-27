package com.green.ilikemovie.board;

import com.green.ilikemovie.board.care.PostBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService service;

    int postBoard(PostBoard p){
        return service.postBoard(p);
    }
}
