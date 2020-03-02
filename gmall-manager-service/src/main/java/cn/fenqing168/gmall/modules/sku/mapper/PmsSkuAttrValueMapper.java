package cn.fenqing168.gmall.modules.sku.mapper;

import cn.fenqing168.gmall.modules.sku.po.PmsSkuAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author fenqing
 */
@org.apache.ibatis.annotations.Mapper
public interface PmsSkuAttrValueMapper extends Mapper<PmsSkuAttrValue> {
    /**
     * 添加
     * @param skuAttrValueList
     */
    void inserts(@Param("skuAttrValueList") List<PmsSkuAttrValue> skuAttrValueList);
}
