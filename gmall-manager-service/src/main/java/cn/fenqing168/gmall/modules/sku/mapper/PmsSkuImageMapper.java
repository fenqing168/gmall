package cn.fenqing168.gmall.modules.sku.mapper;

import cn.fenqing168.gmall.modules.sku.po.PmsSkuImage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author fenqing
 */
@org.apache.ibatis.annotations.Mapper
public interface PmsSkuImageMapper extends Mapper<PmsSkuImage> {

    /**
     * 添加
     * @param skuImageList
     */
    void inserts(@Param("skuImageList") List<PmsSkuImage> skuImageList);
}
