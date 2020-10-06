package cyl.straw.ap.iuser.controller;


import cyl.straw.ap.iuser.Util.R;
import cyl.straw.ap.iuser.dto.RegisterStudentDTO;
import cyl.straw.ap.iuser.ex.IllegalParemeterException;
import cyl.straw.ap.iuser.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyl
 * @since 2020-09-05
 */
@RestController
@RequestMapping("/ap.iuser/user")
public class UserController {
    @Autowired
    UserServiceImpl service;
    @RequestMapping("/reg")
    //http:localhost/api/ap.iuser/user/reg?username=sss&password=1234&phone=18857774555&inviteCode=JSD2005-666666
    //http:localhost:8080/ap.iuser/user/reg?username=sss&password=1234&phone=18857774555&inviteCode=JSD2005-666666
    public R register(@Valid RegisterStudentDTO registerStudentDTO, BindingResult bindingResult){
        System.err.println("注册");
        if (bindingResult.hasErrors()){
            String errMessage = bindingResult.getFieldError().getDefaultMessage();
            throw new IllegalParemeterException(errMessage);
        }
        service.RegisterStudent(registerStudentDTO);
        return R.ok();
    }
}
