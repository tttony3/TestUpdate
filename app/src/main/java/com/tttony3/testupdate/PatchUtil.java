package com.tttony3.testupdate;


/**
 * Created by tangli on 2016/7/6.
 * Website: https://github.com/tttony3
 */
public class PatchUtil {
    static {
        System.loadLibrary("patchtl");
    }

    public static native int patch(String oldApkPath, String newApkPath,
                                   String patchPath);
}
