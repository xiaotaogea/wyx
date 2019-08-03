package com.zjwm.wyx.utils;

public class FileNameUtils {

    /**
     *
     * @param fileName 文件名
     * @return 获取文件后缀
     */
    private static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return 新的文件名
     */
    public static String getFileName(String fileOriginName){
        return UUIDS.getDateTime() + FileNameUtils.getSuffix(fileOriginName);
    }

}
