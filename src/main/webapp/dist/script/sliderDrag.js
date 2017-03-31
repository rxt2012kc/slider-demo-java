/*
 * @filename sliderDrag.js
 * @author fy[2016年8月19日15:10:34]
 * @update fy[2016年8月19日15:10:34]
 * @version v1.0
 * @description 滑动验证
 * @基于zepto/jquery
 */

/*
* 2016年8月19日15:10:34
* V 1.0 初次提交 滑动验证组件,感谢 @<傀儡 娃娃> 妹子的辛勤工作。 
* 2016年12月12日15:17:34
* V 1.1 增加 reset方法. 
* 2016年12月13日15:33:14
* V 1.2 将验证是触发条件改为touchend触发，好处1.防止恶意拖动，2.优化页面响应速度，3.优化内存. 
*/

//滑动验证
var SliderUnlock =(function (){
    function _init(ele,callback){
        Slider(ele,callback)
    };
    function Slider(e,callback) {
        var e = $(e) || $;
        var x, 
            Slider = this, 
            isMove = false, 
            success = false,
            defaults = {};
        var options = $.extend(defaults, options);
        //添加背景，文字，滑块
        var html = '<div class="drag_bg"></div>'+
                    '<div class="drag_text" onselectstart="return false;" unselectable="on">拖动滑块验证</div>';
        this.append(html);
        
        var $handler = drag.find('#handler');
        var $matchArea = drag.find('#matchArea');
        var $slider = drag.find('.u-slider');
        var $drag_bg = drag.find('.drag_bg');
        var text = drag.find('.drag_text');
        var sWidth = 500; // 获取整个滑动轨道宽度
        var hWidth = $handler.width(); // 获取滑块的宽度，即可放置匹配区域的下限
        var mWidth = $matchArea.width(); // 获取匹配区域的宽度
        var maxWidth = sWidth - mWidth;  // 能滑动的最大间距
        var eWide = Math.floor(Math.random() * (maxWidth - hWidth + 1) + hWidth); //获取可放置匹配区域的区域
        $matchArea.css("left", eWide);

        // 获取鼠标点击前光标的x，y位置
        $(document).mousemove(function(e) {
            var _x = e.pageX;
            var _y = e.pageY;
            console.log("鼠标点击前上下文移动时x，y的位置：" + _x + "," + _y + ", Id:" + Id);

        });

        // 获取鼠标按下时候的x轴的位置
        $handler.mousedown(function(e){
            isMove = true;
            console.log(e.pageX);
            // 相对于浏览器的位置减去滑块的初始位置
            x = e.pageX - parseInt($handler.css('left'), 10);
            console.log("鼠标按下时候的x轴的位置：" + x + ", Id:" + Id);
        });
        
        //鼠标指针在上下文移动时，移动距离大于0小于最大间距，滑块x轴位置等于鼠标移动距离
        $(document).mousemove(function(e) {
            if (success) {
                isMove = false;
            } else {
                isMove = true; 
            };
            var e = event || window.event;
                eStart = e.pageX; //起始位置
                eLeft = $handler.position().left; 
            var _x = e.pageX - x;
            console.log("鼠标上下文移动时x轴的位置：" + _x + ", Id:" + Id);
            if (isMove) {
                if (_x > 0 && _x <= maxWidth) {
                    $handler.css({'left': _x});
                    $drag_bg.css({'width': _x});
                     //鼠标指针移动距离达到最大时清空事件
                } 
                // else if (_x > maxWidth){ 
                //     dragOk();
                // }
            }
        }).mouseup(function(e) {
            isMove = false;
            // var _x = e.pageX - x;
            // //鼠标松开时，如果没有达到最大距离位置，滑块就返回初始位置
            // if(_x < maxWidth){ 
            //     $handler.css({'left': 0});
            //     // drag_bg.css({'width': 0});
            // }
            var e = event || window.event;
                eOffsetX = e.pageX - eStart,
                disX = eLeft + eOffsetX,
                ppLeft = parseInt($matchArea.css('left')),
                errorLeft = ppLeft - 10,
                errorRight = ppLeft + 10;
            if (disX <= 0) {
                disX = 0;
            } else if (disX >= maxWidth) {
                disX = maxWidth;
            } else if (disX >= errorLeft && disX <= errorRight) { //在可误差范围内
                disX = eWide;
                $handler.css("left", disX + "px");
                // console.log(disX)
                isMatch();
            } else {
                $handler.css({'left': 0});
                $drag_bg.css({'width': 0});
            }
        });
        function isMatch(){
            var tdisX = $handler.position().left;
            // console.log(tdisX)
            if(tdisX >= errorLeft && tdisX <= errorRight){
                $handler.addClass("isMatched").css("left",eWide+"px");
                $(".isMatched").text("ok");
                success = true;
                callback();
            }
        }
    };
    function Reset(ele,callback){
        var drag = $(ele);
        // callback = callback || function(){},
        // $matchArea = ele.find("#matchArea"),
        // $handler = ele.find("#handler"),
        // tWidth = ele.width(), //获取整个滑动轨道宽度
        // hWidth = $handler.width(), //获取滑块的宽度，即可放置匹配区域的下限
        // mWidth = $matchArea.width(), //获取匹配区域的宽度
        // maxWidth = tWidth - mWidth, //可放置匹配区域的上限
        // eWide = Math.floor(Math.random()*(maxWidth-hWidth+1)+hWidth); //获取可放置匹配区域的区域

        // $handler.text('|||').css("left","0px").removeClass("isMatched  isMove");
        // $matchArea .css("left",eWide);
        // callback();
        // _init(ele)

        var x, 
            isMove = false, 
            success = false,
            defaults = {};
        var options = $.extend(defaults, options);
        //添加背景，文字，滑块

        // var html = '<div class="drag_bg"></div>'+
        //             '<div class="drag_text" onselectstart="return false;" unselectable="on">拖动滑块验证</div>';
        //             '<div class="handler handler_bg"></div>';
        // drag.append(html);
        
        var $handler = drag.find('#handler');
        var $matchArea = drag.find('#matchArea');
        var $slider = drag.find('＃slider');
        var $drag_bg = drag.find('.drag_bg');
        var $text = drag.find('.drag_text');
        $text.text("拖动滑块验证");
        var sWidth = 500; // 获取整个滑动轨道宽度
        var hWidth = $handler.width(); // 获取滑块的宽度，即可放置匹配区域的下限
        var mWidth = $matchArea.width(); // 获取匹配区域的宽度
        var maxWidth = sWidth - hWidth;  // 能滑动的最大间距
        var eWide = Math.floor(Math.random() * (maxWidth - hWidth + 1) + hWidth); //获取可放置匹配区域的区域
        $matchArea.css("left", eWide);
        $handler.text('|||').css("left","0px").removeClass("isMatched  isMove");
        $matchArea .css("left",eWide);

        // 获取鼠标点击前光标的x，y位置
        $(document).mousemove(function(e) {
            var _x = e.pageX;
            var _y = e.pageY;
            console.log("鼠标点击前上下文移动时x，y的位置：" + _x + "," + _y + ", Id:" + Id);

        });

        // 获取鼠标按下时候的x轴的位置
        $handler.mousedown(function(e){
            isMove = true;
            console.log(e.pageX);
            // 相对于浏览器的位置减去滑块的初始位置
            x = e.pageX - parseInt($handler.css('left'), 10);
            console.log("鼠标按下时候的x轴的位置：" + x + ", Id:" + Id);
        });
        
        // 鼠标指针在上下文移动时，移动距离大于0小于最大间距，滑块x轴位置等于鼠标移动距离
        $handler.mousemove(function(e) {
            if (success) {
                isMove = false;
            } else {
                isMove = true; 
            };
            var e = event || window.event;
                eStart = e.pageX; //起始位置
                eLeft = $handler.position().left; 
            var _x = e.pageX - x;
            // var _x = e.pageX;
            console.log("鼠标上下文移动时x轴的位置：" + _x + ", Id:" + Id);
            if (isMove) {
                if (_x > 0 && _x <= maxWidth) {
                    $handler.css({'left': _x});
                    $drag_bg.css({'width': _x});
                     //鼠标指针移动距离达到最大时清空事件
                } 
                // else if (_x > maxWidth){ 
                //     dragOk();
                // }
            }
        }).mouseup(function(e) {
            isMove = false;
            // var _x = e.pageX - x;
            // //鼠标松开时，如果没有达到最大距离位置，滑块就返回初始位置
            // if(_x < maxWidth){ 
            //     $handler.css({'left': 0});
            //     // drag_bg.css({'width': 0});
            // }
            var e = event || window.event;
                eOffsetX = e.pageX - eStart,
                disX = eLeft + eOffsetX,
                ppLeft = parseInt($matchArea.css('left')),
                errorLeft = ppLeft - 10,
                errorRight = ppLeft + 10;
            if (disX <= 0) {
                disX = 0;
            } else if (disX >= maxWidth) {
                disX = maxWidth;
            } else if (disX >= errorLeft && disX <= errorRight) { //在可误差范围内
                disX = eWide;
                $handler.css("left", disX + "px");
                // console.log(disX)
                isMatch();
            } else {
                $handler.css({'left': 0});
                $drag_bg.css({'width': 0});
                $handler.unbind('mousedown');
                $(document).unbind('mousemove');
                $(document).unbind('mouseup');
                // $('#reset').click(function(event) {
                //     SliderUnlock.Reset("#slider");
                //     // $('#slider').drag();
                // });
                $('#reset').click();
                console.log("reset click");     
            }
        });
        function isMatch() {
            var tdisX = $handler.position().left;
            // console.log(tdisX)
            if(tdisX >= errorLeft && tdisX <= errorRight) {
                $handler.addClass("isMatched").css("left", eWide+"px");
                $(".isMatched").text("ok");
                success = true;
                // callback();
                $text.text('验证通过');
                // drag.css({'color': '#fff'});
                $handler.unbind('mousedown');
                $(document).unbind('mousemove');
                $(document).unbind('mouseup');
            }
    };
    };
    
    return {
        Reset:Reset
        // Slider:Slider
    }
})();
