package cn.fenqing168.gmall.modules.product.dto;

import cn.fenqing168.gmall.modules.product.po.PmsProductInfo;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttrValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author fenqing
 */
public interface PmsProductSaleAttrDto {

    @Data
    class Values extends PmsProductSaleAttr implements Serializable {

        private List<PmsProductSaleAttrValue> spuSaleAttrValueList;

    }

    @Data
    class ProductIdAndSaleAttrId{
        private Long productId;
        private Long saleAttrId;
    }

}
