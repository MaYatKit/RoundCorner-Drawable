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


