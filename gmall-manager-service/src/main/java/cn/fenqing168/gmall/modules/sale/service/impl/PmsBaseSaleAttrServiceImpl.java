package cn.fenqing168.gmall.modules.sale.service.impl;

import cn.fenqing168.gmall.modules.sale.mapper.PmsBaseSaleAttrMapper;
import cn.fenqing168.gmall.modules.sale.po.PmsBaseSaleAttr;
import cn.fenqing168.gmall.modules.sale.service.IPmsBaseSaleAttrService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class PmsBaseSaleAttrServiceImpl implements IPmsBaseSaleAttrService {

    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
