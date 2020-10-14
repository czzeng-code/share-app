package com.soft1851.user.center.listener;

import com.soft1851.user.center.domain.dto.UserAddBonusMsgDto;
import com.soft1851.user.center.domain.entity.BonusEventLog;
import com.soft1851.user.center.domain.entity.User;
import com.soft1851.user.center.mapper.BonusEventLogMapper;
import com.soft1851.user.center.mapper.UserMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author zeng
 * @Date 2020/10/8 13:29
 * @Description
 * @Version 1.0
 */
@Service
@RocketMQMessageListener(consumerGroup = "consumer", topic = "add-bonus")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDto> {
    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public void onMessage(UserAddBonusMsgDto userAddBonusMsgDto) {
        // 1. 加积分
        Integer userId = userAddBonusMsgDto.getUserId();
        User user = userMapper.selectByPrimaryKey(userId);
        // 所加积分数
        Integer bonus = userAddBonusMsgDto.getBonus();
        user.setBonus(user.getBonus() + bonus);
        userMapper.updateByPrimaryKeySelective(user);
        // 2.写积分日志
        bonusEventLogMapper.insert(BonusEventLog.builder()
                .userId(userId)
                .value(bonus)
                .event("CONTRIBUTE")
                .createTime(new Date())
                .description("投稿加积分")
                .build()
        );
    }
}
