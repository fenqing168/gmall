package cn.fenqing168.gmall.modules.product.service.impl;

import cn.fenqing168.gmall.modules.product.dto.PmsProductInfoDto;
import cn.fenqing168.gmall.modules.product.dto.PmsProductSaleAttrDto;
import cn.fenqing168.gmall.modules.product.mapper.PmsProductImageMapper;
import cn.fenqing168.gmall.modules.product.mapper.PmsProductInfoMapper;
import cn.fenqing168.gmall.modules.product.mapper.PmsProductSaleAttrMapper;
import cn.fenqing168.gmall.modules.product.mapper.PmsProductSaleAttrValueMapper;
import cn.fenqing168.gmall.modules.product.po.PmsProductImage;
import cn.fenqing168.gmall.modules.product.po.PmsProductInfo;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttrValue;
import cn.fenqing168.gmall.modules.product.serrvice.IPmsProductInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fenqing
 */
@Service
public class PmsProductInfoServiceImpl implements IPmsProductInfoService {

    @Autowired
    private PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(Long catalog3Id) {
        Example example = new Example(PmsProductInfo.class);
        example.createCriteria().andEqualTo("catalog3Id", catalog3Id);
        return pmsProductInfoMapper.selectByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSpuInfo(PmsProductInfoDto pmsProductInfoDto) {
        pmsProductInfoMapper.insert(pmsProductInfoDto);

        List<PmsProductImage> spuImageList = pmsProductInfoDto.getSpuImageList();
        spuImageList.forEach(spuImage -> {
            spuImage.setProductId(pmsProductInfoDto.getId());
        });

        if(!spuImageList.isEmpty()){
            pmsProductImageMapper.inserts(spuImageList);
        }

        List<PmsProductSaleAttrDto.Values> spuSaleAttrList = pmsProductInfoDto.getSpuSaleAttrList();
        spuSaleAttrList.forEach(spuSaleAttr -> {
            spuSaleAttr.setProductId(pmsProductInfoDto.getId());
        });

        if(!spuSaleAttrList.isEmpty()){
            pmsProductSaleAttrMapper.inserts(spuSaleAttrList);
        }

        List<PmsProductSaleAttrValue> values = spuSaleAttrList
                .stream()
                .flatMap(item -> item.getSpuSaleAttrValueList().stream())
                .collect(Collectors.toList());
        values.forEach(value -> {
            value.setProductId(pmsProductInfoDto.getId());
        });
        if(!values.isEmpty()){
            pmsProductSaleAttrValueMapper.inserts(values);
        }

    }
}
