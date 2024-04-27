package com.green.ilikemovie;

import com.green.ilikemovie.usermem.PatchUpw;
import com.green.ilikemovie.usermem.SignUpMem;
import com.green.ilikemovie.usermem.TryLogInMem;
import com.green.ilikemovie.usermem.UserInfor;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserMapper mapper;

    int postUser(SignUpMem p){
        String password= BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(password);//aa123
        return mapper.postUser(p);
    }

    //1 로그인 성공 2 비밀번호 틀림 3 아이디 없음
    //어차피 성공하면 영향받은 행이 1 성공 =1
    int postLogin(TryLogInMem p){
        UserInfor infor=mapper.idCheck(p.getUid());
        if(infor==null){return 3;}//같은 아이디의 회원이 없다

        //String password=BCrypt.hashpw(p.getUpw(),BCrypt.gensalt());
        //if(password.equals(infor.getUpw())){return 3;} //같은 패스워드라도 암호화 될 때마다 다르니 다를 듯

        if(!BCrypt.checkpw(p.getUpw(),infor.getUpw())){return 2;}
        //BCrypt.checkpw() 입력된 애를 다시 암호화 해 암호화 한 애랑 비교
                    //(입력된 패스워드, 일치하는 아이디에서 가져온 패스워드)
        return 1;//회원은 있으나 비밀번호가 틀림
    }
    //1 비밀번호 교체 완료  2 비밀번호가 틀림 3 아이디가 일치하지 않음
    //영향받은 행의 값을 return하기 때문에 1로 로그인 성공
    int changePw(PatchUpw p){//p는 내가 swagger에 입력한 값(아이디, 비번, 새 비번)
        UserInfor infor= mapper.idCheck(p.getUid());//mapper가 데이터베이스에서 해당 아이디의 값을 가져옴
        if(infor==null){return 3;}//회원정보 없음!
        if(!BCrypt.checkpw(p.getUpw(),infor.getUpw())){return 2;}//비번이 다름!
        String password=BCrypt.hashpw(p.getNewpw(),BCrypt.gensalt());
        p.setNewpw(password);
        p.setUid(infor.getUid());//내 경우 멤버필드가 없기 때문에 별 효과 X PK name=~Idx
        return mapper.changePw(p);
    }
}
