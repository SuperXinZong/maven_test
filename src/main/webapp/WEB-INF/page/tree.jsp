<%--
  Created by IntelliJ IDEA.
  User: dianit
  Date: 2020/6/30
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/test/res/ztree/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="/test/res/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/test/res/ztree/jquery.ztree.all.min.js"></script>
    <script type="text/javascript">
        $(function () {
            loadCheck();
            // loadAsync();
            // loadAll();
        })

        // 异步
        function loadAsync() {
            var setting = {
                async: {
                    enable: true,
                    url:"/test/area/getAsync",
                    autoParam:["id"]
                },
                data: {
                    key :{
                        name: "areaName"
                    }
                }
            };
            $.fn.zTree.init($("#tree"), setting);
        }

        function loadCheck() {
            var setting = {
                check: {
                    enable: true
                },
                data: {
                    simpleData: {
                        enable: true,
                        pIdKey: "areaParentId",
                        rootPId: 0
                    },
                    key :{
                        name: "areaName"
                    }
                }
            };
            $.get("/test/area/getAll", function (result) {
                // Ztree 加载三要素 显示DOM容器 树的配置 数据
                $.fn.zTree.init($("#tree"), setting, result.data);
            });
        }

        // 全部
        function loadAll() {
            var setting = {
                data: {
                    simpleData: {
                        enable: true,
                        pIdKey: "areaParentId",
                        rootPId: 0
                    },
                    key :{
                        name: "areaName"
                    }
                }
            };
            $.get("/test/area/getAll", function (result) {
                // Ztree 加载三要素 显示DOM容器 树的配置 数据
                $.fn.zTree.init($("#tree"), setting, result.data);
            });
        }
        
        function getNode() {
            // 获取选中节点
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var selectNode = treeObj.getSelectedNodes()[0];
            var ids = "";
            // 是父节点
            if (selectNode.isParent) {
                // 获取所有后代节点
                ids = getChildNode(selectNode);
            }
            ids += selectNode.areaName;
            console.log(ids);
        }

        // 递归
        function getChildNode(parentNode) {
            // 获取全部子节点
            var childList = parentNode.children;
            var ids = "";
            for (var i = 0; i < childList.length; i++) {
                var child = childList[i];
                ids += child.areaName + ",";
                if (child.isParent) {
                    ids += getChildNode(child);
                }
            }
            return ids;
        }
        
        function getChecked() {
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodes = treeObj.getCheckedNodes();
            var ids = "";
            for (var i = 0; i < nodes.length; i++) {
                ids += nodes[i].id + ",";
            }
            console.log(ids);
        }
    </script>
</head>
<body>
<button type="button" onclick="getNode()">后代</button>
<button type="button" onclick="getChecked()">勾选</button>
<div id="tree" class="ztree"></div>
</body>
</html>
