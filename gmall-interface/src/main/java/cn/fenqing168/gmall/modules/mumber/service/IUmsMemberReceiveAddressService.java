package cn.fenqing168.gmall.modules.mumber.service;

import cn.fenqing168.gmall.modules.mumber.po.UmsMemberReceiveAddress;

import java.util.List;


/**
 * @author fenqing
 */
public interface IUmsMemberReceiveAddressService {
    /**
     * 查询
     * @param memberId
     * @return
     */
    List<UmsMemberReceiveAddress> getByMemberId(Integer memberId);
}
