package cn.fenqing168.gmall.modules.attr.vo;

import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrInfo;
import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author fenqing
 */
public interface PmsBaseAttrInfoVo {

    @Data
    class Values extends PmsBaseAttrInfo implements Serializable {
        private List<PmsBaseAttrValue> attrValueList;
    }

}
