package cn.fenqing168.gmall.modules.product.service.impl;

import cn.fenqing168.gmall.modules.product.dto.PmsProductSaleAttrDto;
import cn.fenqing168.gmall.modules.product.mapper.PmsProductSaleAttrMapper;
import cn.fenqing168.gmall.modules.product.mapper.PmsProductSaleAttrValueMapper;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttr;
import cn.fenqing168.gmall.modules.product.po.PmsProductSaleAttrValue;
import cn.fenqing168.gmall.modules.product.serrvice.IPmsProductSaleAttrService;
import cn.fenqing168.gmall.modules.product.vo.PmsProductSaleAttrVo;
import cn.fenqing168.gmall.utils.FenqingDataUtil;
import org.apache.dubbo.config.annotation.Service;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fenqing
 */
@Service
public class PmsProductSaleAttrServiceImpl implements IPmsProductSaleAttrService {

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductSaleAttrVo.Values> spuSaleAttrList(Integer spuId) {
        Example example = new Example(PmsProductSaleAttr.class);
        example.createCriteria().andEqualTo("productId", spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.selectByExample(example);

        List<PmsProductSaleAttrDto.ProductIdAndSaleAttrId> productIdAndSaleAttrIds = new ArrayList<>();
        pmsProductSaleAttrs.forEach(pmsProductSaleAttr -> {
            PmsProductSaleAttrDto.ProductIdAndSaleAttrId productIdAndSaleAttrId =
                    new PmsProductSaleAttrDto.ProductIdAndSaleAttrId();
            BeanUtils.copyProperties(pmsProductSaleAttr, productIdAndSaleAttrId);
            productIdAndSaleAttrIds.add(productIdAndSaleAttrId);
        });

        List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper
                .selectByProductIdAndSaleAttrId(productIdAndSaleAttrIds);
        Map<Long, Map<Long, List<PmsProductSaleAttrValue>>> psvMaps = new HashMap<>(8);
        pmsProductSaleAttrValues.forEach(pmsProductSaleAttrValue -> {
            Map<Long, List<PmsProductSaleAttrValue>> svMaps =
                    psvMaps.get(pmsProductSaleAttrValue.getProductId());
            if(svMaps == null){
                svMaps = new HashMap<>(8);
            }

            List<PmsProductSaleAttrValue> temp =
                    svMaps.get(pmsProductSaleAttrValue.getSaleAttrId());

            if(temp == null){
                temp = new ArrayList<>();
            }
            temp.add(pmsProductSaleAttrValue);
            svMaps.put(pmsProductSaleAttrValue.getSaleAttrId(), temp);
            psvMaps.put(pmsProductSaleAttrValue.getProductId(), svMaps);
        });
        List<PmsProductSaleAttrVo.Values> values = FenqingDataUtil
                .parentsToChilds(pmsProductSaleAttrs, PmsProductSaleAttrVo.Values.class);
        values.forEach(value -> value
                .setSpuSaleAttrValueList(
                        Optional.ofNullable(psvMaps.get(value.getProductId()))
                                .map(item -> item.get(value.getSaleAttrId()))
                                .orElse(new ArrayList<>())
                )
        );

        return values;
    }
}
