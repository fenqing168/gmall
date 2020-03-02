package cn.fenqing168.gmall.modules.product.serrvice;

import cn.fenqing168.gmall.modules.product.dto.PmsProductInfoDto;
import cn.fenqing168.gmall.modules.product.po.PmsProductInfo;

import java.util.List;

/**
 * @author fenqing
 */
public interface IPmsProductInfoService {
    /**
     * 查询
     * @param catalog3Id
     * @return
     */
    List<PmsProductInfo> spuList(Long catalog3Id);

    /**
     * 保存
     * @param pmsProductInfoDto
     */
    void saveSpuInfo(PmsProductInfoDto pmsProductInfoDto);
}
