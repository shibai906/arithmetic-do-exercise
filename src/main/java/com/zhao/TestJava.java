package com.zhao;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//String shellCmd = String.format("java -jar /Users/zhaohuan/Desktop/app/apkdist-cli-all.jar c -f /Users/zhaohuan/Desktop/app/signed_PLATFORM_MiFinance_v7.5.3.2871(133)_release.apk -pcl android_xiaomi_rom,xiaomi,360,91mobile,aliyun,anzhi,appchina,eoe,gfan,gionee,google,hiapk,le,lenovo,meizu,mm,mumayi,nduo,ningmeng,oppo,pc,pconline,sogouzhushou,samsung,smartisan,taobao,vivo,wandoujia,wo,wps_qr,yyb,zhuoyi,huawei");
//
public class TestJava {


    final String JAR_NAME_PACK = "apkdist-cli-all.jar";

    final String JR = "android_xiaomi_rom,xiaomi,360,91mobile,aliyun,anzhi,appchina,eoe,gfan,gionee,google,hiapk,le,lenovo,meizu,mm,mumayi,nduo,ningmeng,oppo,pc,pconline,sogouzhushou,samsung,smartisan,taobao,vivo,wandoujia,wo,wps_qr,yyb,zhuoyi,huawei";
    final String LOAN = "vivo,wandoujia,360,91mobile,yyb,anzhi,appchina,gfan,nduo,mumayi,eoe,hiapk,taobao,sogouzhushou,mm,huawei,lenovo,gionee,oppo,meizu,le,samsung,smartisan,pc,wps_qr,pconline,wo,website,zhuoyi,ningmeng,aliyun";
    final List<Integer> JR_APP_TYPE = Arrays.asList(1,2,3);
    final List<Integer> LOAN_APP_TYPE = Arrays.asList(4,5);

    final String jarPackAddress = "/Users/zhaohuan/Desktop/app/";
    final String packAddress = "/Users/zhaohuan/Desktop/app/";

    final String FILE_SUFFIX = ".apk";

    final String JR_FILE_NAME_PREFIX = "signed_PLATFORM_MiFinance";

    final String LOAN_GCD_NAME_PREFIX = "signed_gcdMifi";  // 对应 HotUpdateAppTypeEnum.MI_FINANCIAL_LOANX.getAppType()

    final String LOAN_LOAN_NAME_PREFIX = "signed_loanMiui"; // 对应 HotUpdateAppTypeEnum.MI_FINANCIAL_LOAN.getAppType()

    final String FILE_NAME_SUBFIX = "release.apk";
    private static final Logger logger = Logger.getLogger(TestJava.class);

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InterruptedException {


        logger.info("nih");
        logger.error("你好");
        TestJava testJava = new TestJava();
        File file = new File(testJava.packAddress);
        File[] files = file.listFiles();
        Thread thread = new Thread(new ThreadGroup("haha"),() ->{
            Thread threadd = new Thread(() ->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("你好哇");
            });
            Thread threaddd = new Thread(() ->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("你好哇");
            });
            threaddd.start();
            System.out.println(threadd.getThreadGroup().getName());
            System.out.println(threaddd.getThreadGroup().getName());
            System.out.println(threadd.getThreadGroup() == threaddd.getThreadGroup());
        });
        thread.start();
        Thread threadd = new Thread(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("你好哇");
        });
        threadd.start();
        System.out.println(thread.getThreadGroup() == threadd.getThreadGroup());
        ThreadGroup group = thread.getThreadGroup();
        System.out.println(group);
        Thread.yield();
        Thread thread1 = new Thread();
        File mainFile = new File("/Users/zhaohuan/Desktop/app/signed_PLATFORM_MiFinance_v7.5.3.2871(133)_release.apk");
        testJava.createAllAppTag(testJava.getMd5(mainFile),mainFile.getAbsolutePath(),"all",1);
        Object obje = new Object();
        obje.wait();
    }





    private int createAllAppTag( String mainFileMd5 , String mainBagFullPath , String channel , int appType) throws IOException, InterruptedException {
        if( mainBagFullPath == null || mainFileMd5 == null || channel == null) {
            throw new NullPointerException(String.format("[app file upload file address]  mainFileMd5 is null or mainBagFullPath is null or channel is null! " +
                    "--------  mainFileMd5 = %s , mainBagFullPath = %s , channel = %s!", mainFileMd5 , mainBagFullPath , channel));
        }
        File mainBagFile = new File(mainBagFullPath);
        if("all".equals(channel)) {
            channel = this.getLoanOrJr(appType);
        }
        if(channel == null) {
            throw new NullPointerException("[app file upload file address] , appType inexistence");
        }
        return this.getVersionInfoParam(channel , mainBagFile , mainFileMd5);
    }

    /**
     * 注意：贷款app比较特殊，它下面有两个包
     * @param appType
     * @return
     */
    private String getFileNamePrefix(int appType) {
        if(JR_APP_TYPE.contains(appType)) {
            return JR_FILE_NAME_PREFIX;
        }
        if(LOAN_APP_TYPE.contains(appType)) {
            if(appType == 5) {
                return LOAN_GCD_NAME_PREFIX;
            }
            if(appType == 4) {
                return LOAN_LOAN_NAME_PREFIX;
            }
        }
        return null;
    }

    private int getVersionInfoParam(String bagName , File mainBagFile , String mainFileMd5) throws IOException, InterruptedException {
        if(createAppTagFile(bagName , mainBagFile)) {
            Collection<File> files = FileUtils.listFiles(new File(packAddress), getApkFilter(mainBagFile.getName().split("\\.apk")[0].replace("(","\\(").replace(")","\\)")), DirectoryFileFilter.INSTANCE);

            files.stream().forEach(file -> {
                try {
                    java.nio.file.Path filePath = FileSystems.getDefault().getPath(file.getAbsolutePath());
                    Files.delete(filePath);
                } catch (IOException e) {
                    throw new RuntimeException(String.format("[app file upload file address] upload cdn failure , bagNume = %s",bagName ));
                }
            });
        } else {
            throw new RuntimeException(String.format("[app file upload file address] bagName = %s , create jar failure" , bagName));
        }
        return 0;
    }



    private boolean createAppTagFile(String bagName , File mainBagFile) throws IOException, InterruptedException {
        String shellCmd = String.format("java -jar %s c -f %s -pcl %s", jarPackAddress + JAR_NAME_PACK , mainBagFile.getAbsoluteFile() , bagName);
        return Runtime.getRuntime().exec(shellCmd).waitFor() == 0;
    }

    private IOFileFilter getApkFilter(final String fileNameFinal) {
        String regEx = String.format("^%s_\\d+-\\d+_\\w+_\\w+%s$", fileNameFinal, FILE_SUFFIX);
        final Pattern pattern = Pattern.compile(regEx);
        return new IOFileFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
            @Override
            public boolean accept(File file) {
                if (StringUtils.isEmpty(fileNameFinal)) {
                    return false;
                }
                Matcher matcher = pattern.matcher(file.getName());
                return matcher.matches();
            }
        };
    }

    private String getLoanOrJr(int appType) {
        if(JR_APP_TYPE.contains(appType)) {
            return JR;
        }
        if(LOAN_APP_TYPE.contains(appType)) {
            return LOAN;
        }
        return null;
    }

    private String getMd5(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        if(file != null){
            InputStream fis = null;
            try {
                fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int numRead = -1;

                while ((numRead = fis.read(buffer)) != -1) {
                    md.update(buffer, 0, numRead);
                }
            } finally {
                try {
                    if (null != fis) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        byte[] digest = md.digest();//此处得到的是md5加密后的byte类型值
        int i;
        StringBuilder sb = new StringBuilder();
        for (int offset = 0; offset < digest.length; offset++) {
            i = digest[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                sb.append(0);
            sb.append(Integer.toHexString(i));//通过Integer.toHexString方法把值变为16进制
        }
        return sb.toString();
    }
}



