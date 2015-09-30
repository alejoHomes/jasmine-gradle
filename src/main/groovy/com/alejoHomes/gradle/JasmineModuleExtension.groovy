package com.alejoHomes.gradle

import groovy.json.JsonBuilder

class JasmineModuleExtension {
    
    List dependencies = ['karma','karma-jasmine@2_0', 'karma-phantomjs-launcher', 'phantomjs', 'karma-junit-reporter', 'karma-firefox-launcher']
    
    String basePath = ''
    List frameworks = ['jasmine']
    List browsers = ['PhantomJS', 'Firefox']
    List files = []
    List excludes = []
    Map additional = [:]
    
    String getConfigJavaScript() {
        Map properties = [basePath: "../${basePath}", files: files, browsers: browsers,
                          frameworks: frameworks, excludes: excludes ]

        additional.each{ properties[it.key] = it.value }

        def json = new JsonBuilder()
        json(properties)
        String configJson = json.toString()
        
        "module.exports = function(config) { config.set(${configJson}) };"
    }
}

