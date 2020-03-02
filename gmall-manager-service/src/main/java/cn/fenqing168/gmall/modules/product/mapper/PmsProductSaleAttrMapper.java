package cn.fenqing168.gmall.modules.product.mapper;

import cn.fenqing168.gmall.modules.product.dto.PmsProductSaleAttrDto;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author fenqing
 */
@org.apache.ibatis.annotations.Mapper
public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {

    /**
     * 添加
     * @param pmsProductSaleAttrs
     */
    void inserts(@Param("pmsProductSaleAttrs") List<? extends PmsProductSaleAttr> pmsProductSaleAttrs);
}
