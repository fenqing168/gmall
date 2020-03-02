package cn.fenqing168.gmall.modules.sku.service.impl;

import cn.fenqing168.gmall.modules.sku.mapper.PmsSkuImageMapper;
import cn.fenqing168.gmall.modules.sku.service.IPmsSkuImageService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fenqing
 */
@Service
public class PmsSkuImageServiceImpl implements IPmsSkuImageService {

    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;

}
