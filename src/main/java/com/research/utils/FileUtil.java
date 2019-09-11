package com.research.utils;

import com.research.constant.WebConstant;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static String save(MultipartFile mfile,String path)throws IOException {
//        String path = WebConstant.FILE_LOCATIONS+File.separator+dir;
        String fileUrl = path+File.separator+mfile.getOriginalFilename();
        System.out.println("fileUrl:"+fileUrl);
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        File file = new File(fileUrl);
        mfile.transferTo(file);
        return fileUrl;
    }


}
