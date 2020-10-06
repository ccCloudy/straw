package cyl.straw.ap.iuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cyl.straw.ap.iuser.Util.PasswordUtils;
import cyl.straw.ap.iuser.dto.RegisterStudentDTO;
import cyl.straw.ap.iuser.ex.*;
import cyl.straw.ap.iuser.mapper.ClassInfoMapper;
import cyl.straw.ap.iuser.mapper.UserMapper;

import cyl.straw.ap.iuser.service.IUserService;
import cyl.straw.commons.model.ClassInfo;
import cyl.straw.commons.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyl
 * @since 2020-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ClassInfoMapper classInfoMapper;

    @Override
    public void RegisterStudent(RegisterStudentDTO registerStudentDTO) {
//        //用户名判断
//        String username = registerStudentDTO.getUsername();
//        User result = userMapper.findUserByUsername(username);
//        if (result != null){
//            throw new UsernameDuplicateException("注册失败！用户已注册");
//        }
        //电话号码判断
        String phone = registerStudentDTO.getPhone();
        User result = userMapper.findUserByPhone(phone);
        if (result != null){
            throw new PhoneDuplicateException("注册失败！电话号码已注册");
        }
        //邀请码判断
        String inviteCode = registerStudentDTO.getInviteCode();
        QueryWrapper<ClassInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("invite_code",inviteCode);
        ClassInfo classInfo = classInfoMapper.selectOne(queryWrapper);
        if (classInfo == null){
            throw new InviteCodeException("注册失败！邀请码错误");
        }
        if (classInfo.getIsEnabled()==0){
            throw new ClassDisabledException("注册失败！班级已过期");
        }
        User user = new User();
        user.setUsername(registerStudentDTO.getPhone());
        user.setNickname(registerStudentDTO.getNickname());
        String rawPassword = registerStudentDTO.getPassword();
        user.setPassword("{bcrypt}"+PasswordUtils.encode(rawPassword));
        user.setGender(registerStudentDTO.getGender());
        user.setDayOfBirth(registerStudentDTO.getDayOfBirth());
        user.setPhone(registerStudentDTO.getPhone());
        user.setClassId(classInfo.getId());
        user.setIsEnabled(1);
        user.setIsLocked(0);
        user.setAccountType(1);
        user.setSelfIntroduction(registerStudentDTO.getSelfIntroduction());
        LocalDateTime gmt_create = LocalDateTime.now();
        LocalDateTime gmt_modified = LocalDateTime.now();
        user.setGmtCreate(gmt_create);
        user.setGmtModified(gmt_modified);
        int num = userMapper.insert(user);
        if (num != 1){
            throw new InsertException("注册失败！系统繁忙，请稍后重试");
        }
    }
}
