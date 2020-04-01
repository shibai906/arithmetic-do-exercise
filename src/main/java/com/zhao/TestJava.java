package com.zhao;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJava {


    /**
     *  java -jar apkdist-cli-all.jar c -f /Users/zhaohuan/Desktop/app/apkdist-cli-all.jar -pcl yyb
     * @param args
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        test();
        String shellCmd = String.format("java -jar /Users/zhaohuan/Desktop/app/apkdist-cli-all.jar c -f /Users/zhaohuan/Desktop/app/signed_PLATFORM_MiFinance_v7.5.3.2871(133)_release.apk -pcl xiaomi");
        Process process = Runtime.getRuntime().exec(shellCmd);
        int exitValue = process.waitFor();
        System.out.println(exitValue);
        File fileHaha = new File("/Users/zhaohuan/Desktop/app/signed_PLATFORM_MiFinance_v7.5.3.2871(133)_release_20200331-142035_xiaomi_7417ad609d27aa3e856acdf5b0746d12.apk");
        System.out.println(fileHaha.getAbsolutePath());
        Collection<File> files = FileUtils.listFiles(new File("/Users/zhaohuan/Desktop/app/"), getApkFilter(fileHaha.getName().split("\\.")[1], "xiaomi"), DirectoryFileFilter.INSTANCE);

        for (File file : files) {
            System.out.println(file.getAbsoluteFile());
        }
    }

    public static boolean yanzhengleiming(String fileName , String prefix , String channelName) {

        String regEx = String.format("^%s_\\d*+-\\d*+_%s_\\w*+.apk$", prefix, channelName, "\\.apk");
        return fileName.matches(regEx);

    }

    public static void test() {
        String regEx = String.format("^%s_\\d*+-\\d*+_%s_\\w*+.apk$", "signed_PLATFORM_MiFinance_v7\\.5\\.3\\.2871\\(133\\)_release", "360", "\\.apk");
        System.out.println(regEx);
        Pattern pattern = Pattern.compile(regEx);
        String hahha = "signed_PLATFORM_MiFinance_v7.5.3.2871(133)_release_20200325-192821_360_bd30c5c8ca587937ad5cb3a71cdb668e.apk";
        System.out.println(hahha.matches(regEx));
        System.out.println(pattern.matcher("signed_PLATFORM_MiFinance_v7.5.3.2871(133)_release_20200325-192821_360_bd30c5c8ca587937ad5cb3a71cdb668e.apk"));
    }

    private static IOFileFilter getApkFilter(final String fileNameFinal, final String channelCode) {
        String regEx = String.format("%s_\\d*+-\\d*+_%s_\\w*+.apk$", fileNameFinal, channelCode, "\\.apk");
        final Pattern pattern = Pattern.compile(regEx);
        return new IOFileFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
            @Override
            public boolean accept(File file) {
                if (StringUtils.isEmpty(fileNameFinal) || StringUtils.isEmpty(channelCode)) {
                    return false;
                }
                Matcher matcher = pattern.matcher(file.getName());
                return matcher.matches();
            }
        };
    }


}


