package cyl.straw.ap.iuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cyl.straw.ap.iuser.mapper.TagMapper;

import cyl.straw.ap.iuser.service.ITagService;
import cyl.straw.commons.model.Tag;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyl
 * @since 2020-10-05
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
