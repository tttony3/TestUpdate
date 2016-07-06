# TestUpdate
Android差分包更新
使用JNI编译bspatch实现
使用时只需要so文件即可
##libpatchtl.so 使用方法
    static {
        System.loadLibrary("patchtl"); //加载so库
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
##生成差分包的方法
电脑下载bsdiff 运行
bsdiff old.apk new.apk patch.patch
