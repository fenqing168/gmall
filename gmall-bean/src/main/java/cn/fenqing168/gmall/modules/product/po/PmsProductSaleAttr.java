package cn.fenqing168.gmall.modules.product.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fenqing
 */
@Data
public class PmsProductSaleAttr implements Serializable {
    private Long id;
    private Long productId;
    private Long saleAttrId;
    private String saleAttrName;
}
