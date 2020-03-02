package cn.fenqing168.gmall.modules.product.serrvice;

import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import cn.fenqing168.gmall.modules.product.vo.PmsProductSaleAttrVo;

import java.util.List;

/**
 * @author fenqing
 */
public interface IPmsProductSaleAttrService {

    /**
     * 查询
     * @param spuId
     * @return
     */
    List<PmsProductSaleAttrVo.Values> spuSaleAttrList(Integer spuId);
}
