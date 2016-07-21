# RoundCornerDrawable
A Drawable which can make a bitmap has rounded corner and showed by centerCrop, fitXY and center,
without overriding ImageView

![Screenshot](https://github.com/417704684/RoundCornerDrawable/blob/master/example.jpg)

## Origin
Cause I found UIL and Glide both can not meet my require that make a bitmap showed with rounded
corner and centerCrop in the same time, Fresco is too big though it can do this.

So I try to finish it by extending Drawble.

## Usage
```java
//new a RoundCornerDrawable and put your bitmap in it
RoundCornerDrawable drawable = new RoundCornerDrawable(bitmap, cornerRadius, margin, RoundCornerDrawable.Type.centerCrop);
```

```java
//set RoundCornerDrawable for a ImageView where you want to show
imageView.setImageDrawable(drawable);
```

## License
Copyright 2016 Nico Ma

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

