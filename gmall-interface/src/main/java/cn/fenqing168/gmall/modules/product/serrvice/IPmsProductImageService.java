package cn.fenqing168.gmall.modules.product.serrvice;

import cn.fenqing168.gmall.modules.product.po.PmsProductImage;

import java.util.List;

/**
 * @author fenqing
 */
public interface IPmsProductImageService {
    /**
     * 查询
     * @param spuId
     * @return
     */
    List<PmsProductImage> spuImageList(Long spuId);
}
