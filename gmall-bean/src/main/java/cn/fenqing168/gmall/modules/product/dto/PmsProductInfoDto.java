package cn.fenqing168.gmall.modules.product.dto;

import cn.fenqing168.gmall.modules.product.po.PmsProductImage;
import cn.fenqing168.gmall.modules.product.po.PmsProductInfo;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author fenqing
 */
@Data
public class PmsProductInfoDto extends PmsProductInfo implements Serializable {

    private List<PmsProductSaleAttrDto.Values> spuSaleAttrList;

    private List<PmsProductImage> spuImageList;

}
