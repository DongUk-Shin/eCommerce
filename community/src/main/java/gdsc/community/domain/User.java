package gdsc.community.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String password;
    private String email;
    private String date;
    private String sex;
    private String intro;
    //private String image;

}
