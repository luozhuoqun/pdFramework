package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.lzq.pojo.Cam;
import com.lzq.pojo.File;
import com.lzq.service.CameraService;
import com.lzq.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.testng.collections.Lists;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    private CameraService cameraService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getImagesByUserId", method = RequestMethod.POST)
    @ResponseBody

    public List<File> getImagesByUserId(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data, Map.class);
        Integer userId = Integer.parseInt(keyMap.get("userId"));
        List<File> fileList = fileService.getImagesByUserId(userId);
//        List<String> imgUrlList = Lists.newArrayList();
        for(File file : fileList){
            String[] item = file.getFileUrl().split("files");
            file.setFileUrl("http://172.18.32.192:8082/file"+item[item.length-1]);
        }
        return fileList;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getVideosByUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<File> getVideosByUserId(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data, Map.class);
        Integer userId = Integer.parseInt(keyMap.get("userId"));
        Integer proId = Integer.parseInt(keyMap.get("proId"));
        List<Cam> cams = cameraService.getCamerasByProId(proId);
        List<File> files =  fileService.getVideosByUserId(userId);
        List temp = Lists.newArrayList();
        files.forEach(x->{
            cams.forEach(it->{
                if(it.getBingingFileId().equals(x.getFileId())){
                    temp.add(x);
                }
            });
        });
        files.removeAll(temp);
        return files;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getFileByFileId", method = RequestMethod.POST)
    @ResponseBody
    public File getFileByFileId(@RequestBody String data) {
        Map<String,Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer fileId = keyMap.get("fileId");
        return fileService.getFileByFileId(fileId);
    }
}
