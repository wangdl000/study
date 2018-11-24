## 【HTML 教程】  

http://www.w3school.com.cn/html/index.asp


## html常用标签和属性 
### 常见的标签属性  

1. src = "地址"； 
2. href = "地址"； 
3. target = "_self/_blank/_parent/_top/framename"; 链接的打开方式。  
4. value = "值"；  
5. alt = "加载失败显示时显示的文本内容"；  
6. title = "鼠标滑过显示内容"；  
7. type = "按钮类型"；常见于input标签；
8. name = "名字"；  
9. method = "提交方式"；常见于表单提交，常用get/post;  
10. action = "服务器文件"； 常见于表单提交，表单内容要上传到的服务器文件；  
11. enctype = "编码方式"；常见于表单提交，在发送到服务器之前应该如何对表单数据进行编码。  
        application/x-www-form-urlencoded：在发送前编码所有字符（默认）；  
        multipart/form-data：不对字符编码。在使用包含文件上传控件的表单时，必须使用该值；  
        text/plain  空格转换为 "+" 加号，但不对特殊字符编码。  
12. for = "某标签的ID值"；表单label标签常用，用于将label标签及内容关联于某个特定ID的标签。  
13. rows = "数字"；行数，textarea常用  
14. cols = "数字"；列数，textarea常用  
15. disabled; 按钮禁用  
16. selected = "selected"; select标签常用，指：默认被选中。  
17. checked = "checked"; 单/多选框常用，指：默认被选中。  
18. multiple = "multiple"; select标签常用，使下拉列表框可以多选。  
19. width = "数字"；iframe，video等标签可以用。可以设置样式宽，一般默认单位为px；  
20. height = "数字"；iframe，video等标签可以用。可以设置样式高，一般默认单位为px；  
21. loop = "数字"; 循环次数，marquee(跑马灯/弹幕)常用  
22. direction = "left/right"; 滚动方向。marquee常用  
23. bgcolor = "背景色"；marquee常用  
24. scrollamount = "数字"；滚动速度。marquee常用  
25. scrolldelay = "时间(毫秒)"；延时时间。marquee常用  
26. behavior = "scroll/clide/alternate"; 滚动方式。marquee常用  
27. autoplay = "autoplay"; 自动播放。video/audio标签常用  
28. controls = "controls"; 显示控制条。video/audio标签常用  
29. loop = "loop"; 循环播放。video/audio标签常用  
30. preload; 预加载。video/audio标签常用，有autoplay时可忽略。  
31. muted; 静音。video/audio标签常用  
32. poster = "图片地址"； 封面。video标签常用  

## 不常见但常用的属性  

2-1 innerHTML属性。

obj.innerHTML;用于获取或修改标签元素里面的内容。  
1
<div id="div1">123</div>
<script type="text/javascript">
    var oDiv = document.getElementById("div1");
    console.log(oDiv.innerHTML); // 123
    oDiv.innerHTML = "abc"; // 该div里面的值变为abc；
</script>

2-2 style属性  

obj.style.属性;用于获取或修改标签的css样式。  
1
<div id="div1" style="width:100px;">123</div>
<script type="text/javascript">
    var oDiv = document.getElementById("div1");
    console.log(oDiv.style.width); // 100px
    oDiv.style.width = "200px"; // 该div宽变为200px；
</script>

其他样式获取/修改方法类似。

2-3 className属性  

obj.className; 获取/修改标签的class名，因为class为关键字，所以用className；
1
<div id="div1" class="box1">123</div>
<script type="text/javascript">
    var oDiv = document.getElementById("div1");
    console.log(oDiv.className); // box1
    oDiv.className = "box2"; // 该div的class名改为box2；
</script>

2-4 自定义属性  

obj.自定义属性名; 获取/修改/添加标签的某个属性值  
1
    <div id="div1">123</div>
    < script type="text/javascript">
    var oDiv = document.getElementById("div1");  
    oDiv.index = 0; // 给这个div增加一个index属性，并设值为0；
    console.log(oDiv.index); // 0。可获取到这个index。
    <script>

注：属性名可以自己定义，但是不要和已有或关键字冲突。  
