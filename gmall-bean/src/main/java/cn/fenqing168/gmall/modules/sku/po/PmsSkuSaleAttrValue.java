package cn.fenqing168.gmall.modules.sku.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fenqing
 */
@Data
public class PmsSkuSaleAttrValue implements Serializable {
    private Long id;
    private Long skuId;
    private Long saleAttrId;
    private Long saleAttrValueId;
    private String saleAttrName;
    private String saleAttrValueName;
}
