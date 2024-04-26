package com.green.ilikemovie;

import com.green.ilikemovie.user.SignUpMem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cafe")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    int postUser(SignUpMem p){
        return service.postUser(p);
    }
}
