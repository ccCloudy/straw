package cyl.straw.ap.iuser.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class RegisterStudentDTO implements Serializable {
    private String username;
    @NotBlank(message = "注册失败！请填写有效的用户名！")
    private String nickname;
    @Pattern(regexp = "^\\w{4,16}$", message = "注册失败！密码的长度必须是4~16位！")
    private String password;
    private Integer gender;
    private LocalDate dayOfBirth;
    @Pattern(regexp = "^\\d{11}$", message = "注册失败！手机号码格式错误！")
    private String phone;
    private String selfIntroduction;
    @NotBlank(message = "注册失败！邀请码格式错误！")
    private String inviteCode;
}
