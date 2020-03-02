package cn.fenqing168.gmall.modules.sku.mapper;

import cn.fenqing168.gmall.modules.sku.po.PmsSkuSaleAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author fenqing
 */
@org.apache.ibatis.annotations.Mapper
public interface PmsSkuSaleAttrValueMapper extends Mapper<PmsSkuSaleAttrValue> {

    /**
     * 添加
     * @param skuSaleAttrValueList
     */
    void inserts(@Param("skuSaleAttrValueList") List<PmsSkuSaleAttrValue> skuSaleAttrValueList);
}
