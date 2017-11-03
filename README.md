# SpannableString使用记录

[![](https://jitpack.io/v/ALguojian/SpannableHelper.svg)](https://jitpack.io/#ALguojian/SpannableHelper)

<div align=center><img width="350" height="750" src="http://ouvjn19yd.bkt.clouddn.com/spannableHelper%E7%A4%BA%E6%84%8F%E5%9B%BE.png"/></div>

1.Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
2.Add the dependency
```
	dependencies {
	        compile 'com.github.ALguojian:SpannableHelper:1.0'
	}

```


用法：
```
  SpannableStringUtils spannableStringUtils = new SpannableStringUtils("飞流直下三千尺，疑是银河落九天");

         spannableStringUtils.setColor(Color.GREEN, 2, 6)
                 .setBackGround(Color.BLUE, 4, 8)
                 .setBold(6, 10)
                 .setOnClick(9, 14, Color.YELLOW)
                 .setOnClickSpanListener(new SpannableStringUtils.OnClickSpanListener() {
                     @Override
                     public void OnClickSpanListener() {

                         Toast.makeText(MainActivity.this, "点我", Toast.LENGTH_SHORT).show();
                     }
                 });

         textView.setMovementMethod(LinkMovementMethod.getInstance());
         textView.setTextSize(20);
         textView.setText(spannableStringUtils);
```

### 简介：
`spannableString`和`string`类似都是一种字符串类型，都可以用于`textview`设置为版本

`setSpan((Object what, int start, int end, int flags))`

- `what`:设置格式
- `start`：开始下标索引
- `end`：结束下表索引
- `flags`：
    - `Spanned.SPAN_INCLUSIVE_EXCLUSIVE`从起始下标到终了下标，包括起始下标
    - `Spanned.SPAN_INCLUSIVE_INCLUSIVE` 从起始下标到终了下标，同时包括起始下标和终了下标
    - `Spanned.SPAN_EXCLUSIVE_EXCLUSIVE` 从起始下标到终了下标，但都不包括起始下标和终了下标
    - `Spanned.SPAN_EXCLUSIVE_INCLUSIVE` 从起始下标到终了下标，包括终了下标


### 使用

#### 改变字体颜色
```
SpannableString spannableString = new SpannableString("文字为绿色");
ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#57caa1"));
spannableString.setSpan(colorSpan, 2, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);

```

#### 设置背景色
```
SpannableString spannableString = new SpannableString("大珠小珠落玉盘");
BackgroundColorSpan colorSpan = new BackgroundColorSpan(Color.parseColor("#57caa1"));
spannableString.setSpan(colorSpan, 2, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);
```

#### 设置文字大小
```
SpannableString spannableString = new SpannableString("大珠小珠落玉盘");
RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.2f);
spannableString.setSpan(sizeSpan01, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);
```

#### 设置文字中划线
```
SpannableString spannableString = new SpannableString("锄禾日当午，汗滴禾下土");
StrikethroughSpan span = new StrikethroughSpan();
spannableString.setSpan(span, 2, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);
```

#### 设置下划线
```
SpannableString spannableString = new SpannableString("谁知盘中餐，汗滴禾下土");
UnderlineSpan span = new UnderlineSpan();
spannableString.setSpan(span, 2, spannableString.length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);
```

#### 设置上下标
上标
```
SpannableString spannableString = new SpannableString("飞流直下三千尺，疑是银河落九天");
SuperscriptSpan span = new SuperscriptSpan();
spannableString.setSpan(span, 2, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);
```
下标
```
SpannableString spannableString = new SpannableString("飞流直下三千尺，疑是银河落九天");
SubscriptSpan span = new SubscriptSpan();
spannableString.setSpan(span, 2, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);
```

#### 设置粗体、斜体
```
SpannableString spannableString = new SpannableString("飞流直下三千尺，疑是银河落九天");
StyleSpan span1 = new StyleSpan(Typeface.BOLD);
StyleSpan span2  = new StyleSpan(Typeface.ITALIC);
spannableString.setSpan(span1, 2, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
spannableString.setSpan(span2, 5, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
textView.setHighlightColor(Color.parseColor("#57caa1"));
textView.setText(spannableString);
```

#### 添加表情
```
SpannableString spannableString = new SpannableString("飞流直下三千尺");
Drawable drawable = getResources().getDrawable(R.mipmap.ic);
drawable.setBounds(0, 0, 22, 22);
ImageSpan span = new ImageSpan(drawable);
spannableString.setSpan(span, 3, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
textView.setText(spannableString);
```

#### 设置监听事件
```
 SpannableString spannableString = new SpannableString(item.getContent());

    ClickableSpan span = new ClickableSpan() {

        @Override
        public void onClick(View widget) {

            ToastUtils.show(getActivity(), "haha");

        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(ds.linkColor);
            ds.setUnderlineText(false);
       }
    };
spannableString.setSpan(span, 2, item.getContent().length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
ForegroundColorSpan cspan = newForegroundColorSpan(Color.parseColor("#57caa1"));
spannableString.setSpan(cspan, 2, item.getContent().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
TextView textView = helper.getView(R.id.group_count);
textView.setText(spannableString);
//控制点击的时候的背景色
textView.setHighlightColor(Color.parseColor("#57caa1"));
textView.setMovementMethod(LinkMovementMethod.getInstance());
```




