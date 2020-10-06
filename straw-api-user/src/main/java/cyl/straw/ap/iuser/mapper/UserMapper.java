package cyl.straw.ap.iuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cyl.straw.commons.model.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyl
 * @since 2020-09-05
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    User findUserByUsername(String username);
    User findUserByPhone(String phone);
}
