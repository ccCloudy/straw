package cyl.straw.ap.iuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cyl.straw.ap.iuser.dto.RegisterStudentDTO;
import cyl.straw.commons.model.User;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyl
 * @since 2020-09-05
 */
public interface IUserService extends IService<User> {
    void RegisterStudent(RegisterStudentDTO registerStudentDTO);
}
