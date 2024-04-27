package com.green.ilikemovie;

import com.green.ilikemovie.usermem.PatchUpw;
import com.green.ilikemovie.usermem.SignUpMem;
import com.green.ilikemovie.usermem.UserInfor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(SignUpMem p);
    UserInfor idCheck(String uid);
    int changePw(PatchUpw p);
}
