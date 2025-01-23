# Dice Roller App

## Overview
The Dice Roller App is an interactive Android application built using Jetpack Compose. It allows users to 
roll a virtual dice, featuring animations and sound effects for an engaging user experience. 
This app demonstrates modern Android development practices, including state management with `ViewModel` and 
UI interactions using Jetpack Compose.

---

## Features
- **Dice Rolling**: Roll the dice at the press of a button, with the result displayed on the dice face.
- **Animations**: Realistic animations, including rotation, scaling, and fading effects.
- **Sound Effects**: A dice-rolling sound effect synchronized with the animation.
- **Modern UI**: Built entirely with Jetpack Compose for a clean and responsive design.

---

## Project Structure
```
app/
├── src/main/java/com/example/dicerrollerapp
│   ├── MainActivity.kt          # Entry point of the app
│   ├── viewmodel
│   │   └── DiceViewModel.kt    # Handles dice state and rolling logic
│   └── ui
│       └── DiceWithButtonAndImage.kt  # Composable for the dice UI
├── res/
│   ├── drawable/               # Dice face images (e.g., dice_1.png)
│   ├── raw/                    # Sound file (e.g., dice_roll.mp3)
│   └── values/strings.xml      # String resources
├── build.gradle.kts            # App-level Gradle configuration
├── README.md                   # Documentation
└── .gitignore                  # Git ignore rules
```

---

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/domoniquestaple/dicerollerapp.git
   ```
2. Open the project in Android Studio.
3. Sync the Gradle files.
4. Run the app on an emulator or physical device.

---

## Usage
1. Launch the app.
2. Tap the **Roll Dice** button to roll the dice.
3. Enjoy the animations and sound effects as the dice rolls.

---

## Dependencies
Add the following dependencies in your `build.gradle.kts` file:
```kotlin
implementation("androidx.compose.ui:ui:1.4.3")
implementation("androidx.compose.material3:material3:1.1.0")
implementation("androidx.activity:activity-compose:1.7.2")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
```

---

## Features in Detail
- **Animations**: The dice rotates, scales up, and fades during the rolling animation for a visually appealing effect.
- **Sound Effects**: A realistic dice roll sound plays, synchronized with the animation.
- **State Management**: The app uses `ViewModel` to manage state, ensuring data consistency and lifecycle awareness.

---


### Author
**Domonique Staple**  
Feel free to reach out for suggestions, feedback, or collaboration opportunities!

