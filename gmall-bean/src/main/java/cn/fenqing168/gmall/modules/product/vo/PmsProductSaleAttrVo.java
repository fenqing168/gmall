package cn.fenqing168.gmall.modules.product.vo;

import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttrValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author fenqing
 */
public interface PmsProductSaleAttrVo {

    @Data
    class Values extends PmsProductSaleAttr implements Serializable {
        private List<PmsProductSaleAttrValue> spuSaleAttrValueList;
    }

}
