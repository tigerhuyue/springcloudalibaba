package com.winsion.net.bootstrap.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by zhoucong on 16/2/25
 */
public class ClasspathPackageScanner {
    private String basePackage;
    private ClassLoader classLoader;

    public ClasspathPackageScanner(String basePackage) {
        this.basePackage = basePackage;
        this.classLoader = this.getClass().getClassLoader();
    }

    public ClasspathPackageScanner(String basePackage, ClassLoader classLoader) {
        this.basePackage = basePackage;
        this.classLoader = classLoader;
    }

    public List<String> scan() throws IOException {
        return scan(basePackage, new ArrayList<>());
    }

    public List<String> scan(String basePackage, List<String> nameList) throws IOException {
        String splashPath = StringUtil.dotToSplash(basePackage);

        URL url = classLoader.getResource(splashPath);
        if (url == null) {
            return nameList;
        }

        String filePath = StringUtil.getRootPath(url);

        List<String> names;
        if (isJarFile(filePath)) {
            names = readFromJarFile(filePath, splashPath);
        } else {
            names = readFromDirectory(filePath);
        }

        if (names != null) {
            for (String name : names) {
                if (isClassFile(name)) {
                    String className = StringUtil.splashToDot(StringUtil.trimExtension(name));
                    if (!className.contains(".")) {
                        className = basePackage + "." + className;
                    }
                    nameList.add(className);
                } else {
                    scan(basePackage + "." + name, nameList);
                }
            }
        }

        return nameList;
    }

    private List<String> readFromJarFile(String jarPath, String splashedPackageName) throws IOException {
        JarInputStream jarIn = new JarInputStream(new FileInputStream(jarPath));
        JarEntry entry = jarIn.getNextJarEntry();

        List<String> nameList = new ArrayList<>();
        while (null != entry) {
            String name = entry.getName();
            if (name.startsWith(splashedPackageName) && isClassFile(name)) {
                nameList.add(name);
            }
            if (isJarFile(name)) {
                nameList.addAll(readFromJarFile(this.getClass().getResourceAsStream("/" + name), splashedPackageName));
            }

            entry = jarIn.getNextJarEntry();
        }

        return nameList;
    }

    private List<String> readFromJarFile(InputStream inputStream, String splashedPackageName) throws IOException {
        JarInputStream jarIn = new JarInputStream(inputStream);
        JarEntry entry = jarIn.getNextJarEntry();

        List<String> nameList = new ArrayList<>();
        while (null != entry) {
            String name = entry.getName();
            if (name.startsWith(splashedPackageName) && isClassFile(name)) {
                nameList.add(name);
            }
            if (isJarFile(name)) {
                nameList.addAll(readFromJarFile(this.getClass().getResourceAsStream(name), splashedPackageName));
            }

            entry = jarIn.getNextJarEntry();
        }

        return nameList;
    }

    private List<String> readFromDirectory(String path) {
        File file = new File(path);
        String[] names = file.list();

        if (null == names) {
            return null;
        }

        return Arrays.asList(names);
    }

    private boolean isClassFile(String name) {
        return name.endsWith(".class");
    }

    private boolean isJarFile(String name) {
        return name.endsWith(".jar");
    }

    private static class StringUtil {
        public static String getRootPath(URL url) {
            String fileUrl = url.getFile();
            int pos = fileUrl.indexOf('!');

            if (-1 == pos) {
                return fileUrl;
            }

            return fileUrl.substring(5, pos);
        }

        public static String dotToSplash(String name) {
            return name.replaceAll("\\.", "/");
        }

        public static String splashToDot(String name) {
            return name.replaceAll("/", "\\.");
        }

        public static String trimExtension(String name) {
            int pos = name.indexOf('.');
            if (-1 != pos) {
                return name.substring(0, pos);
            }

            return name;
        }

        public static String trimURI(String uri) {
            String trimmed = uri.substring(1);
            int splashIndex = trimmed.indexOf('/');

            return trimmed.substring(splashIndex);
        }
    }
}
