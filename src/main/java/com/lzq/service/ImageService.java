package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.pojo.Image;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ImageService {
    ResultInfo.Result createImage(Image image);

    ResultInfo.Result deleteImage(Integer imageId);

    List<Image> getImagesByCameraId(Integer cameraId);

    ResultInfo.Result updateImage(Image image);

    List<Image> getImagesByProId(Integer proId);
}
