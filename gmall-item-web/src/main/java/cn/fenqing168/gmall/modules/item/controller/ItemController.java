package cn.fenqing168.gmall.modules.item.controller;

import cn.fenqing168.gmall.modules.sku.po.PmsSkuInfo;
import cn.fenqing168.gmall.modules.sku.service.IPmsSkuImageService;
import cn.fenqing168.gmall.modules.sku.service.IPmsSkuInfoService;
import cn.fenqing168.gmall.modules.sku.vo.PmsSkuInfoVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author fenqing
 */
@Controller
public class ItemController {

    @Reference
    private IPmsSkuInfoService iPmsSkuInfoService;

    @GetMapping("/{skuId}.html")
    public String item(@PathVariable("skuId") Long skuId, ModelMap modelMap){

        PmsSkuInfoVo.Images images = iPmsSkuInfoService.getBySkuId(skuId);

        modelMap.put("skuInfo", images);

        return "item";
    }

}
