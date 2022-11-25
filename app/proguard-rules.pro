# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#### RETROFIT ######################################################################################
# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-keep class retrofit.** { *; }

-dontwarn okhttp3.**
-dontwarn okio.**

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**

-dontwarn com.squareup.okhttp.**
-dontwarn retrofit.**
-dontwarn retrofit2.**
-dontwarn retrofit2.Platform$Java8
-dontwarn org.springframework.**