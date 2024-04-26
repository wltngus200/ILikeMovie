package com.green.ilikemovie;

import com.green.ilikemovie.user.SignUpMem;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserMapper mapper;

    int postUser(SignUpMem p){
        String password= BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(password);
        return mapper.postUser(p);
    }
}
