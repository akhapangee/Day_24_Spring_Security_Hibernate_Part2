<%-- 
    Document   : index
    Created on : Mar 3, 2018, 7:54:14 PM
    Author     : Akhilesh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="http://code.jquery.com/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <a href="${SITE_URL}/login/logout">Logout</a>
            <h1>Courses</h1>
            <table id="course-table" class="table">
                <tr>
                    <th><input type="checkbox" id="select-all" ></th>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Fees</th>
                    <th>Status</th>
                </tr>
            </table>
            <div id="course-dialog" >
                <form>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" name="name" id="course-name" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Code</label>
                        <input type="text" name="code" id="course-code"  class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>Fees</label>
                        <input type="text" name="fees" id="course-fees"  class="form-control"/>
                    </div>
                </form>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $.getJSON("${SITE_URL}/api/courses",
                        function (data) {
                            var $courseTable = ("#course-table");
                            $.each(data, function (i, c) {
                                var $tr = $("<tr data-id='"+c.id+"'/>");
                                $tr.on('click', function(){
                                   $id = $(this).attr('data-id');
                                   $.getJSON('${SITE_URL}/api/courses/'+$id,function (data){
//                                       console.log(data);
                                       $("#course-name").val(data.name);
                                       $("#course-code").val(data.code);
                                       $("#course-fees").val(data.fees);
                                   });
                                });
                                $("<td/>")
                                        .append($("<input type='checkbox' name='course' class='checkbox'>"))
                                        .appendTo($tr);
                                $("<td/>").html(c.id).appendTo($tr);
                                $("<td/>").html(c.name).appendTo($tr);
                                $("<td/>").html(c.fees).appendTo($tr);
                                $("<td/>").html(c.status).appendTo($tr);
                                $("<td/>").append($("<a href='#' onclick='deleteCourse("+c.id+")' />").html("Delete")).appendTo($tr);
                                $tr.appendTo($courseTable);
                            });
                        });
                $("#select-all").on('click', function () {
                    var $selected = $(this).is(":checked");
                    console.log($selected);
                    $(".checkbox").prop('checked', $selected);
                });

            });
            function deleteCourse(id){
                if(confirm('Are you sure to delete')){
                    var $tr = $("tr[data-id="+id+"]");
                    $tr.slideUp(1000);
                    console.log($tr);
                }
            }

        </script>
    </body>
</html>
