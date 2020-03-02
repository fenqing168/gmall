package cn.fenqing168.gmall.modules.sale.controller;

import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import cn.fenqing168.gmall.modules.sale.po.PmsBaseSaleAttr;
import cn.fenqing168.gmall.modules.sale.service.IPmsBaseSaleAttrService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsBaseSaleAttrController {

    @Reference
    private IPmsBaseSaleAttrService iPmsBaseSaleAttrService;

    @PostMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = iPmsBaseSaleAttrService.baseSaleAttrList();
        return pmsBaseSaleAttrs;
    }

}
