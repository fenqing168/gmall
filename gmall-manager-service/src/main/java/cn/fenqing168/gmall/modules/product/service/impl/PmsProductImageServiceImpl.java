package cn.fenqing168.gmall.modules.product.service.impl;

import cn.fenqing168.gmall.modules.product.mapper.PmsProductImageMapper;
import cn.fenqing168.gmall.modules.product.po.PmsProductImage;
import cn.fenqing168.gmall.modules.product.serrvice.IPmsProductImageService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author fenqing
 */
@Service
public class PmsProductImageServiceImpl implements IPmsProductImageService {

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    @Override
    public List<PmsProductImage> spuImageList(Long spuId) {
        Example example = new Example(PmsProductImage.class);
        example.createCriteria().andEqualTo("productId", spuId);
        return pmsProductImageMapper.selectByExample(example);
    }
}
