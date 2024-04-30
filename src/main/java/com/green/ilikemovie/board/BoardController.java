package com.green.ilikemovie.board;

import com.green.ilikemovie.board.care.GetAllBoard;
import com.green.ilikemovie.board.care.GetOneBoard;
import com.green.ilikemovie.board.care.Paging;
import com.green.ilikemovie.board.care.PostBoard;
import com.green.ilikemovie.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService service;

    @PostMapping
     ResultDto<Integer> newPost(@RequestBody PostBoard p){
        int result=service.newPost(p);
         return ResultDto.<Integer>builder()
                 .status(HttpStatus.OK)
                 .resultMsg(result!=0?"정상적으로 게시되었습니다.":"비정상적인 활동이 감지되었습니다.")
                 .resultData(result)
                 .build();
     }
     @GetMapping
     ResultDto<List<GetAllBoard>> allPost(@ModelAttribute Paging p){
        List<GetAllBoard> result = service.allPost(p);
        return ResultDto.<List<GetAllBoard>>builder()
                .status(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result)
                .build();
     }

     @GetMapping("{boardId}")
    ResultDto<GetOneBoard> onePost(long boardNum){
        GetOneBoard result = service.onePost(boardNum);
        return ResultDto.<GetOneBoard>builder()
                .status(HttpStatus.OK)
                .resultMsg(result!=null?"잘못 된 값":HttpStatus.OK.toString())
                .resultData(result)
                .build();
    }
}
