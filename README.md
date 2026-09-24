# Easy Words – Android app

A simple phone-first Dutch → English vocabulary app built from the supplied **Easy Words.pdf**.

## Features
- 487 source vocabulary pairs
- Learn/search all words
- Flashcards with reveal/next
- 10-question multiple-choice quiz
- Quiz progress saved locally
- Portrait-first, large-text interface

## Build
Open this folder in Android Studio (Ladybug or newer recommended), allow Gradle to sync, then Run on an Android device/emulator.

The vocabulary is stored in `app/src/main/assets/words.json` and preserves the extracted source entries.

## Build APK automatically on GitHub
1. Create a GitHub repository and upload this project.
2. Push the project to the `main` branch.
3. Open the repository's **Actions** tab and run **Build EasyWords APK**.
4. When it finishes, open the workflow run and download the **EasyWords-debug-apk** artifact.
5. Extract the artifact and install `app-debug.apk` on your Android phone.
