# RoundCornerDrawable
A Drawable which can make a bitmap has rounded corner and showed by centerCrop, fitXY and center,
without override ImageView

## Origin
Cause I found UIL and Glide both can not meet my require that make a bitmap showed with rounded
corner and centerCrop in the same time, Fresco is too big though it can do this.

So I try to finish it by extending Drawble.

## Explanation
RoundCornerDrawable(Bitmap bitmap, int cornerRadius, int margin, Type type)
Y

