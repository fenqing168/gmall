package cn.fenqing168.gmall.modules.attr.mapper;

import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author fenqing
 */
@org.apache.ibatis.annotations.Mapper
public interface PmsBaseAttrValueMapper extends Mapper<PmsBaseAttrValue> {

    /**
     * 批量添加
     * @param attrValueList
     */
    void inserts(@Param("attrValueList") List<PmsBaseAttrValue> attrValueList);
}
