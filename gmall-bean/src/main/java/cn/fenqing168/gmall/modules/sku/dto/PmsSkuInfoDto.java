package cn.fenqing168.gmall.modules.sku.dto;

import cn.fenqing168.gmall.modules.sku.po.PmsSkuAttrValue;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuImage;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuInfo;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuSaleAttrValue;
import lombok.Data;

import java.util.List;

/**
 * @author fenqing
 */
public interface PmsSkuInfoDto {

    @Data
    class Save extends PmsSkuInfo {

        private List<PmsSkuAttrValue> skuAttrValueList;

        private List<PmsSkuSaleAttrValue> skuSaleAttrValueList;

        private List<PmsSkuImage> skuImageList;

    }

}
