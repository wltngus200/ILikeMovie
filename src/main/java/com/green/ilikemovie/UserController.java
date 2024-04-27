package com.green.ilikemovie;

import com.green.ilikemovie.common.ResultDto;
import com.green.ilikemovie.usermem.PatchUpw;
import com.green.ilikemovie.usermem.SignUpMem;
import com.green.ilikemovie.usermem.TryLogInMem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@RequestMapping("cafe")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("joinIn")
    ResultDto<Integer> postUser(@RequestBody SignUpMem p){
        int result=service.postUser(p);
        return ResultDto.<Integer>builder().status(HttpStatus.OK)
                .resultMsg("가입에 성공하였습니다.")
                .resultData(result)
                .build();
    }

    @PostMapping("logIn")
    ResultDto<Integer> postLogin(@RequestBody TryLogInMem p){
        int result=service.postLogin(p);
        String msg=switch(result){
            case 3 -> "일치하는 회원을 찾지 못 했습니다.";
            case 2 -> "입력하신 비밀번호가 잘못되었습니다.";
            case 1 -> "로그인에 성공하였습니다.";
            default -> "예상치 못 한 에러가 발생하였습니다.";
        };
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(msg)
                .resultData(result)
                .build();
    }
    @PutMapping
    public ResultDto<Integer> changePw(PatchUpw p){
        int result= service.changePw(p);
        String msg=switch (result){
            case 3 -> "입력하신 아이디가 올바르지 않습니다.";
            case 2 -> "비밀번호가 틀렸습니다.";
            case 1 -> "비밀번호가 정상적으로 변경되었습니다.";
            default -> "예상치 못 한 오류가 발생하였습니다.";
        };
        return ResultDto.<Integer>builder()
                .status(HttpStatus.OK)
                .resultMsg(msg)
                .resultData(result)
                .build();
    }

}
