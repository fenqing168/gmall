package cn.fenqing168.gmall.modules.attr.dto;

import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrInfo;
import cn.fenqing168.gmall.modules.attr.po.PmsBaseAttrValue;
import lombok.Data;

import java.util.List;

/**
 * @author fenqing
 */
@Data
public class PmsBaseAttrInfoDto extends PmsBaseAttrInfo {

    private List<PmsBaseAttrValue> attrValueList;

}
