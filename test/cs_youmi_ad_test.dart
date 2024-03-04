import 'package:cs_youmi_ad/cs_youmi_ad.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  // const MethodChannel channel = MethodChannel('cs_youmi_ad');

  TestWidgetsFlutterBinding.ensureInitialized();

  // setUp(() {
  //   channel.setMockMethodCallHandler((MethodCall methodCall) async {
  //     return '42';
  //   });
  // });

  // tearDown(() {
  //   channel.setMockMethodCallHandler(null);
  // });

  test('getPlatformVersion', () async {
    CsYoumiAd().initSDK(appId: "appId");
  });
}
