package cn.fenqing168.gmall.modules.sku.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fenqing
 */
@Data
public class PmsSkuAttrValue implements Serializable {
    private Long id;
    private Long attrId;
    private Long valueId;
    private Long skuId;
}
