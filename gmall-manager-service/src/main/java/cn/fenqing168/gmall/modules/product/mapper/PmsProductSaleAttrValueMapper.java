package cn.fenqing168.gmall.modules.product.mapper;

import cn.fenqing168.gmall.modules.product.dto.PmsProductSaleAttrDto;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author fenqing
 */
@org.apache.ibatis.annotations.Mapper
public interface PmsProductSaleAttrValueMapper extends Mapper<PmsProductSaleAttrValue> {

    /**
     * 添加
     * @param pmsProductSaleAttrValues
     */
    void inserts(@Param("pmsProductSaleAttrValues") List<PmsProductSaleAttrValue> pmsProductSaleAttrValues);

    /**
     * 查询
     * @param productIdAndSaleAttrIds
     * @return
     */
    List<PmsProductSaleAttrValue> selectByProductIdAndSaleAttrId(@Param("productIdAndSaleAttrIds") List<PmsProductSaleAttrDto.ProductIdAndSaleAttrId> productIdAndSaleAttrIds);
}
