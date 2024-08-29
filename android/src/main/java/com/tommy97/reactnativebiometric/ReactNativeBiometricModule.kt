package com.tommy97.reactnativebiometric

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

class ReactNativeBiometricModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {
  const val NAME = "FingerPrint"
  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    promise.resolve(a * b)
  }

  @ReactMethod
  fun showBiometric(title: String, subTitle: String, belowText: String, callback: Callback) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
        val executor = Executors.newSingleThreadExecutor()

        val biometricPrompt = BiometricPrompt.Builder(getReactApplicationContext())
            .setTitle(title)
            .setSubtitle(subTitle)
            .setNegativeButton(belowText, executor, DialogInterface.OnClickListener { dialogInterface, i ->
                // Không cần làm gì ở đây
            })
            .build()

        biometricPrompt.authenticate(CancellationSignal(), executor, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                callback.invoke(true)
            }
        })
    }
}

  companion object {
    const val NAME = "ReactNativeBiometric"
  }
}

