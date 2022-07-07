package com.wx.utils;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

public class DocsGenerator {
    public static void main(String[] args){
        DocsConfig  config = new DocsConfig();
        config.setProjectPath(System.getProperty("user.dir")); // root project path
        config.setProjectName("wxserver"); // project name
        config.setApiVersion("V1.0");       // api version
        config.setDocsPath("api"); // api docs target path
        config.setAutoGenerate(Boolean.TRUE);  // auto generate
        Docs.buildHtmlDocs(config); // execute to generate
    }
}
