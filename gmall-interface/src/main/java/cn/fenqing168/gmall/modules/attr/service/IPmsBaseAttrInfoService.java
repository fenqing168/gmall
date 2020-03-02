package cn.fenqing168.gmall.modules.attr.service;

import cn.fenqing168.gmall.modules.attr.dto.PmsBaseAttrInfoDto;
import cn.fenqing168.gmall.modules.attr.vo.PmsBaseAttrInfoVo;

import java.util.List;

/**
 * @author fenqing
 */
public interface IPmsBaseAttrInfoService {
    /**
     * 查询
     * @param catalog3Id
     * @return
     */
    List<PmsBaseAttrInfoVo.Values> attrInfoList(Long catalog3Id);

    /**
     * 保存
     * @param pmsBaseAttrInfoDto
     */
    void saveAttrInfo(PmsBaseAttrInfoDto pmsBaseAttrInfoDto);
}
