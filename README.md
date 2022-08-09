SlideTexts
===============

It allows you to get a better view by swiping the texts.

![SlideTexts](https://github.com/zekibiyikli/SlideTexts/blob/main/sources/slidetexts.gif?raw=true)

Gradle
------

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```
dependencies {
    ...
    implementation 'com.github.zekibiyikli:SlideTexts:v1.0.1'
}
```

Usage
-----
xml
```
 <com.zekibiyikli.slidetexts.baseLayout
        android:id="@+id/lytSlideTexts"
        android:layout_width="0dp"
        android:layout_height="200dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

    </com.zekibiyikli.slidetexts.baseLayout>
```
-----------
Code
```
 var layout=findViewById<ConstraintLayout>(R.id.lytSlideTexts)
 var slideTexts=SlideTexts()
 var strings= arrayListOf("Title 1","Title 2","Title 3","Title 4","Title 5")
 slideTexts.init(this,strings,layout)
 slideTexts.start()

```

Features
-----------
You can change textcolor
```
 slideTexts.setColor(
            selectColor = R.color.selectcolor,
            unselectColor = R.color.unselectcolor)
```
-----------
You can change textsize
```
 slideTexts.setTextSize(
            selectSize = 25f,
            unselectSize = 20f)
```
-----------
You can change text font
```
  slideTexts.setFont(resources.getFont(R.font.fontName))

```

-----------
You can change speed
```
  slideTexts.setMillis(1000)

```


Changelog
---------
* **1.0.0**
    * Initial release

License
-------

    Copyright 2021 - Zeki Bıyıklı

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.