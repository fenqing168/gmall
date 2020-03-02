package cn.fenqing168.gmall.modules.product.mapper;

import cn.fenqing168.gmall.modules.product.po.PmsProductImage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author fenqing
 */
@org.apache.ibatis.annotations.Mapper
public interface PmsProductImageMapper extends Mapper<PmsProductImage> {

    /**
     * 添加
     * @param pmsProductImages
     */
    void inserts(@Param("pmsProductImages") List<PmsProductImage> pmsProductImages);
}
