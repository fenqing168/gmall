package cn.fenqing168.gmall.modules.mumber.service;


import cn.fenqing168.gmall.modules.mumber.po.UmsMember;

import java.util.List;

/**
 * @author fenqing
 */
public interface IUmsMemberService {

    /**
     * 查询全部
     * @return
     */
    List<UmsMember> getAllUser();
}
