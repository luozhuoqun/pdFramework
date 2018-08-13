package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.lzq.pojo.File;
import com.lzq.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getProjectsByUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<File> getImagesByUserId(@RequestBody String data) {
        Map<String,Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer userId = keyMap.get("userId");
        return fileService.getImagesByUserId(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getVideosByUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<File> getVideosByUserId(@RequestBody String data) {
        Map<String,Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer userId = keyMap.get("userId");
        return fileService.getVideosByUserId(userId);
    }
}
