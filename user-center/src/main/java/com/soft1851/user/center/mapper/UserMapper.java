package com.soft1851.user.center.mapper;

import com.soft1851.user.center.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 分享(User)表数据库访问层
 *
 * @author zeng
 * @since 2020-09-29 16:27:06
 */
public interface UserMapper extends Mapper<User> {

}