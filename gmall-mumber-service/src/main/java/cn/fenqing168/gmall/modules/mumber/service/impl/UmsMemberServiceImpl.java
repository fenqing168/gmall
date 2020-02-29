package cn.fenqing168.gmall.modules.mumber.service.impl;

import cn.fenqing168.gmall.modules.mumber.mapper.UmsMemberMapper;
import cn.fenqing168.gmall.modules.mumber.service.IUmsMemberService;
import cn.fenqing168.gmall.modules.mumber.po.UmsMember;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class UmsMemberServiceImpl implements IUmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Override
    public List<UmsMember> getAllUser() {
        return umsMemberMapper.selectAll();
    }
}
