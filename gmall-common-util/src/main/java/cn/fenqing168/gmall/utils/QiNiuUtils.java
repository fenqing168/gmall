package cn.fenqing168.gmall.utils;

import cn.fenqing168.gmall.utils.commons.constant.QiNiuConst;
import com.alibaba.fastjson.JSON;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author fenqing
 */
public class QiNiuUtils {

    private static final Configuration CFG = new Configuration(Region.region2());
    private static final UploadManager UPLOAD_MANAGER = new UploadManager(CFG);
    public static final Auth AUTH_INFO = Auth.create(QiNiuConst.ACCESS_KEY, QiNiuConst.SECRET_KEY);
    public static final DateFormat DF = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 上传文件
     * @param is
     * @return
     */
    public static String uploadFile(InputStream is, String suffix){
        String key = String.format("%s/%s/%s", "file", DF.format(new Date()), UUIDUtils.uuid() + "." + suffix);
        String upToken = AUTH_INFO.uploadToken(QiNiuConst.Bucket.FENQING.getName());
        try {
            Response response = UPLOAD_MANAGER.put(is, key, upToken, null, null);
            DefaultPutRet defaultPutRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
            return QiNiuConst.Bucket.FENQING.getDomain() + key;
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }

}
