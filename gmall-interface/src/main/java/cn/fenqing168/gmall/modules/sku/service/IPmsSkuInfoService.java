package cn.fenqing168.gmall.modules.sku.service;

import cn.fenqing168.gmall.modules.sku.dto.PmsSkuInfoDto;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuInfo;
import cn.fenqing168.gmall.modules.sku.vo.PmsSkuInfoVo;

import java.util.List;

/**
 * @author fenqing
 */
public interface IPmsSkuInfoService {
    /**
     * 查询
     * @param skuId
     * @return
     */
    PmsSkuInfoVo.Images getBySkuId(Long skuId);

    /**
     * 保存
     * @param pmsSkuInfo
     */
    void saveSkuInfo(PmsSkuInfoDto.Save pmsSkuInfo);
}
