package com.tttony3.testupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static final String PATH = Environment.getExternalStorageDirectory() + File.separator;

    //合成得到的新版apk
    public static final String NEW_APK_PATH = PATH + "new.apk";

    //从服务器下载来的差分包
    public static final String PATCH_PATH = PATH + "new.patch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "newnewnew", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_patch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PatchUtil.patch(getSourceApkPath(getApplicationContext(),"com.tttony3.testupdate"),NEW_APK_PATH,PATCH_PATH); //差分包与旧apk包一起生成新apk包
                installApk(getApplicationContext(),NEW_APK_PATH);//安装
            }
        });
    }

    /**
     * 查找旧版本Apk包
     *
     * @param context
     * @param packageName
     */
    public static String getSourceApkPath(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName))
            return null;

        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(packageName, 0);
            return appInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 安装Apk
     *
     * @param context
     * @param apkPath
     */
    public static void installApk(Context context, String apkPath) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + apkPath),
                "application/vnd.android.package-archive");

        context.startActivity(intent);
    }
}
