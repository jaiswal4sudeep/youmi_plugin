# 📦 CsYoumiAd Plugin (Flutter)

A Flutter plugin to integrate the **CsYoumiAd** SDK for showing Offerwall ads. This plugin allows you to easily initialize the SDK and display Offerwall ads to your users.

---

## ✅ Features

- ✅ Initialize the CsYoumiAd SDK
- ✅ Show Offerwall ads
- ✅ Easy integration and setup

---

## 📦 Installation

Add the plugin to your `pubspec.yaml`:

```yaml
dependencies:
  cs_youmi_ad_plugin:
    path: ./path_to_your_plugin_directory
```

> Replace the path with the correct local directory for your plugin.

---

## ⚙️ Android Setup

1. Add the required dependencies in your `build.gradle` file.

2. Add necessary permissions and metadata in `AndroidManifest.xml`.

---

## 🧑‍💻 Usage

### 1️⃣ Initialize SDK

```dart
await CsYoumiAd().initSDK(appId: 'your_app_id');
```

---

### 2️⃣ Show Offerwall Ad

```dart
await CsYoumiAd().showOfferwallAd('your_user_id');
```

---

## 📄 Method Summary

| Method                  | Description                              |
|-------------------------|------------------------------------------|
| `initSDK(appId)`         | Initializes the CsYoumiAd SDK            |
| `showOfferwallAd(userId)`| Shows the Offerwall ad for a specific user |

---

## 🧪 Testing Tips

- Ensure that you are passing valid `appId` and `userId` values.
- Test the Offerwall ad functionality on a real device.

---

## 📃 License

MIT License — free to use, modify, and distribute.