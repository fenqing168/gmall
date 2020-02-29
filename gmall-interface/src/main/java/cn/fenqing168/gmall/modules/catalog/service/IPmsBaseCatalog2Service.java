package cn.fenqing168.gmall.modules.catalog.service;

import cn.fenqing168.gmall.modules.catalog.po.PmsBaseCatalog2;

import java.util.List;

/**
 * @author fenqing
 */
public interface IPmsBaseCatalog2Service {
    /**
     * 查询
     * @param catalog1Id
     * @return
     */
    List<PmsBaseCatalog2> getCatalog2(Long catalog1Id);
}
