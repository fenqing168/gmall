package cn.fenqing168.gmall.controller;

import cn.fenqing168.gmall.utils.QiNiuUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author fenqing
 */
@RestController
public class FileController {

    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        return QiNiuUtils.uploadFile(file.getInputStream(), substring);
    }

}
