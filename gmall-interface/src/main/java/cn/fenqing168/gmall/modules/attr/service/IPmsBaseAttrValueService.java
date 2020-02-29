package cn.fenqing168.gmall.modules.attr.service;

import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrValue;

import java.util.List;

/**
 * @author fenqing
 */
public interface IPmsBaseAttrValueService {
    /**
     * 查询
     * @param attrId
     * @return
     */
    List<PmsBaseAttrValue> getAttrValueList(Long attrId);
}
