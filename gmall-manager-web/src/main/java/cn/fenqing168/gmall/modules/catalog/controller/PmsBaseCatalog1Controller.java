package cn.fenqing168.gmall.modules.catalog.controller;

import cn.fenqing168.gmall.modules.catalog.po.PmsBaseCatalog1;
import cn.fenqing168.gmall.modules.catalog.service.IPmsBaseCatalog1Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenqing
 */
@RestController
public class PmsBaseCatalog1Controller {

    @Reference
    private IPmsBaseCatalog1Service iPmsBaseCatalog1Service;

    @PostMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> pmsBaseCatalog1s = iPmsBaseCatalog1Service.getCatalog1();
        return pmsBaseCatalog1s;
    }

}
