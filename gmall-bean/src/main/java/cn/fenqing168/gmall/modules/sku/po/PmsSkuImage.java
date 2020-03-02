package cn.fenqing168.gmall.modules.sku.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fenqing
 */
@Data
public class PmsSkuImage implements Serializable {
    private Long id;
    private Long skuId;
    private String imgName;
    private String imgUrl;
    private Long productImgId;
    private String isDefault;
}
