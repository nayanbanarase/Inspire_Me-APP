# InspireMe – Motivational Quotes Android Application

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-green" />
  <img src="https://img.shields.io/badge/Language-Java-blue" />
  <img src="https://img.shields.io/badge/UI-XML-orange" />
  <img src="https://img.shields.io/badge/IDE-Android%20Studio-red" />
</p>

---

# Abstract

Motivation is essential for improving confidence, productivity, and maintaining a positive mindset. **InspireMe** is an Android-based motivational quotes application developed using **Java** and **XML** in **Android Studio**. The application provides inspirational quotes through a clean and interactive interface. It includes features such as Splash Screen, Random Quotes, Next/Previous Navigation, Favorite Quotes, Quote Sharing, Dark Mode, Text-to-Speech, Quote Image Generator, and Notifications. The project demonstrates the implementation of Android components such as Activities, Intents, SharedPreferences, Notifications, MediaStore, and Text-to-Speech APIs.

**Keywords:** Android, Java, XML, SharedPreferences, Notifications, Text-to-Speech, Motivation.

---

# 1. Introduction

Smartphones have become an important part of daily life, and mobile applications are widely used for learning, productivity, and personal development. Motivational applications encourage users by providing positive thoughts that improve confidence and reduce stress.

**InspireMe** is designed to provide users with motivational quotes through an easy-to-use Android application. It enables users to browse quotes, generate random quotes, save favorite quotes, share quotes, listen to quotes using Text-to-Speech, generate quote images, switch between Dark Mode and Light Mode, and receive motivational notifications.

---

# 2. Literature Review

Many motivational quote applications provide only basic quote viewing and sharing functionalities. Some applications require an internet connection or user registration to access premium features.

The InspireMe application focuses on providing an offline and lightweight solution. It combines multiple Android features including quote sharing, image generation, favorites, notifications, and text-to-speech within a single application, making it simple and user-friendly.

---

# 3. Methodology

The application was developed using **Android Studio** following the Android application development process.

- Designed the user interface using XML.
- Implemented application logic using Java.
- Stored motivational quotes in a String array.
- Used SharedPreferences to save favorite quotes.
- Implemented Random, Next, and Previous quote navigation.
- Added Quote Sharing using Android Intent.
- Implemented Text-to-Speech for reading quotes.
- Generated quote images using Bitmap, Canvas, and Paint.
- Added Dark Mode using Switch.
- Implemented motivational notifications.
- Tested the application on Android Emulator.

---

# 4. Implementation

## Development Environment

- IDE: Android Studio
- Programming Language: Java
- UI Design: XML
- Platform: Android

## Front-End Technologies

- XML
- TextView
- Button
- Switch
- ScrollView
- LinearLayout

## Back-End Technologies

- Java
- Android SDK

## Libraries and APIs Used

- AndroidX AppCompat
- NotificationCompat
- SharedPreferences
- TextToSpeech API
- MediaStore API
- Bitmap
- Canvas
- Paint
- Intent API

---

# Features

- Splash Screen
- Motivational Quotes
- Random Quote Generator
- Next Quote
- Previous Quote
- Share Quotes
- Favorite Quotes
- View Favorite Quotes
- Dark Mode
- Text-to-Speech
- Quote Image Generator
- Notifications

---

# Project Structure

```
InspireMe
│
├── app
│   ├── java
│   │   ├── MainActivity.java
│   │   └── Splashscreen.java
│   │
│   ├── res
│   │   ├── layout
│   │   │   ├── activity_main.xml
│   │   │   └── activity_splashscreen.xml
│   │   │
│   │   ├── drawable
│   │   ├── mipmap
│   │   └── values
│   │
│   └── AndroidManifest.xml
│
├── Gradle Scripts
│
└── README.md
```

---

# Working

1. Launch the application.
2. Splash Screen is displayed.
3. Home screen opens with motivational quotes.
4. Users can browse quotes using Next, Previous, or Random buttons.
5. Favorite quotes can be saved locally.
6. Favorite quotes can be viewed anytime.
7. Quotes can be shared using Android Intent.
8. Text-to-Speech reads the displayed quote.
9. Users can switch between Light Mode and Dark Mode.
10. Quote images can be generated and saved.
11. Notifications display motivational messages.

---

# Conclusion

The InspireMe application was successfully developed using Java and XML in Android Studio. It provides motivational quotes through a clean and interactive interface while demonstrating Android concepts such as Activities, Intents, SharedPreferences, Notifications, Text-to-Speech, Image Processing, and local storage. The application fulfills its objective of delivering daily motivation while providing a practical understanding of Android application development.

---

# Future Scope

The application can be enhanced by adding:

- Firebase Authentication
- User Login & Registration
- AI-based Quote Generator
- Quote Categories
- Search Functionality
- Multiple Language Support
- SQLite Database
- Firebase Cloud Database
- Daily Automatic Notifications
- Cloud Backup
- Voice Commands
- Quote Wallpapers

---

# References

1. Android Developers Documentation  
   https://developer.android.com

2. Android Studio Documentation  
   https://developer.android.com/studio

3. Oracle Java Documentation  
   https://docs.oracle.com/javase/

4. SharedPreferences Documentation  
   https://developer.android.com/training/data-storage/shared-preferences

5. Android Notification Documentation  
   https://developer.android.com/develop/ui/views/notifications

6. TextToSpeech API Documentation  
   https://developer.android.com/reference/android/speech/tts/TextToSpeech

7. MediaStore API Documentation  
   https://developer.android.com/reference/android/provider/MediaStore

---

# Developed By

**Nayan Shankar Banarase**

**Master of Computer Applications (MCA)**
