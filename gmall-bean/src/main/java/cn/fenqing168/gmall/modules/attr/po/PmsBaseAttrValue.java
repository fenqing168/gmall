package cn.fenqing168.gmall.modules.attr.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fenqing
 */
@Data
public class PmsBaseAttrValue implements Serializable {

  private Long id;
  private String valueName;
  private Long attrId;
  private String isEnabled;
}
