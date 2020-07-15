<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/test/res/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        // 页面加载事件
        $(function () {
            // 获取省数据
            $.get("/test/area/getArea/0", function (result) {
                if (result.code == 200) {
                    var provinceList = result.data;
                    var provinceHtml = "";
                    for (var i = 0; i < provinceList.length; i++) {
                        var province = provinceList[i];
                        provinceHtml += "<option value='"+province.id+"'>"+province.areaName+"</option>";
                    }
                    $("#province").html(provinceHtml);
                    // 联动市
                    loadCity(provinceList[0].id);
                }
            });
        });

        /**
         * 获取市数据
         * @param parentId 父ID
         */
        function loadCity(parentId) {
            $.get("/test/area/getArea/" + parentId, function (result) {
                if (result.code == 200) {
                    var cityList = result.data;
                    var cityHtml = "";
                    for (var i = 0; i < cityList.length; i++) {
                        var city = cityList[i];
                        cityHtml += "<option value='"+city.id+"'>"+city.areaName+"</option>";
                    }
                    $("#city").html(cityHtml);
                    // 联动区域
                    loadArea(cityList[0].id);
                }
            });
        }

        /**
         * 加载区域数据
         * @param parentId 父ID
         */
        function loadArea(parentId) {
            $.get("/test/area/getArea/" + parentId, function (result) {
                if (result.code == 200) {
                    var areaList = result.data;
                    var areaHtml = "";
                    for (var i = 0; i < areaList.length; i++) {
                        var area = areaList[i];
                        areaHtml += "<option value='"+area.id+"'>"+area.areaName+"</option>"
                    }
                    $("#area").html(areaHtml);
                }
            });
        }

    </script>
</head>
<body>
省：<select id="province" onchange="loadCity(this.value)"></select>
市：<select id="city" onchange="loadArea(this.value)"></select>
县：<select id="area"></select>
</body>
</html>
