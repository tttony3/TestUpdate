package com.tttony3.testupdate;


/**
 * Created by tangli on 2016/7/6.
 * Website: https://github.com/tttony3
 */
public class PatchUtil {
    static {
        System.loadLibrary("patchtl");
    }

    /**
     * 差分包与旧apk包一起生成新apk包
     *
     * @param oldApkPath 旧版本apk路径
     * @param newApkPath 新apk存放路径
     * @param newApkPath 差分包路径
     */
    public static native int patch(String oldApkPath, String newApkPath,
                                   String patchPath);
}
