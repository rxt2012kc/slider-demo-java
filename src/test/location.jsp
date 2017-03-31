<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
  <title>地图显示</title>
  <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main.css?v=1.0" />
  <script src="http://webapi.amap.com/maps?v=1.3&key=eecc344f9d2a87f126ac375992a965dd"></script>
</head>
<body>
  <div id="mapContainer"></div>
  <script>
    navigator.geolocation.getCurrentPosition(geo_success, geo_error);

    function geo_success(position) {
      var map = new AMap.Map('mapContainer', {
        // 设置中心点
        center: [position.coords.longitude, position.coords.latitude],

        // 设置缩放级别
        zoom: 13
      });

      var marker = new AMap.Marker({
        //复杂图标
        icon: new AMap.Icon({
            //图标大小
            size: new AMap.Size(28, 37),
            //大图地址
            image: "http://webapi.amap.com/images/custom_a_j.png",
            imageOffset: new AMap.Pixel(-28, 0)
        }),
        //在地图上添加点
        position: [position.coords.longitude, position.coords.latitude]
      });

      marker.setMap(map);
    }

    function geo_error(msg) {
      console.log(msg.code, msg.message);
    }
  </script>
</body>
</html>