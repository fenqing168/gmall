package cn.fenqing168.gmall.modules.product.controller;

import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import cn.fenqing168.gmall.modules.product.serrvice.IPmsProductSaleAttrService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsProductSaleController {

    @Reference
    private IPmsProductSaleAttrService iPmsProductSaleAttrService;



}
