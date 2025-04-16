import 'dart:async';
import 'package:flutter/services.dart';

class CsYoumiAd {
  static const _channel = MethodChannel('cs_youmi_ad');
  static final CsYoumiAd _instance = CsYoumiAd._internal();
  factory CsYoumiAd() => _instance;
  CsYoumiAd._internal();

  Future<void> initSDK({required String appId}) async {
    return _channel.invokeMethod("init", <String, dynamic>{
      'appId': appId
    });
  }

  Future<void> showOfferwallAd(String userId) {
    return _channel.invokeMethod("startOffersWall", <String, dynamic>{
      'userId': userId,
    });
  }
}
