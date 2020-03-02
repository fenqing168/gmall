package cn.fenqing168.gmall.modules.sku.vo;

import cn.fenqing168.gmall.modules.sku.po.PmsSkuImage;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author fenqing
 */
public interface PmsSkuInfoVo {

    @Data
    class Images extends PmsSkuInfo implements Serializable {

        private List<PmsSkuImage> skuImageList;

    }

}
