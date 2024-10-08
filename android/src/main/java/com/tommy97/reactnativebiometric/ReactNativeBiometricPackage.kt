package com.tommy97.reactnativebiometric

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager


class ReactNativeBiometricPackage : ReactPackage {
  // override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
  //   return listOf(ReactNativeBiometricModule(reactContext))
  // }
  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    val modules = mutableListOf<NativeModule>()
    modules.add(ReactNativeBiometricModule(reactContext))
    return modules
}

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    return emptyList()
  }
}
