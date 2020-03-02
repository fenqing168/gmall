package cn.fenqing168.gmall.modules.product.controller;

import cn.fenqing168.gmall.modules.product.po.PmsProductImage;
import cn.fenqing168.gmall.modules.product.serrvice.IPmsProductImageService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsProductImageController {

    @Reference
    private IPmsProductImageService iPmsProductImageService;

    @GetMapping("/spuImageList")
    public List<PmsProductImage> spuImageList(@RequestParam Long spuId){
        List<PmsProductImage> pmsProductImages = iPmsProductImageService.spuImageList(spuId);
        return pmsProductImages;
    }

}
