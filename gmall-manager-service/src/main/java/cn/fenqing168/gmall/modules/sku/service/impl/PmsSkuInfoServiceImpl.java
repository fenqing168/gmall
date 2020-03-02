package cn.fenqing168.gmall.modules.sku.service.impl;

import cn.fenqing168.gmall.modules.product.mapper.PmsProductImageMapper;
import cn.fenqing168.gmall.modules.product.mapper.PmsProductSaleAttrValueMapper;
import cn.fenqing168.gmall.modules.sku.dto.PmsSkuInfoDto;
import cn.fenqing168.gmall.modules.sku.mapper.PmsSkuAttrValueMapper;
import cn.fenqing168.gmall.modules.sku.mapper.PmsSkuImageMapper;
import cn.fenqing168.gmall.modules.sku.mapper.PmsSkuInfoMapper;
import cn.fenqing168.gmall.modules.sku.mapper.PmsSkuSaleAttrValueMapper;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuAttrValue;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuImage;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuInfo;
import cn.fenqing168.gmall.modules.sku.po.PmsSkuSaleAttrValue;
import cn.fenqing168.gmall.modules.sku.service.IPmsSkuInfoService;
import cn.fenqing168.gmall.modules.sku.vo.PmsSkuInfoVo;
import cn.fenqing168.gmall.utils.FenqingDataUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.List;

/**
 * @author fenqing
 */
@Service
public class PmsSkuInfoServiceImpl implements IPmsSkuInfoService {

    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Autowired
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Override
    public PmsSkuInfoVo.Images getBySkuId(Long skuId) {
        Example example = new Example(PmsSkuInfo.class);
        example.createCriteria().andEqualTo("id", skuId);
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectOneByExample(example);
        PmsSkuInfoVo.Images images = FenqingDataUtil.parentToChild(pmsSkuInfo, PmsSkuInfoVo.Images.class);
        Example skuIdEquals = new Example(PmsSkuImage.class);
        skuIdEquals.createCriteria().andEqualTo("skuId", skuId);
        images.setSkuImageList(pmsSkuImageMapper.selectByExample(skuIdEquals));
        return images;
    }

    @Override
    public void saveSkuInfo(PmsSkuInfoDto.Save pmsSkuInfo) {

        if(StringUtils.isBlank(pmsSkuInfo.getSkuDefaultImg()) && !pmsSkuInfo.getSkuImageList().isEmpty()){
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }

        pmsSkuInfoMapper.insertSelective(pmsSkuInfo);

        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        skuAttrValueList.forEach(item -> item.setSkuId(pmsSkuInfo.getId()));

        if(!skuAttrValueList.isEmpty()){
            pmsSkuAttrValueMapper.inserts(skuAttrValueList);
        }

        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        skuSaleAttrValueList.forEach(item -> item.setSkuId(pmsSkuInfo.getId()));

        if(!skuSaleAttrValueList.isEmpty()){
            pmsSkuSaleAttrValueMapper.inserts(skuSaleAttrValueList);
        }

        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        skuImageList.forEach(item -> item.setSkuId(pmsSkuInfo.getId()));
        if(!skuImageList.isEmpty()){
            pmsSkuImageMapper.inserts(skuImageList);
        }

    }
}
