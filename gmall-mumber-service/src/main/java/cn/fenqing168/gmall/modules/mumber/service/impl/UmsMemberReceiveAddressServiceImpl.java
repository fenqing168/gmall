package cn.fenqing168.gmall.modules.mumber.service.impl;

import cn.fenqing168.gmall.modules.mumber.po.UmsMemberReceiveAddress;
import cn.fenqing168.gmall.modules.mumber.service.IUmsMemberReceiveAddressService;
import cn.fenqing168.gmall.modules.mumber.mapper.UmsMemberReceiveAddressMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements IUmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMemberReceiveAddress> getByMemberId(Integer memberId) {
        Example example = new Example(UmsMemberReceiveAddress.class);
        example.createCriteria().andEqualTo("memberId", memberId);
        return umsMemberReceiveAddressMapper.selectByExample(example);
    }
}
