import 'dart:async';
import 'package:flutter/services.dart';

class CsYoumiAd {
  static const _channel = MethodChannel('cs_youmi_ad');
  static final CsYoumiAd _instance = CsYoumiAd._internal();
  factory CsYoumiAd() => _instance;
  CsYoumiAd._internal();

  /// 初始化SDK
  Future<void> initSDK({required String appId}) async {
    return _channel.invokeMethod("init", <String, dynamic>{
      'appId': appId
    });
  }

  /// 展示积分墙
  Future<void> showOfferwallAd(String userId) {
    return _channel.invokeMethod("startOffersWall", <String, dynamic>{
      'userId': userId,
    });
  }
}
