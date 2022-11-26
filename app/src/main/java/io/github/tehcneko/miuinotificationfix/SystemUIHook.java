package io.github.tehcneko.miuinotificationfix;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SystemUIHook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (loadPackageParam.packageName.equals("com.android.systemui")) {
            try {
                XposedHelpers.setStaticBooleanField(XposedHelpers.findClass("com.android.systemui.statusbar.notification.NotificationSettingsManager", loadPackageParam.classLoader), "USE_WHITE_LISTS", false);
            } catch (Throwable t) {
                XposedBridge.log(t);
            }
        }
    }

}
