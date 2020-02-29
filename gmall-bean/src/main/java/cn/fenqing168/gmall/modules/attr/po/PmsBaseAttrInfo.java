package cn.fenqing168.gmall.modules.attr.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author fenqing
 */
@Data
public class PmsBaseAttrInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attrName;
    private Long catalog3Id;
    private String isEnabled;
}
