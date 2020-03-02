package cn.fenqing168.gmall.modules.product.controller;

import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import cn.fenqing168.gmall.modules.product.serrvice.IPmsProductSaleAttrService;
import cn.fenqing168.gmall.modules.product.vo.PmsProductSaleAttrVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsProductSaleAttrController {

    @Reference
    private IPmsProductSaleAttrService iPmsProductSaleAttrService;

    @GetMapping("/spuSaleAttrList")
    public List<PmsProductSaleAttrVo.Values> spuSaleAttrList(@RequestParam Integer spuId){
        return iPmsProductSaleAttrService.spuSaleAttrList(spuId);
    }

}
