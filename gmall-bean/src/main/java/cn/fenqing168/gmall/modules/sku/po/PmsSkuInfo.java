package cn.fenqing168.gmall.modules.sku.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author fenqing
 */
@Data
public class PmsSkuInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Double price;
    private String skuName;
    private String skuDesc;
    private Double weight;
    private Long tmId;
    private Long catalog3Id;
    private String skuDefaultImg;
}
