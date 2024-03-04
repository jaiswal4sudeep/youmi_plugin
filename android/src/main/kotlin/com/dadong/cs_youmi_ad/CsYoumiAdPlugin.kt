package com.dadong.cs_youmi_ad

import androidx.annotation.NonNull
import android.app.Activity
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import net.youmi.overseas.android.YoumiOffersWallSdk


/** CsYoumiAdPlugin */
class CsYoumiAdPlugin: FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
  var activity: Activity? = null

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "cs_youmi_ad")
    channel.setMethodCallHandler(this)
  }

  fun OnMethodCallHandler(method: String, args: Map<String, Any>?) {
    try {
      activity?.runOnUiThread(Runnable { channel.invokeMethod(method, args) });
    } catch (e: Exception) {
      Log.e("flutter_Youmi", "Error $e");
    }
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "init") {
      val appId: String = call.argument<String>("appId") ?: return;
      YoumiOffersWallSdk.init(activity?.application, appId);
    } else if (call.method == "startOffersWall") {
      val userId: String = call.argument<String>("userId") ?: return;
      YoumiOffersWallSdk.startOffersWall(activity, userId);
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null);
  }

  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    activity = binding.activity;
  }

  override fun onDetachedFromActivityForConfigChanges() {}

  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    activity = binding.activity;
  }

  override fun onDetachedFromActivity() {}
}
