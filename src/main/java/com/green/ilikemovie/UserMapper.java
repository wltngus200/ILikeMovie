package com.green.ilikemovie;

import com.green.ilikemovie.user.SignUpMem;
import org.apache.ibatis.annotations.Mapper;
import org.mindrot.jbcrypt.BCrypt;

@Mapper
public interface UserMapper {
    int postUser(SignUpMem p);
}
