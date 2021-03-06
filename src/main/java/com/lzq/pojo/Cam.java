package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Cam {
    @NonNull
    private Integer cameraId;

    @NonNull
    private String videoImage;
    private String cameraDescription;
    @NonNull
    private Integer proId;
    @NonNull
    private Double camLng;
    @NonNull
    private Double camLat;
    @NonNull
    private String camName;

    @NonNull
    private Timestamp videoTime;

    @NonNull
    private Integer bingingFileId;
    @NonNull
    private String videoUrl;

    private Integer isSelectImg;


    @NonNull
    //0 unprocess 1 finish 2 pause
    private Integer status;

    private String selectImageUrl;

    private int processNum;

    //is show process bar
    @NonNull
    private Integer isProcess;


}
